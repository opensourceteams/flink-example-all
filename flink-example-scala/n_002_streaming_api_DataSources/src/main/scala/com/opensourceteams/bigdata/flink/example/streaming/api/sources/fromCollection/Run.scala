package com.opensourceteams.bigdata.flink.example.streaming.api.sources.fromCollection

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment, _}

case class Animal(id:String,name:String)
object Run {

  def main(args: Array[String]): Unit = {

    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val dataStream:DataStream[Animal] = env.fromCollection(List(
      Animal("cat","猫"),
      Animal("dog","狗"),
      Animal("bird","鸟")
    ))
    dataStream.print()
    env.execute("test")
  }
}
