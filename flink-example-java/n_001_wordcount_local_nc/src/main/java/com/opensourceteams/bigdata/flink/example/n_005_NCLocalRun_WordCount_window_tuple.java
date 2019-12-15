package com.opensourceteams.bigdata.flink.example;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

public class n_005_NCLocalRun_WordCount_window_tuple {

    public static void main(String[] args) throws Exception {

        final  int port = 1234 ;
        // get the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // get input data by connecting to the socket
        DataStream<String> text = env.socketTextStream("localhost", port, "\n");


        DataStream<Tuple2<String,Integer>> wordDataStream =  text.flatMap(new FlatMapFunction<String, Tuple2<String,Integer>>() {
            @Override
            public void flatMap(String s, Collector<Tuple2<String,Integer>> collector) throws Exception {
                for(String word : s.split(" ")){
                    //一次数据
                    collector.collect(new Tuple2<String,Integer>(word,1));
                }

            }
        })
                ;


        DataStream<Tuple2<String,Integer>> wordCount =  wordDataStream.keyBy(0)
                .timeWindow(Time.milliseconds(100))
                .reduce(new ReduceFunction<Tuple2<String,Integer>>() {
                    @Override
                    public Tuple2<String,Integer> reduce(Tuple2<String,Integer> a, Tuple2<String,Integer> b) throws Exception {
                        return new  Tuple2<String,Integer>(a.f0,a.f1 + b.f1);
                    }
                })
                ;


        wordCount.print().setParallelism(1);

        env.execute("输出nc终端数据") ;



    }


}
