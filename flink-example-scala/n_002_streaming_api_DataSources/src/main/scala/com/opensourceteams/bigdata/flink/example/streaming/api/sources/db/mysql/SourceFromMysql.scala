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
