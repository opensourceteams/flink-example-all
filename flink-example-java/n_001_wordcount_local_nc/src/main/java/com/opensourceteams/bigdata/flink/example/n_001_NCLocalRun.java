package com.opensourceteams.bigdata.flink.example;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class n_001_NCLocalRun {


    public static void main(String[] args) throws Exception {

        final  int port = 1234 ;
        // get the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // get input data by connecting to the socket
        DataStream<String> text = env.socketTextStream("localhost", port, "\n");


        text.print().setParallelism(1);

        env.execute("输出nc终端数据") ;


    }
}
