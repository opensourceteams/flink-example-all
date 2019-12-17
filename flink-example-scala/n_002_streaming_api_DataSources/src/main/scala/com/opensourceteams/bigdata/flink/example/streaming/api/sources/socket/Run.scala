package com.opensourceteams.bigdata.flink.example.streaming.api.sources.socket

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}

case class Animal(id:String,name:String)
object Run {

  def main(args: Array[String]): Unit = {

    val hostname:String = "localhost"
    val port:Int = 9000
    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val dataStream:DataStream[String] = env.socketTextStream(hostname,port)
    dataStream.print()
    env.execute("test")
  }
}
