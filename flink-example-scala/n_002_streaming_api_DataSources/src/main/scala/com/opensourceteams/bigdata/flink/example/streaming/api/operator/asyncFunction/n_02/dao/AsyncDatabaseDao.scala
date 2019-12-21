package com.opensourceteams.bigdata.flink.example.streaming.api.operator.asyncFunction.n_02.dao

import java.sql.ResultSet

import com.alibaba.fastjson.JSONObject
import com.opensourceteams.bigdata.flink.example.streaming.api.sources.db.mysql.util.MysqlJDBCUtil

object AsyncDatabaseDao {

  def getJSONObjectByKey(key:String): JSONObject = {
    val jSONObject:JSONObject  = new JSONObject()
    val sql = "select * from t_user where id =" +key
    val resultSet:ResultSet =MysqlJDBCUtil.getResultSet(sql)
    if(resultSet.next()){
      val id:Int = resultSet.getInt("id")
      val age:Int = resultSet.getInt("age")
      val username:String = resultSet.getString("username")
      jSONObject.put("id",id)
      jSONObject.put("username",username)
      jSONObject.put("age",age)
    }
    jSONObject
  }
}
