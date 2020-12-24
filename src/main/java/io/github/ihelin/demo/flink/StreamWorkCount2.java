package io.github.ihelin.demo.flink;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class StreamWorkCount2 {

    /**
     * nc -lk 7000
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> source = environment.socketTextStream("127.0.0.1", 7000);

        SingleOutputStreamOperator<Tuple2<String, Integer>> result = source.flatMap(new MyFlatMapper())
                .keyBy(0)
                .sum(1);

        result.print();

        environment.execute();
    }
}
