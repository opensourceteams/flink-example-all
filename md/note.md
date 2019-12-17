# 笔记

- 事件驱动（Event driven）
- 基于流的世界观
- 分层的api(sql/table api、DataStream api(stream,window)、ProcessFunction(events、state、time))

- 程序和数据流(DataFlow)
- StreamGraph
- JobGraph
- ExecutionGraph
- 物理执行图


- 并行度(Parallelism)


## 作业提交流程
- 提交应用(App)
- 启动并提交应用(Dispatcher)
- 向资源管理器请求slots(JobManager)



## 源码分析
- 作业提交流程(本地提交)
- 作业提交流程(standalone)
- 作业提交流程(YARN)

- Flink任务调度原理