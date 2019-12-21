package com.opensourceteams.bigdata.flink.example.streaming.api.operator.asyncFunction.n_01

import com.alibaba.fastjson.JSONObject
import org.apache.flink.streaming.api.scala.async.{AsyncFunction, ResultFuture}


class AsyncDatabaseRequest extends AsyncFunction[String,JSONObject]{




  override def asyncInvoke(input: String, resultFuture: ResultFuture[JSONObject]): Unit = {

    val jsonObject:JSONObject = new JSONObject();
    jsonObject.put(input+"_1",1)
    jsonObject.put(input+"_2",2)
    resultFuture.complete(Iterable(jsonObject))
    //Collections.singleton(jsonObject)
  }
}
