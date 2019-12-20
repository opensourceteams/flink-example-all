package com.opensourceteams.bigdata.flink.example.streaming.api.sink.mysql

import com.opensourceteams.bigdata.flink.example.streaming.api.sources.db.mysql.Student
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.api.scala._

object Run {

  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val studentList = List(
      Student("大一",15),
      Student("大二",35)
    )

    val dataStream:DataStream[Student] = env.fromCollection(studentList)
    dataStream.addSink(new SinkToMysql)

    env.execute()

  }
}
