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
- 主界面
[![](https://opensourceteams.github.io/flink-example-all/flink-example-common/n_003_local_setup_tutorial/md/image/local_setup_dashboard.png)](https://opensourceteams.github.io/flink-example-all/flink-example-common/n_003_local_setup_tutorial/md/image/local_setup_dashboard.png)
- 任务管理
[![](https://opensourceteams.github.io/flink-example-all/flink-example-common/n_003_local_setup_tutorial/md/image/task_manager.png)](https://opensourceteams.github.io/flink-example-all/flink-example-common/n_003_local_setup_tutorial/md/image/task_manager.png)

### 日志

#### jobmanager.log
```aidl
2019-12-14 20:50:10,341 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         - --------------------------------------------------------------------------------
2019-12-14 20:50:10,343 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -  Starting StandaloneSessionClusterEntrypoint (Version: 1.9.1, Rev:4d56de8, Date:30.09.2019 @ 11:32:19 CST)
2019-12-14 20:50:10,343 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -  OS current user: Administrator
2019-12-14 20:50:10,343 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -  Current Hadoop/Kerberos user: <no hadoop dependency found>
2019-12-14 20:50:10,343 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -  JVM: Java HotSpot(TM) 64-Bit Server VM - Oracle Corporation - 1.8/25.181-b13
2019-12-14 20:50:10,344 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -  Maximum heap size: 981 MiBytes
2019-12-14 20:50:10,344 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -  JAVA_HOME: D:\module\environment\Java\jdk1.8.0_181
2019-12-14 20:50:10,344 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -  No Hadoop Dependency available
2019-12-14 20:50:10,344 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -  JVM Options:
2019-12-14 20:50:10,344 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -     -Xms1024m
2019-12-14 20:50:10,344 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -     -Xmx1024m
2019-12-14 20:50:10,344 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -     -Dlog.file=E:\module\bigdata\flink\flink-1.9.1\bin\..\log\flink-Administrator-jobmanager.log
2019-12-14 20:50:10,344 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -     -Dlogback.configurationFile=file:E:\module\bigdata\flink\flink-1.9.1\bin\..\conf/logback.xml
2019-12-14 20:50:10,344 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -     -Dlog4j.configuration=file:E:\module\bigdata\flink\flink-1.9.1\bin\..\conf/log4j.properties
2019-12-14 20:50:10,344 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -  Program Arguments:
2019-12-14 20:50:10,344 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -     --configDir
2019-12-14 20:50:10,345 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -     E:\module\bigdata\flink\flink-1.9.1\bin\..\conf
2019-12-14 20:50:10,345 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         -  Classpath: E:\module\bigdata\flink\flink-1.9.1\bin\..\lib\flink-dist_2.11-1.9.1.jar;E:\module\bigdata\flink\flink-1.9.1\bin\..\lib\flink-table-blink_2.11-1.9.1.jar;E:\module\bigdata\flink\flink-1.9.1\bin\..\lib\flink-table_2.11-1.9.1.jar;E:\module\bigdata\flink\flink-1.9.1\bin\..\lib\log4j-1.2.17.jar;E:\module\bigdata\flink\flink-1.9.1\bin\..\lib\slf4j-log4j12-1.7.15.jar;
2019-12-14 20:50:10,345 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         - --------------------------------------------------------------------------------
2019-12-14 20:50:10,346 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         - Registered UNIX signal handlers for [TERM, INT]
2019-12-14 20:50:10,383 INFO  org.apache.flink.configuration.GlobalConfiguration            - Loading configuration property: jobmanager.rpc.address, localhost
2019-12-14 20:50:10,383 INFO  org.apache.flink.configuration.GlobalConfiguration            - Loading configuration property: jobmanager.rpc.port, 6123
2019-12-14 20:50:10,383 INFO  org.apache.flink.configuration.GlobalConfiguration            - Loading configuration property: jobmanager.heap.size, 1024m
2019-12-14 20:50:10,383 INFO  org.apache.flink.configuration.GlobalConfiguration            - Loading configuration property: taskmanager.heap.size, 1024m
2019-12-14 20:50:10,383 INFO  org.apache.flink.configuration.GlobalConfiguration            - Loading configuration property: taskmanager.numberOfTaskSlots, 1
2019-12-14 20:50:10,384 INFO  org.apache.flink.configuration.GlobalConfiguration            - Loading configuration property: parallelism.default, 1
2019-12-14 20:50:10,384 INFO  org.apache.flink.configuration.GlobalConfiguration            - Loading configuration property: jobmanager.execution.failover-strategy, region
2019-12-14 20:50:10,654 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         - Starting StandaloneSessionClusterEntrypoint.
2019-12-14 20:50:10,654 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         - Install default filesystem.
2019-12-14 20:50:10,670 INFO  org.apache.flink.core.fs.FileSystem                           - Hadoop is not in the classpath/dependencies. The extended set of supported File Systems via Hadoop is not available.
2019-12-14 20:50:10,692 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         - Install security context.
2019-12-14 20:50:10,701 INFO  org.apache.flink.runtime.security.modules.HadoopModuleFactory  - Cannot create Hadoop Security Module because Hadoop cannot be found in the Classpath.
2019-12-14 20:50:10,721 INFO  org.apache.flink.runtime.security.SecurityUtils               - Cannot install HadoopSecurityContext because Hadoop cannot be found in the Classpath.
2019-12-14 20:50:10,721 INFO  org.apache.flink.runtime.entrypoint.ClusterEntrypoint         - Initializing cluster services.
2019-12-14 20:50:11,159 INFO  org.apache.flink.runtime.rpc.akka.AkkaRpcServiceUtils         - Trying to start actor system at localhost:6123
2019-12-14 20:50:12,024 INFO  akka.event.slf4j.Slf4jLogger                                  - Slf4jLogger started
2019-12-14 20:50:12,059 INFO  akka.remote.Remoting                                          - Starting remoting
2019-12-14 20:50:12,259 INFO  akka.remote.Remoting                                          - Remoting started; listening on addresses :[akka.tcp://flink@localhost:6123]
2019-12-14 20:50:12,350 INFO  org.apache.flink.runtime.rpc.akka.AkkaRpcServiceUtils         - Actor system started at akka.tcp://flink@localhost:6123
2019-12-14 20:50:12,365 INFO  org.apache.flink.configuration.Configuration                  - Config uses fallback configuration key 'jobmanager.rpc.address' instead of key 'rest.address'
2019-12-14 20:50:12,389 INFO  org.apache.flink.runtime.blob.BlobServer                      - Created BLOB server storage directory C:\Users\Administrator\AppData\Local\Temp\blobStore-8f39c0f1-bead-45fa-b866-954adc14d453
2019-12-14 20:50:12,393 INFO  org.apache.flink.runtime.blob.BlobServer                      - Started BLOB server at 0.0.0.0:24543 - max concurrent requests: 50 - max backlog: 1000
2019-12-14 20:50:12,476 INFO  org.apache.flink.runtime.metrics.MetricRegistryImpl           - No metrics reporter configured, no metrics will be exposed/reported.
2019-12-14 20:50:12,479 INFO  org.apache.flink.runtime.rpc.akka.AkkaRpcServiceUtils         - Trying to start actor system at localhost:0
2019-12-14 20:50:12,500 INFO  akka.event.slf4j.Slf4jLogger                                  - Slf4jLogger started
2019-12-14 20:50:12,503 INFO  akka.remote.Remoting                                          - Starting remoting
2019-12-14 20:50:12,513 INFO  akka.remote.Remoting                                          - Remoting started; listening on addresses :[akka.tcp://flink-metrics@localhost:24557]
2019-12-14 20:50:12,519 INFO  org.apache.flink.runtime.rpc.akka.AkkaRpcServiceUtils         - Actor system started at akka.tcp://flink-metrics@localhost:24557
2019-12-14 20:50:12,527 INFO  org.apache.flink.runtime.rpc.akka.AkkaRpcService              - Starting RPC endpoint for org.apache.flink.runtime.metrics.dump.MetricQueryService at akka://flink-metrics/user/MetricQueryService .
2019-12-14 20:50:12,545 INFO  org.apache.flink.runtime.dispatcher.FileArchivedExecutionGraphStore  - Initializing FileArchivedExecutionGraphStore: Storage directory C:\Users\Administrator\AppData\Local\Temp\executionGraphStore-a219db1a-a9a6-4863-927f-31e29ee7b992, expiration time 3600000, maximum cache size 52428800 bytes.
2019-12-14 20:50:12,686 INFO  org.apache.flink.configuration.Configuration                  - Config uses fallback configuration key 'jobmanager.rpc.address' instead of key 'rest.address'
2019-12-14 20:50:12,688 INFO  org.apache.flink.runtime.dispatcher.DispatcherRestEndpoint    - Upload directory C:\Users\Administrator\AppData\Local\Temp\flink-web-1471cace-dd78-4650-b11b-12f21c9dddb7\flink-web-upload does not exist. 
2019-12-14 20:50:12,698 INFO  org.apache.flink.runtime.dispatcher.DispatcherRestEndpoint    - Created directory C:\Users\Administrator\AppData\Local\Temp\flink-web-1471cace-dd78-4650-b11b-12f21c9dddb7\flink-web-upload for file uploads.
2019-12-14 20:50:12,734 INFO  org.apache.flink.runtime.dispatcher.DispatcherRestEndpoint    - Starting rest endpoint.
2019-12-14 20:50:13,240 INFO  org.apache.flink.runtime.webmonitor.WebMonitorUtils           - Determined location of main cluster component log file: E:\module\bigdata\flink\flink-1.9.1\bin\..\log\flink-Administrator-jobmanager.log
2019-12-14 20:50:13,241 INFO  org.apache.flink.runtime.webmonitor.WebMonitorUtils           - Determined location of main cluster component stdout file: E:\module\bigdata\flink\flink-1.9.1\bin\..\log\flink-Administrator-jobmanager.out
2019-12-14 20:50:13,869 INFO  org.apache.flink.runtime.dispatcher.DispatcherRestEndpoint    - Rest endpoint listening at localhost:8081
2019-12-14 20:50:13,870 INFO  org.apache.flink.runtime.dispatcher.DispatcherRestEndpoint    - http://localhost:8081 was granted leadership with leaderSessionID=00000000-0000-0000-0000-000000000000
2019-12-14 20:50:13,870 INFO  org.apache.flink.runtime.dispatcher.DispatcherRestEndpoint    - Web frontend listening at http://localhost:8081.
2019-12-14 20:50:13,959 INFO  org.apache.flink.runtime.rpc.akka.AkkaRpcService              - Starting RPC endpoint for org.apache.flink.runtime.resourcemanager.StandaloneResourceManager at akka://flink/user/resourcemanager .
2019-12-14 20:50:13,982 INFO  org.apache.flink.runtime.rpc.akka.AkkaRpcService              - Starting RPC endpoint for org.apache.flink.runtime.dispatcher.StandaloneDispatcher at akka://flink/user/dispatcher .
2019-12-14 20:50:14,008 INFO  org.apache.flink.runtime.resourcemanager.StandaloneResourceManager  - ResourceManager akka.tcp://flink@localhost:6123/user/resourcemanager was granted leadership with fencing token 00000000000000000000000000000000
2019-12-14 20:50:14,015 INFO  org.apache.flink.runtime.resourcemanager.slotmanager.SlotManagerImpl  - Starting the SlotManager.
2019-12-14 20:50:14,022 INFO  org.apache.flink.runtime.dispatcher.StandaloneDispatcher      - Dispatcher akka.tcp://flink@localhost:6123/user/dispatcher was granted leadership with fencing token 00000000-0000-0000-0000-000000000000
2019-12-14 20:50:14,023 INFO  org.apache.flink.runtime.dispatcher.StandaloneDispatcher      - Recovering all persisted jobs.
2019-12-14 20:50:14,398 INFO  org.apache.flink.runtime.resourcemanager.StandaloneResourceManager  - Registering TaskManager with ResourceID b4ec55bbd0dda1ae128253bca400935c (akka.tcp://flink@127.0.0.1:24570/user/taskmanager_0) at ResourceManager

```

#### taskmanager.log
```aidl
2019-12-14 20:50:10,337 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       - --------------------------------------------------------------------------------
2019-12-14 20:50:10,339 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -  Starting TaskManager (Version: 1.9.1, Rev:4d56de8, Date:30.09.2019 @ 11:32:19 CST)
2019-12-14 20:50:10,339 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -  OS current user: Administrator
2019-12-14 20:50:10,339 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -  Current Hadoop/Kerberos user: <no hadoop dependency found>
2019-12-14 20:50:10,340 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -  JVM: Java HotSpot(TM) 64-Bit Server VM - Oracle Corporation - 1.8/25.181-b13
2019-12-14 20:50:10,340 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -  Maximum heap size: 981 MiBytes
2019-12-14 20:50:10,340 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -  JAVA_HOME: D:\module\environment\Java\jdk1.8.0_181
2019-12-14 20:50:10,341 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -  No Hadoop Dependency available
2019-12-14 20:50:10,341 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -  JVM Options:
2019-12-14 20:50:10,341 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -     -Xms1024m
2019-12-14 20:50:10,341 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -     -Xmx1024m
2019-12-14 20:50:10,341 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -     -Dlog.file=E:\module\bigdata\flink\flink-1.9.1\bin\..\log\flink-Administrator-taskmanager.log
2019-12-14 20:50:10,341 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -     -Dlogback.configurationFile=file:E:\module\bigdata\flink\flink-1.9.1\bin\..\conf/logback.xml
2019-12-14 20:50:10,341 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -     -Dlog4j.configuration=file:E:\module\bigdata\flink\flink-1.9.1\bin\..\conf/log4j.properties
2019-12-14 20:50:10,341 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -  Program Arguments:
2019-12-14 20:50:10,341 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -     --configDir
2019-12-14 20:50:10,341 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -     E:\module\bigdata\flink\flink-1.9.1\bin\..\conf
2019-12-14 20:50:10,341 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       -  Classpath: E:\module\bigdata\flink\flink-1.9.1\bin\..\lib\flink-dist_2.11-1.9.1.jar;E:\module\bigdata\flink\flink-1.9.1\bin\..\lib\flink-table-blink_2.11-1.9.1.jar;E:\module\bigdata\flink\flink-1.9.1\bin\..\lib\flink-table_2.11-1.9.1.jar;E:\module\bigdata\flink\flink-1.9.1\bin\..\lib\log4j-1.2.17.jar;E:\module\bigdata\flink\flink-1.9.1\bin\..\lib\slf4j-log4j12-1.7.15.jar;
2019-12-14 20:50:10,341 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       - --------------------------------------------------------------------------------
2019-12-14 20:50:10,344 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       - Registered UNIX signal handlers for [TERM, INT]
2019-12-14 20:50:10,347 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       - Cannot determine the maximum number of open file descriptors
2019-12-14 20:50:10,383 INFO  org.apache.flink.configuration.GlobalConfiguration            - Loading configuration property: jobmanager.rpc.address, localhost
2019-12-14 20:50:10,383 INFO  org.apache.flink.configuration.GlobalConfiguration            - Loading configuration property: jobmanager.rpc.port, 6123
2019-12-14 20:50:10,383 INFO  org.apache.flink.configuration.GlobalConfiguration            - Loading configuration property: jobmanager.heap.size, 1024m
2019-12-14 20:50:10,383 INFO  org.apache.flink.configuration.GlobalConfiguration            - Loading configuration property: taskmanager.heap.size, 1024m
2019-12-14 20:50:10,383 INFO  org.apache.flink.configuration.GlobalConfiguration            - Loading configuration property: taskmanager.numberOfTaskSlots, 1
2019-12-14 20:50:10,384 INFO  org.apache.flink.configuration.GlobalConfiguration            - Loading configuration property: parallelism.default, 1
2019-12-14 20:50:10,384 INFO  org.apache.flink.configuration.GlobalConfiguration            - Loading configuration property: jobmanager.execution.failover-strategy, region
2019-12-14 20:50:10,471 INFO  org.apache.flink.core.fs.FileSystem                           - Hadoop is not in the classpath/dependencies. The extended set of supported File Systems via Hadoop is not available.
2019-12-14 20:50:10,534 INFO  org.apache.flink.runtime.security.modules.HadoopModuleFactory  - Cannot create Hadoop Security Module because Hadoop cannot be found in the Classpath.
2019-12-14 20:50:10,796 INFO  org.apache.flink.runtime.security.SecurityUtils               - Cannot install HadoopSecurityContext because Hadoop cannot be found in the Classpath.
2019-12-14 20:50:11,205 INFO  org.apache.flink.configuration.Configuration                  - Config uses fallback configuration key 'jobmanager.rpc.address' instead of key 'rest.address'
2019-12-14 20:50:11,226 INFO  org.apache.flink.runtime.util.LeaderRetrievalUtils            - Trying to select the network interface and address to use by connecting to the leading JobManager.
2019-12-14 20:50:11,227 INFO  org.apache.flink.runtime.util.LeaderRetrievalUtils            - TaskManager will try to connect for 10000 milliseconds before falling back to heuristics
2019-12-14 20:50:11,229 INFO  org.apache.flink.runtime.net.ConnectionUtils                  - Retrieved new target address localhost/127.0.0.1:6123.
2019-12-14 20:50:12,431 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       - TaskManager will use hostname/address 'mysite.com' (127.0.0.1) for communication.
2019-12-14 20:50:12,435 INFO  org.apache.flink.runtime.rpc.akka.AkkaRpcServiceUtils         - Trying to start actor system at 127.0.0.1:0
2019-12-14 20:50:12,801 INFO  akka.event.slf4j.Slf4jLogger                                  - Slf4jLogger started
2019-12-14 20:50:12,829 INFO  akka.remote.Remoting                                          - Starting remoting
2019-12-14 20:50:12,979 INFO  akka.remote.Remoting                                          - Remoting started; listening on addresses :[akka.tcp://flink@127.0.0.1:24570]
2019-12-14 20:50:13,054 INFO  org.apache.flink.runtime.rpc.akka.AkkaRpcServiceUtils         - Actor system started at akka.tcp://flink@127.0.0.1:24570
2019-12-14 20:50:13,120 INFO  org.apache.flink.runtime.metrics.MetricRegistryImpl           - No metrics reporter configured, no metrics will be exposed/reported.
2019-12-14 20:50:13,122 INFO  org.apache.flink.runtime.rpc.akka.AkkaRpcServiceUtils         - Trying to start actor system at 127.0.0.1:0
2019-12-14 20:50:13,143 INFO  akka.event.slf4j.Slf4jLogger                                  - Slf4jLogger started
2019-12-14 20:50:13,146 INFO  akka.remote.Remoting                                          - Starting remoting
2019-12-14 20:50:13,161 INFO  akka.remote.Remoting                                          - Remoting started; listening on addresses :[akka.tcp://flink-metrics@127.0.0.1:24583]
2019-12-14 20:50:13,170 INFO  org.apache.flink.runtime.rpc.akka.AkkaRpcServiceUtils         - Actor system started at akka.tcp://flink-metrics@127.0.0.1:24583
2019-12-14 20:50:13,175 INFO  org.apache.flink.runtime.rpc.akka.AkkaRpcService              - Starting RPC endpoint for org.apache.flink.runtime.metrics.dump.MetricQueryService at akka://flink-metrics/user/MetricQueryService_b4ec55bbd0dda1ae128253bca400935c .
2019-12-14 20:50:13,191 INFO  org.apache.flink.runtime.blob.PermanentBlobCache              - Created BLOB cache storage directory C:\Users\Administrator\AppData\Local\Temp\blobStore-9b41bb49-bb4f-4c9f-ab2f-2a03313bd645
2019-12-14 20:50:13,196 INFO  org.apache.flink.runtime.blob.TransientBlobCache              - Created BLOB cache storage directory C:\Users\Administrator\AppData\Local\Temp\blobStore-10e2af71-993b-4eaa-9d2a-ee11d1878047
2019-12-14 20:50:13,196 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerRunner       - Starting TaskManager with ResourceID: b4ec55bbd0dda1ae128253bca400935c
2019-12-14 20:50:13,332 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerServices     - Temporary file directory 'C:\Users\Administrator\AppData\Local\Temp': total 103 GB, usable 3 GB (2.91% usable)
2019-12-14 20:50:13,353 INFO  org.apache.flink.runtime.io.disk.FileChannelManagerImpl       - FileChannelManager uses directory C:\Users\Administrator\AppData\Local\Temp\flink-io-a9878bac-da6a-4fa0-a5eb-36de74d480cd for spill files.
2019-12-14 20:50:13,371 INFO  org.apache.flink.runtime.io.network.netty.NettyConfig         - NettyConfig [server address: /127.0.0.1, server port: 0, ssl enabled: false, memory segment size (bytes): 32768, transport type: NIO, number of server threads: 1 (manual), number of client threads: 1 (manual), server connect backlog: 0 (use Netty's default), client connect timeout (sec): 120, send/receive buffer size (bytes): 0 (use Netty's default)]
2019-12-14 20:50:13,377 INFO  org.apache.flink.runtime.io.disk.FileChannelManagerImpl       - FileChannelManager uses directory C:\Users\Administrator\AppData\Local\Temp\flink-netty-shuffle-59580918-0900-463f-aaef-2b8eec5871bf for spill files.
2019-12-14 20:50:13,544 INFO  org.apache.flink.runtime.io.network.buffer.NetworkBufferPool  - Allocated 109 MB for network buffer pool (number of memory segments: 3489, bytes per segment: 32768).
2019-12-14 20:50:13,555 INFO  org.apache.flink.runtime.io.network.NettyShuffleEnvironment   - Starting the network environment and its components.
2019-12-14 20:50:13,606 INFO  org.apache.flink.runtime.io.network.netty.NettyClient         - Successful initialization (took 50 ms).
2019-12-14 20:50:14,051 INFO  org.apache.flink.runtime.io.network.netty.NettyServer         - Successful initialization (took 444 ms). Listening on SocketAddress /127.0.0.1:24623.
2019-12-14 20:50:14,071 INFO  org.apache.flink.runtime.taskexecutor.KvStateService          - Starting the kvState service and its components.
2019-12-14 20:50:14,071 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerServices     - Limiting managed memory to 0.7 of the currently free heap space (681 MB), memory will be allocated lazily.
2019-12-14 20:50:14,083 INFO  org.apache.flink.runtime.taskexecutor.TaskManagerConfiguration  - Messages have a max timeout of 10000 ms
2019-12-14 20:50:14,091 INFO  org.apache.flink.runtime.rpc.akka.AkkaRpcService              - Starting RPC endpoint for org.apache.flink.runtime.taskexecutor.TaskExecutor at akka://flink/user/taskmanager_0 .
2019-12-14 20:50:14,104 INFO  org.apache.flink.runtime.taskexecutor.JobLeaderService        - Start job leader service.
2019-12-14 20:50:14,106 INFO  org.apache.flink.runtime.filecache.FileCache                  - User file cache uses directory C:\Users\Administrator\AppData\Local\Temp\flink-dist-cache-a05bf24e-9c70-4003-a380-1f619961408d
2019-12-14 20:50:14,108 INFO  org.apache.flink.runtime.taskexecutor.TaskExecutor            - Connecting to ResourceManager akka.tcp://flink@localhost:6123/user/resourcemanager(00000000000000000000000000000000).
2019-12-14 20:50:14,349 INFO  org.apache.flink.runtime.taskexecutor.TaskExecutor            - Resolved ResourceManager address, beginning registration
2019-12-14 20:50:14,349 INFO  org.apache.flink.runtime.taskexecutor.TaskExecutor            - Registration at ResourceManager attempt 1 (timeout=100ms)
2019-12-14 20:50:14,409 INFO  org.apache.flink.runtime.taskexecutor.TaskExecutor            - Successful registration at resource manager akka.tcp://flink@localhost:6123/user/resourcemanager under registration id 68215ad0060c0d8327b7b9200bf86f55.
```