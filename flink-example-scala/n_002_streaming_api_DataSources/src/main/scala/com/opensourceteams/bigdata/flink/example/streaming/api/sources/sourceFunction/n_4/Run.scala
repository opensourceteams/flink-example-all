package com.opensourceteams.bigdata.flink.example.streaming.api.sources.sourceFunction.n_4

import org.apache.flink.streaming.api.functions.source.SourceFunction
import org.apache.flink.streaming.api.scala._

import scala.util.Random

case class Animal(id:String,name:String)
object Run {

  def main(args: Array[String]): Unit = {


    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val dataStream:DataStream[Int] = env.addSource(new CustomerSource())
    dataStream.print()
    env.execute("test")
  }
}

class CustomerSource extends SourceFunction[Int]{

  var flag = true
  override def run(sourceContext: SourceFunction.SourceContext[Int]): Unit = {


    val rand = new Random()
    while (flag){
      for( a <- 1 to 10){
        sourceContext.collect((10 + rand.nextGaussian() * 10).intValue())
        Thread.sleep(500)
      }
    }


  }

  override def cancel(): Unit = {
    flag = false
  }
}
