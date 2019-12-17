# Flink streaming api source 方式

## 更多资源
- https://github.com/opensourceteams/flink-example-all

## 简述
- Flink Source方式
- fromCollection
- fromElements
- readTextFile
- socket
- sourceFunction

#### fromCollection
```
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

```


#### fromElements
```
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

```

#### readTextFile
```
package com.opensourceteams.bigdata.flink.example.streaming.api.sources.readTextFile

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}

case class Animal(id:String,name:String)
object Run {

  def main(args: Array[String]): Unit = {

    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val dataStream:DataStream[String] = env.readTextFile("D:\\workspaces\\bigdata\\flink\\flink-example-all/data/text/text.txt")


    dataStream.print()
    env.execute("test")
  }
}

```
#### socket
- nc
```
nc -L -p 9000
```

```
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

```
#### sourceFunction
```
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

```
