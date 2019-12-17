# window 操作系统dos 命令提交 Flink 作业

## 简述
- window 操作系统
- dos 命令提交Flink 作业

## 更多资源
- https://github.com/opensourceteams/flink-example-all


## 输入数据
- cmd
```aidl
nc -L -p 9000
```
#### maven 打包作业
```aidl
mvn clean package -DskipTests
```

#### dos命令提作业
```aidl
flink.bat run -c com.opensourceteams.bigdata.flink.example.streaming.WordCountRun  D:\workspaces\bigdata\flink\flink-example-all\flink-example-official\n_004_streaming_wordCount_scala\target\flink-example-scala-0.1.jar
```

## 输出数据
- http://localhost:8081
- Task Manager ==> Stdout

```aidl
(a,2)
(b,1)
```