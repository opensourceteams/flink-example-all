# Linux 操作系统 命令提交 Flink 作业

## 简述
- Linux 操作系统
- shell 命令提交Flink 作业

## 更多资源
- https://github.com/opensourceteams/flink-example-all


## 输入数据
- shell
```aidl
nc -L -p 9000
```
#### maven 打包作业
```aidl
mvn clean package -DskipTests
```

#### shell命令提作业
```aidl
flink run -c com.opensourceteams.bigdata.flink.example.streaming.WordCountRun  ./flink-example-scala-0.1.jar
```

## 输出数据
- http://localhost:8081
- Task Manager ==> Stdout

```aidl
(a,2)
(b,1)
```