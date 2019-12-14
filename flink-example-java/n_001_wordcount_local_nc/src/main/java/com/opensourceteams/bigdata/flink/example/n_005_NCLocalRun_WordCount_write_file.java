package com.opensourceteams.bigdata.flink.example;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

public class n_005_NCLocalRun_WordCount_write_file {

    public static void main(String[] args) throws Exception {

        final  int port = 1234 ;
        // get the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // get input data by connecting to the socket
        DataStream<String> text = env.socketTextStream("localhost", port, "\n");


        DataStream<WordWithCount> wordDataStream =  text.flatMap(new FlatMapFunction<String, WordWithCount>() {
            @Override
            public void flatMap(String s, Collector<WordWithCount> collector) throws Exception {
                System.out.println("输入的一行数据:"+s);
                // for(String word : s.split("\\\\s")){
                for(String word : s.split(" ")){
                    //一次数据
                    collector.collect(new WordWithCount(word,1L));
                }

            }
        })
                ;


        DataStream<WordWithCount> wordCount =  wordDataStream.keyBy("word").timeWindow(Time.milliseconds(10))
                .reduce(new ReduceFunction<WordWithCount>() {
                    @Override
                    public WordWithCount reduce(WordWithCount a, WordWithCount b) throws Exception {
                        return new WordWithCount(a.getWord(),a.getCount() + b.getCount());
                    }
                })
                ;


        wordCount.writeAsText("file:///a.txt").setParallelism(1);

        env.execute("输出nc终端数据") ;



    }


}
