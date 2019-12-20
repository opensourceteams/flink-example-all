package com.opensourceteams.db.mysql.jdbc.example.insert

import java.sql.{Connection, DriverManager, PreparedStatement}


object Run2 {


  val url:String ="jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8"
  val username:String = "root"
  val password:String = "000000"

  var preparedStatement: PreparedStatement = null
  def load() {
    val driver:String = "com.mysql.cj.jdbc.Driver"
    Class.forName(driver).newInstance()
  }

  def getConnection( url:String, username:String, password:String): Connection ={
    var connection: Connection = null
    connection = DriverManager.getConnection(url,username,password)
    connection
  }

  def main(args: Array[String]): Unit = {
    load()


    val sql:String = "insert into t_user(username) values('小明')"
    var connection: Connection = null
      try{

        connection = getConnection(url,username,password)
      preparedStatement = connection.prepareStatement(sql)
      val result:Int = preparedStatement.executeUpdate()

      println(result)
    }catch{
      case e : Exception => {
        e.printStackTrace()
      }
    }

    preparedStatement.close()
    connection.close()

  }
}
