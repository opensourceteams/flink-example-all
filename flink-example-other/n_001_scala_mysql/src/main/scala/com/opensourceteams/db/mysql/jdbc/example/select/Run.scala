package com.opensourceteams.db.mysql.jdbc.example.select

import java.sql.{Connection, DriverManager, PreparedStatement, ResultSet}


object Run {

  def main(args: Array[String]): Unit = {
    val driver:String = "com.mysql.cj.jdbc.Driver"
    val url:String ="jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC"
    val username:String = "root"
    val password:String = "000000"

    var preparedStatement: PreparedStatement = null

    var connection: Connection = null

    val sql:String = "select * from t_user"
    var resultSet: ResultSet = null
    try{
      //Class.forName(driver)
      Class.forName(driver).newInstance()
      connection = DriverManager.getConnection(url,username,password)
      preparedStatement = connection.prepareStatement(sql)
      resultSet = preparedStatement.executeQuery()
      while (resultSet.next()){

        val id:Long = resultSet.getLong("id")
        val username:String = resultSet.getString("username")
        print(id)
        print("\t")
        print(username)
        println()
      }
    }catch{
      case e : Exception => {
        e.printStackTrace()
      }
    }

    resultSet.close()
    connection.close()

  }
}
