package com.opensourceteams.db.mysql.jdbc.example.insertMany

import java.sql.{Connection, PreparedStatement}

import com.opensourceteams.db.mysql.jdbc.example.base.MysqlJDBCUtil

import scala.util.Random


object Run {


  def main(args: Array[String]): Unit = {
    var preparedStatement: PreparedStatement = null


    var connection: Connection = null
      try{
        connection = MysqlJDBCUtil.getConnection()
        val random = new Random()
        for(i <- 1 to 100){
          val sql:String = "insert into t_user(username,age) values(?,?)"
          preparedStatement = connection.prepareStatement(sql)
          preparedStatement.setString(1,"小明" +i)
          preparedStatement.setInt(2,random.nextInt(100))
          val result:Int = preparedStatement.executeUpdate()
          println(result)
        }
    }catch{
      case e : Exception => {
        e.printStackTrace()
      }
    }finally {
        MysqlJDBCUtil.close(connection,preparedStatement)
      }
  }
}
