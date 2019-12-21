package com.opensourceteams.bigdata.flink.example.streaming.api.operator.asyncFunction.n_01

import java.util.concurrent.TimeUnit

import com.alibaba.fastjson.JSONObject
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, _} //scala拓展API需要导入的

object Run {

  def main(args: Array[String]): Unit = {
    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    //val list:List[String] = List("a", "b","c","d")
    val list:List[String] = List("a", "b")
    val dataStream:DataStream[String] = env.fromCollection(list)

    val resultStreamR: DataStream[JSONObject] =
      AsyncDataStream.unorderedWait(dataStream, new AsyncDatabaseRequest(), 1000L, TimeUnit.MILLISECONDS, 100)
    resultStreamR.print()
    env.execute()
  }
}
