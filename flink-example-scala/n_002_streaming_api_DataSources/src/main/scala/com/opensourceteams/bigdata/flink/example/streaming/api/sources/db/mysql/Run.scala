package com.opensourceteams.bigdata.flink.example.streaming.api.sources.db.mysql

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}

object Run {

  def main(args: Array[String]): Unit = {
    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val dataStream :DataStream[Student] = env.addSource(new SourceFromMysql)
    dataStream.print()

    env.execute()
  }
}
