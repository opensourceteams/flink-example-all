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
