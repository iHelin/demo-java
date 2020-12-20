package me.ianhe.flink;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;

public class WordCount {

    public static void main(String[] args) throws Exception {
        ExecutionEnvironment environment = ExecutionEnvironment.getExecutionEnvironment();

        String inputPath = "/Users/iHelin/Documents/IdeaProjects/hello/src/main/resources/flink-text.txt";

        DataSource<String> dataSource = environment.readTextFile(inputPath);
        AggregateOperator<Tuple2<String, Integer>> result = dataSource.flatMap(new MyFlatMapper())
                .groupBy(0)
                .sum(1);
        result.print();
    }

}
