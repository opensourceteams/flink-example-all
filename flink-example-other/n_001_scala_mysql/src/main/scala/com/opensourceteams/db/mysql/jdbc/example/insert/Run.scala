package com.opensourceteams.db.mysql.jdbc.example.insert

import java.sql.{Connection, DriverManager, PreparedStatement}


object Run {

  def main(args: Array[String]): Unit = {
    val driver:String = "com.mysql.cj.jdbc.Driver"
    val url:String ="jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8"
    val username:String = "root"
    val password:String = "000000"

    var preparedStatement: PreparedStatement = null

    var connection: Connection = null

    val sql:String = "insert into t_user(username) values('小明')"
    try{
      //Class.forName(driver)
      Class.forName(driver).newInstance()
      connection = DriverManager.getConnection(url,username,password)
      preparedStatement = connection.prepareStatement(sql)
     // val result:Boolean = preparedStatement.execute()
      val result:Int = preparedStatement.executeUpdate()

      println(result)
    }catch{
      case e : Exception => {
        e.printStackTrace()
      }
    }

    connection.close()

  }
}
