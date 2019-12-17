# Cygwin 路径转换
## window 路径转linux
```
$ cygpath -p "D:\workspaces\bigdata\flink\flink-example-all\flink-example-scala\n_001_streaming_disable_OperatorChaining" -a
/cygdrive/d/workspaces/bigdata/flink/flink-example-all/flink-example-scala/n_001_streaming_disable_OperatorChaining
```

## .将Unix/Linux/Cygwin路径转换为Windows路径：
```
$ cygpath -p /usr/bin -a -w
D:\tmp\tmp_dev_root\cgwin\bin
```