# 官方示例SocketWindowWordCount

## 源码
- https://github.com/opensourceteams/flink-example-all/tree/master/flink-example-official/n_001_example_socketWindowWordCount

## 更多源码
- https://github.com/opensourceteams/flink-example-all

### 启动Flink
```aidl
start-cluster.bat
```
### nc启动连接服务
- 数据输入端
```aidl
nc -l -p 9000
```
输入数据
```aidl
c b a a b
```

### 运行示例
```aidl
%FLINK_HOME%/bin/flink run %FLINK_HOME%/examples/streaming/SocketWindowWordCount.jar --port 9000
```

### TaskManager(Worker)日志
```aidl
c : 1
a : 2
b : 2
```
- 作业提交
[![](https://opensourceteams.github.io/flink-example-all/flink-example-official/n_001_example_socketWindowWordCount/md/image/overview.png)](https://opensourceteams.github.io/flink-example-all/flink-example-official/n_001_example_socketWindowWordCount/md/image/overview.png)

- 作业拆分成任务
[![](https://opensourceteams.github.io/flink-example-all//flink-example-official/n_001_example_socketWindowWordCount/md/image/job.png)]()

### 源码
- SocketWindowWordCount.java

```aidl
package org.apache.flink.streaming.examples.socket;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

/**
 * Implements a streaming windowed version of the "WordCount" program.
 *
 * <p>This program connects to a server socket and reads strings from the socket.
 * The easiest way to try this out is to open a text server (at port 12345)
 * using the <i>netcat</i> tool via
 * <pre>
 * nc -l 12345 on Linux or nc -l -p 12345 on Windows
 * </pre>
 * and run this example with the hostname and the port as arguments.
 */
@SuppressWarnings("serial")
public class SocketWindowWordCount {

	public static void main(String[] args) throws Exception {

		// the host and the port to connect to
		final String hostname;
		final int port;
		try {
			final ParameterTool params = ParameterTool.fromArgs(args);
			hostname = params.has("hostname") ? params.get("hostname") : "localhost";
			port = params.getInt("port");
		} catch (Exception e) {
			System.err.println("No port specified. Please run 'SocketWindowWordCount " +
				"--hostname <hostname> --port <port>', where hostname (localhost by default) " +
				"and port is the address of the text server");
			System.err.println("To start a simple text server, run 'netcat -l <port>' and " +
				"type the input text into the command line");
			return;
		}

		// get the execution environment
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

		// get input data by connecting to the socket
		DataStream<String> text = env.socketTextStream(hostname, port, "\n");

		// parse the data, group it, window it, and aggregate the counts
		DataStream<WordWithCount> windowCounts = text

				.flatMap(new FlatMapFunction<String, WordWithCount>() {
					@Override
					public void flatMap(String value, Collector<WordWithCount> out) {
						for (String word : value.split("\\s")) {
							out.collect(new WordWithCount(word, 1L));
						}
					}
				})

				.keyBy("word")
				.timeWindow(Time.seconds(5))

				.reduce(new ReduceFunction<WordWithCount>() {
					@Override
					public WordWithCount reduce(WordWithCount a, WordWithCount b) {
						return new WordWithCount(a.word, a.count + b.count);
					}
				});

		// print the results with a single thread, rather than in parallel
		windowCounts.print().setParallelism(1);

		env.execute("Socket Window WordCount");
	}

	// ------------------------------------------------------------------------

	/**
	 * Data type for words with count.
	 */
	public static class WordWithCount {

		public String word;
		public long count;

		public WordWithCount() {}

		public WordWithCount(String word, long count) {
			this.word = word;
			this.count = count;
		}

		@Override
		public String toString() {
			return word + " : " + count;
		}
	}
}

```