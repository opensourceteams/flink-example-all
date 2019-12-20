package com.opensourceteams.bigdata.flink.example.streaming.api.sink.mysql

import java.sql.{Connection, PreparedStatement}

import com.opensourceteams.bigdata.flink.example.streaming.api.sources.db.mysql.Student
import com.opensourceteams.bigdata.flink.example.streaming.api.sources.db.mysql.util.MysqlJDBCUtil
import org.apache.flink.configuration.Configuration
import org.apache.flink.streaming.api.functions.sink.{RichSinkFunction, SinkFunction}

class SinkToMysql  extends RichSinkFunction[Student]{

  private var connection: Connection = null
  private var ps: PreparedStatement = null

  /**
    * 一、open()方法中建立连接，这样不用每次invoke的时候都要建立连接和释放连接。
    * @param parameters
    */
  override def open(parameters: Configuration): Unit = {
    super.open(parameters)
    connection = MysqlJDBCUtil.getConnection()

    val sql:String = "insert into t_user(username,age) values(?,?)"
    ps = MysqlJDBCUtil.getPreparedStatement(sql,connection)
  }

  /**
    * 二、每个元素的插入都要调用一次invoke()方法，这里主要进行插入操作
    * @param value
    * @param context
    */
  override def invoke(value: Student, context: SinkFunction.Context[_]): Unit = {
    try {
      //4.组装数据，执行插入操作
      ps.setString(1, value.username)
      ps.setInt(2, value.age)
      ps.executeUpdate()
    } catch {
      case e: Exception => println(e.getMessage)
    }
  }

  override def close(): Unit = {
    MysqlJDBCUtil.close(connection,ps)
  }
}
