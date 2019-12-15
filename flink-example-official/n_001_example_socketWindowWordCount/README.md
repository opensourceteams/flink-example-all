# 官方示例WordCount

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
[![]()](https://opensourceteams.github.io/flink-example-all//flink-example-official/n_001_example_socketWindowWordCount/md/image/overview.png)

