package com.opensourceteams.bigdata.flink.example;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class n_002_NCLocalRun_SplitWord {

    public static void main(String[] args) throws Exception {

        final  int port = 1234 ;
        // get the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // get input data by connecting to the socket
        DataStream<String> text = env.socketTextStream("localhost", port, "\n");


        DataStream<String> wordDataStream =  text.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public void flatMap(String s, Collector<String> collector) throws Exception {
                System.out.println("输入的一行数据:"+s);
                // for(String word : s.split("\\\\s")){
                for(String word : s.split(" ")){
                    collector.collect(word);
                }

            }
        })
                ;


        System.out.println("=========================打印的数据=========================");
        wordDataStream.print().setParallelism(1);

        env.execute("输出nc终端数据") ;



    }
}
