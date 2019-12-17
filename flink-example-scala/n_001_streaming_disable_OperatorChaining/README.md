# disable OperatorChaining (禁用算子合并)

## 更多资源
- https://github.com/opensourceteams/flink-example-all

## 简述
- Flink 算子会进行合并(符合条件的)
- 合并算子(一对一　transformation、并行度相同)


## 源码
- 关键代码
```aidl
env.disableOperatorChaining()
```

- WordCountRun.scala
```
package com.opensourceteams.bigdata.flink.example.streaming.disable

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment, _}
import org.apache.flink.streaming.api.windowing.time.Time


object WordCountRun {

  def main(args: Array[String]): Unit = {
    val hostname : String = "localhost"
    val port : Int = 9000
    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    env.disableOperatorChaining()
    val text:DataStream[String] = env.socketTextStream(hostname,port,'\n')

    val windowCounts = text.flatMap{ w => w.split("\\s")}
                        .map{w =>(w,1)}
      .keyBy(0)
      .timeWindow(Time.milliseconds(100))
      .sum(1)
    windowCounts.print()

    env.execute("test")
  }
}

```