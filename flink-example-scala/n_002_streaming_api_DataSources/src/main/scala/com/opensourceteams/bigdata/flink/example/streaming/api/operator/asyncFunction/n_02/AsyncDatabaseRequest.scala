package com.opensourceteams.bigdata.flink.example.streaming.api.operator.asyncFunction.n_02

import com.alibaba.fastjson.JSONObject
import com.opensourceteams.bigdata.flink.example.streaming.api.operator.asyncFunction.n_02.dao.AsyncDatabaseDao
import org.apache.flink.streaming.api.scala.async.{AsyncFunction, ResultFuture}


class AsyncDatabaseRequest extends AsyncFunction[String,JSONObject]{




  override def asyncInvoke(key: String, resultFuture: ResultFuture[JSONObject]): Unit = {

    val jsonObject:JSONObject = AsyncDatabaseDao.getJSONObjectByKey(key)

    resultFuture.complete(Iterable(jsonObject))
    //Collections.singleton(jsonObject)
  }
}
