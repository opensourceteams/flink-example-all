# Flink本地模式安装

## 简述
- Flink1.9.1本地模式安装、启动、日志查看
### 安装jdk

```aidl
java -version
java version "1.8.0_181"
Java(TM) SE Runtime Environment (build 1.8.0_181-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.181-b13, mixed mode)
```

### 安装scala

```aidl
jscala
 Welcome to Scala 2.11.12 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_181).
 Type in expressions for evaluation. Or try :help.
```

### 安装 Flink 本地
#### Flink 下载地址
- https://flink.apache.org/downloads.html
- 下载flink-1.9.1-bin-scala_2.11.tgz

#### 启动Flink
```aidl
flink-1.9.1\bin\start-cluster.bat
```
#### 查看页面仪表盘(整体运行情况)
- http://localhost:8081
- [![描述](地址 "描述")](https://github.com/opensourceteams/flink-example-all/blob/master/flink-example-common/n_003_local_setup_tutorial/md/image/local_setup_dashboard.png "描述")
- [![描述](https://github.com/opensourceteams/flink-example-all/blob/master/flink-example-common/n_003_local_setup_tutorial/md/image/local_setup_dashboard.png "描述")](https://github.com/opensourceteams/flink-example-all/blob/master/flink-example-common/n_003_local_setup_tutorial/md/image/local_setup_dashboard.png "描述")