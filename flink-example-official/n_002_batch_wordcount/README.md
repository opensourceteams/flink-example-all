# java版 batch wordCount

## 更多资源
- https://github.com/opensourceteams/flink-example-all
## 简介
- 统计文件中单词个数、打印输出结果
- 批处理

#### 输入数据
```aidl
c a a
c a b
```
#### 源码

```aidl
package opensourceteams.bigdata.flink.example.batch.wordcount;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class Run {

    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<String> dataSet =env.readTextFile("data/word.txt");
        DataSet<Tuple2<String,Integer>> dataSet1 = dataSet.flatMap(new Tokenizer()).groupBy(0).sum(1);
        dataSet1.print();

    }


    public static class Tokenizer implements FlatMapFunction<String,Tuple2<String,Integer>>{

        @Override
        public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
            String[] tokens = s.toLowerCase().split("\\W+");
            for(String token :tokens){
                collector.collect(new Tuple2<>(token,1));
            }

        }
    }
}

```
#### 输出数据
```aidl
(a,3)
(b,1)
(c,2)
```