package io.github.ihelin.demo.flink;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class StreamWorkCount {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();

        String inputPath = "/Users/iHelin/Documents/IdeaProjects/hello/src/main/resources/flink-text.txt";

        DataStreamSource<String> source = environment.readTextFile(inputPath);

        SingleOutputStreamOperator<Tuple2<String, Integer>> result = source.flatMap(new MyFlatMapper())
                .keyBy(0)
                .sum(1);

        result.print();

        environment.execute();

    }
}
