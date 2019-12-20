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
        print(id)
        print("\t")
        print(username)
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
