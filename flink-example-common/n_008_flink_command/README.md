# Flink 命令



#### Flink run 提交作业
```aidl
flink run -c com.opensourceteams.bigdata.flink.example.streaming.WordCountRun  ./flink-example-scala-0.1.jar
```

#### Flink list -all 查看所有作业
```aidl
flink  list -all
```

#### Flink cancel 取消作业
```aidl
 flink cancel 2df38e25a4624d89dff568c015fbb784
```