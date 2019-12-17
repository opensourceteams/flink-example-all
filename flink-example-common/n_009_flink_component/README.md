# Flink 组件

## 更多资源
- https://github.com/opensourceteams/flink-example-all
## JobManager
- 控制一个应用程序执行的主进程，也就是说，每个应用程序都会被一个不同的JobManager所控制执行
- JobManager会先接收到要执行的就用程序，这个应用程序会包括：作业图(JobGraph)、逻辑数据流图(logical dataflow graph)、和打包了所有的类库、和其它资源的jar包
- JobManager 会把JobGraph转换成一个物理层面的数据流图，这个图被叫做执行图(ExecutionGraph)，包含了所有可以并发执行的任务
- JobManager 会向资源管理器(ResourceManager)请求执行任务必要的资源，也就是任务管理器(TaskManager)上。而在运行过程中，JobManager会负责所有需要中央协调的操作，比如说检查点(checkppoints)的协调