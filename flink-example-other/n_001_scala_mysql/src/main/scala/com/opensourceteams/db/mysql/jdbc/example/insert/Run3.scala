package com.opensourceteams.db.mysql.jdbc.example.insert

import java.sql.{Connection, DriverManager, PreparedStatement}

import com.opensourceteams.db.mysql.jdbc.example.base.MysqlJDBCUtil


object Run3 {


  def main(args: Array[String]): Unit = {
    var preparedStatement: PreparedStatement = null

    val sql:String = "insert into t_user(username) values('小明')"
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
