package com.opensourceteams.bigdata.flink.example.streaming.api.sources.asyncFunction



import java.util.concurrent.Future

import org.apache.flink.runtime.concurrent.Executors
import org.apache.flink.streaming.api.scala.async.{AsyncFunction, ResultFuture}

import scala.concurrent.ExecutionContext

class AsyncDatabaseRequest extends AsyncFunction[String,String]{

  lazy val client : DatabaseClient = new DatabaseClient(host,post,credentials)

  implicit  lazy val executor:ExecutionContext = ExecutionContext.fromExecutor(Executors.directExecutor())
  override def asyncInvoke(input: String, resultFuture: ResultFuture[String]): Unit = {
    val resultFutureRequested:Future[String] = client.query(input)

    // the callback simply forwards the result to the result future
    resultFutureRequested.onSuccess {
      case result: String => resultFuture.complete(Iterable((str, result)))
    }

  }
}
