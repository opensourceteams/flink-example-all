package com.opensourceteams.bigdata.flink.example.streaming.api.sources.asyncFunction.mysql

import java.util.concurrent.TimeUnit

import org.apache.flink.streaming.api.scala.async.{ResultFuture, RichAsyncFunction}
import org.apache.flink.streaming.api.scala.{AsyncDataStream, DataStream, StreamExecutionEnvironment}

object AsyncToMysql {

  def main(args: Array[String]): Unit = {

    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val list = List("a", "b")
    val source: DataStream[String] = env.fromCollection(list)

    val result: DataStream[String] = AsyncDataStream.unorderedWait(source, new MysqlAsyncFunc(), 10, TimeUnit.SECONDS, 20)
      .setParallelism(1)

    result.print()

    env.execute("test")
  }


}

 abstract class MysqlAsyncFunc extends RichAsyncFunction{
  override def asyncInvoke(input: Nothing, resultFuture: ResultFuture[Nothing]): Unit = ???
}
