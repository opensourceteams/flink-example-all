package com.opensourceteams.bigdata.flink.example.batch


import org.apache.flink.api.scala.{ ExecutionEnvironment}
import org.apache.flink.api.scala._

object WordCountRun {

  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val text =env.readTextFile("D:/workspaces/bigdata/flink/flink-example-all/data/text/text.txt")
    val counts = text.flatMap{_.toLowerCase().split("\\W+") filter{_.nonEmpty}}
      .map{(_,1)}
      .groupBy(0)
      .sum(1)
    counts.print()
  }
}
