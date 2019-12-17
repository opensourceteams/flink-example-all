package com.opensourceteams.bigdata.flink.example.streaming.api.sources.fromElements

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.api.scala._

case class Animal(id:String,name:String)
object Run {

  def main(args: Array[String]): Unit = {

    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val dataStream:DataStream[String] = env.fromElements("a","b","c")


    dataStream.print()
    env.execute("test")
  }
}
