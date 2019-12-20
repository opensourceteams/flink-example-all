# Scala mysql jdbc

## 更多资源
- https://github.com/opensourceteams/flink-example-all

## 简述
- scala mysql jdbc
- 增、删、改、查

#### base
```aidl
package com.opensourceteams.db.mysql.jdbc.example.base

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
#### insert
```aidl
package com.opensourceteams.db.mysql.jdbc.example.insert

import java.sql.{Connection, DriverManager, PreparedStatement}

import com.opensourceteams.db.mysql.jdbc.example.base.MysqlJDBCUtil


object Run3 {


  def main(args: Array[String]): Unit = {
    var preparedStatement: PreparedStatement = null

    val sql:String = "insert into t_user(username,age) values('小明',25)"
    var connection: Connection = null
      try{
        connection = MysqlJDBCUtil.getConnection()
        preparedStatement = connection.prepareStatement(sql)
        val result:Int = preparedStatement.executeUpdate()

        println(result)
    }catch{
      case e : Exception => {
        e.printStackTrace()
      }
    }finally {
        MysqlJDBCUtil.close(connection,preparedStatement)
      }
  }
}

```
#### delete
```aidl
package com.opensourceteams.db.mysql.jdbc.example.delete

import java.sql.{Connection, PreparedStatement}

import com.opensourceteams.db.mysql.jdbc.example.base.MysqlJDBCUtil


object Run {

  def main(args: Array[String]): Unit = {
    var preparedStatement: PreparedStatement = null

    val sql:String = "delete from t_user  where id = 2 "
    var connection: Connection = null
      try{
        connection = MysqlJDBCUtil.getConnection()
        preparedStatement = connection.prepareStatement(sql)
        val result:Int = preparedStatement.executeUpdate()

        println(result)
    }catch{
      case e : Exception => {
        e.printStackTrace()
      }
    }finally {
        MysqlJDBCUtil.close(connection,preparedStatement)
      }
  }
}

```
#### update
```aidl
package com.opensourceteams.db.mysql.jdbc.example.update

import java.sql.{Connection, PreparedStatement}

import com.opensourceteams.db.mysql.jdbc.example.base.MysqlJDBCUtil


object Run {


  def main(args: Array[String]): Unit = {
    var preparedStatement: PreparedStatement = null

    val sql:String = "update t_user set username= '小李' where id =2"
    var connection: Connection = null
      try{
        connection = MysqlJDBCUtil.getConnection()
        preparedStatement = connection.prepareStatement(sql)
        val result:Int = preparedStatement.executeUpdate()

        println(result)
    }catch{
      case e : Exception => {
        e.printStackTrace()
      }
    }finally {
        MysqlJDBCUtil.close(connection,preparedStatement)
      }
  }
}

```
#### select
```aidl
package com.opensourceteams.db.mysql.jdbc.example.select

import java.sql.{Connection, DriverManager, PreparedStatement, ResultSet}

import com.opensourceteams.db.mysql.jdbc.example.base.MysqlJDBCUtil


object Run1 {

  def main(args: Array[String]): Unit = {
    val sql:String = "select * from t_user"
    var resultSet: ResultSet = null
    var connection: Connection = null
    try{
      connection = MysqlJDBCUtil.getConnection()
      resultSet = MysqlJDBCUtil.getResultSet(sql,connection)
      while (resultSet.next()){
        val id:Long = resultSet.getLong("id")
        val username:String = resultSet.getString("username")
        val age:Int = resultSet.getInt("age")
        print(id)
        print("\t")
        print(username)
        print("\t")
        print(age)
        println()
      }
    }catch{
      case e : Exception => {
        e.printStackTrace()
      }
    }finally {
      MysqlJDBCUtil.close(connection,resultSet)
    }
  }
}

```