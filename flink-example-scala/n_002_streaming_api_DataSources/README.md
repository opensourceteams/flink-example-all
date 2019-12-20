# Flink streaming api source 方式

## 更多资源
- https://github.com/opensourceteams/flink-example-all

## 简述
- Flink Source方式
- fromCollection
- fromElements
- readTextFile
- socket
- sourceFunction

#### fromCollection
```
package com.opensourceteams.bigdata.flink.example.streaming.api.sources.fromCollection

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment, _}

case class Animal(id:String,name:String)
object Run {

  def main(args: Array[String]): Unit = {

    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val dataStream:DataStream[Animal] = env.fromCollection(List(
      Animal("cat","猫"),
      Animal("dog","狗"),
      Animal("bird","鸟")
    ))
    dataStream.print()
    env.execute("test")
  }
}

```


#### fromElements
```
package com.opensourceteams.bigdata.flink.example.streaming.api.sources.fromElements

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.api.scala._

case class Animal(id:String,name:String)
object Run {

  def main(args: Array[String]): Unit = {

    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val dataStream:DataStream[String] = env.fromElements("a","b","c")


    dataStream.print()
    env.execute("test")
  }
}

```

#### readTextFile
```
package com.opensourceteams.bigdata.flink.example.streaming.api.sources.readTextFile

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}

case class Animal(id:String,name:String)
object Run {

  def main(args: Array[String]): Unit = {

    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val dataStream:DataStream[String] = env.readTextFile("D:\\workspaces\\bigdata\\flink\\flink-example-all/data/text/text.txt")


    dataStream.print()
    env.execute("test")
  }
}

```
#### socket
- nc
```
nc -L -p 9000
```

```
package com.opensourceteams.bigdata.flink.example.streaming.api.sources.socket

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}

case class Animal(id:String,name:String)
object Run {

  def main(args: Array[String]): Unit = {

    val hostname:String = "localhost"
    val port:Int = 9000
    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val dataStream:DataStream[String] = env.socketTextStream(hostname,port)
    dataStream.print()
    env.execute("test")
  }
}

```
#### sourceFunction
```
package com.opensourceteams.bigdata.flink.example.streaming.api.sources.sourceFunction.n_4

import org.apache.flink.streaming.api.functions.source.SourceFunction
import org.apache.flink.streaming.api.scala._

import scala.util.Random

case class Animal(id:String,name:String)
object Run {

  def main(args: Array[String]): Unit = {


    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val dataStream:DataStream[Int] = env.addSource(new CustomerSource())
    dataStream.print()
    env.execute("test")
  }
}

class CustomerSource extends SourceFunction[Int]{

  var flag = true
  override def run(sourceContext: SourceFunction.SourceContext[Int]): Unit = {


    val rand = new Random()
    while (flag){
      for( a <- 1 to 10){
        sourceContext.collect((10 + rand.nextGaussian() * 10).intValue())
        Thread.sleep(500)
      }
    }


  }

  override def cancel(): Unit = {
    flag = false
  }
}

```

#### source mysql
- 工具类
```aidl
package com.opensourceteams.bigdata.flink.example.streaming.api.sources.db.mysql.util

import java.sql.{Connection, DriverManager, PreparedStatement, ResultSet}

object MysqlJDBCUtil {

  val driver:String = "com.mysql.cj.jdbc.Driver"

  val url:String ="jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8"
  val username:String = "root"
  val password:String = "000000"


  Class.forName(driver).newInstance()


  def getConnection( url:String, username:String, password:String): Connection ={
    val connection: Connection =  DriverManager.getConnection(url,username,password)
    connection
  }
  def getConnection(): Connection ={
    val connection: Connection = DriverManager.getConnection(url,username,password)
    connection
  }

  def getPreparedStatement(sql:String,connection:Connection): PreparedStatement ={
    val preparedStatement: PreparedStatement = connection.prepareStatement(sql)
    preparedStatement
  }
  def getPreparedStatement(sql:String): PreparedStatement ={
    val connection = getConnection()
    val preparedStatement: PreparedStatement = connection.prepareStatement(sql)
    preparedStatement
  }

  def getResultSet(sql:String,connection:Connection): ResultSet ={
    val preparedStatement: PreparedStatement = connection.prepareStatement(sql)
    val resultSet:ResultSet = preparedStatement.executeQuery()
    resultSet
  }


  def getResultSet(sql:String): ResultSet ={
    val connection: Connection = getConnection()
    val preparedStatement: PreparedStatement = connection.prepareStatement(sql)
    val resultSet:ResultSet = preparedStatement.executeQuery()
    resultSet
  }

  def close(connection: Connection):Unit ={
    if(connection !=null){
      connection.close()
    }
  }

  def close(preparedStatement: PreparedStatement):Unit ={
    if(preparedStatement !=null){
      preparedStatement.close()
    }
  }
  def close(resultSet:ResultSet):Unit ={
    if(resultSet !=null){
      resultSet.close()
    }
  }

  def close(connection: Connection,resultSet:ResultSet):Unit ={
    if(resultSet !=null){
      resultSet.close()
    }
    if(connection !=null){
      connection.close()
    }
  }

  def close(connection: Connection,preparedStatement: PreparedStatement):Unit ={
    if(preparedStatement !=null){
      preparedStatement.close()
    }

    if(connection !=null){
      connection.close()
    }
  }

}

```

- SourceFromMysql
```aidl
package com.opensourceteams.bigdata.flink.example.streaming.api.sources.db.mysql

import java.sql.{Connection, ResultSet}

import com.opensourceteams.bigdata.flink.example.streaming.api.sources.db.mysql.util.MysqlJDBCUtil
import org.apache.flink.configuration.Configuration
import org.apache.flink.streaming.api.functions.source.{RichSourceFunction, SourceFunction}

case class Student( username: String, age: Int,id: Int = -1)

class SourceFromMysql  extends RichSourceFunction[Student]{

  var connection:Connection = null
  var resultResult:ResultSet = null
  override def open(parameters: Configuration): Unit = {
    super.open(parameters)
    connection = MysqlJDBCUtil.getConnection()
  }

  override def run(ctx: SourceFunction.SourceContext[Student]): Unit = {
    val sql = "select * from t_user limit 100"
    resultResult = MysqlJDBCUtil.getResultSet(sql,connection)
    while (resultResult.next()){
      val id:Int = resultResult.getInt("id")
      val username:String = resultResult.getString("username")
      val age:Int = resultResult.getInt("age")

      val student = Student(username,age,id)
      ctx.collect(student)
    }
  }
  override def cancel(): Unit = {

  }

  override def close(): Unit = {
    MysqlJDBCUtil.close(connection,resultResult)
  }
}

```
- Run
```aidl
package com.opensourceteams.bigdata.flink.example.streaming.api.sources.db.mysql

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}

object Run {

  def main(args: Array[String]): Unit = {
    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val dataStream :DataStream[Student] = env.addSource(new SourceFromMysql)
    dataStream.print()

    env.execute()
  }
}

```