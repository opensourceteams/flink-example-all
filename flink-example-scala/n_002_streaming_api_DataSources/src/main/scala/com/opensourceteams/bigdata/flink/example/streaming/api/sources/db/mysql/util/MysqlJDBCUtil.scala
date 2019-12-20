package com.opensourceteams.bigdata.flink.example.streaming.api.sources.db.mysql.util

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

  def getPreparedStatement(sql:String,connection:Connection): PreparedStatement ={
    val preparedStatement: PreparedStatement = connection.prepareStatement(sql)
    preparedStatement
  }
  def getPreparedStatement(sql:String): PreparedStatement ={
    val connection = getConnection()
    val preparedStatement: PreparedStatement = connection.prepareStatement(sql)
    preparedStatement
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
