package liuyang.algorithms202312.ch30streamapi;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * p339
 *
 * Stream mapToInt mapToLong mapToDouble
 * IntStream\LongStream\DoubleStream
 *
 * @author xconf
 * @since 2023/11/16
 */
public class _30_02_IntstreamDemo {
    public static void main(String[] args) {
        int[] values = {3, 4, 1, 5, 20, 1, 3, 3, 4, 6};

        System.out.println("The average of distinct even numbers > 3: " +
                IntStream.of(values)
                        .distinct()
                        .filter(e -> e > 3 && e % 2 == 0)
                        .average()
                        .getAsDouble());

        System.out.println("The sum of the first 4 numbers is " +
                IntStream.of(values).limit(4).sum());

        IntSummaryStatistics stats = IntStream.of(values).summaryStatistics();

        System.out.printf("The summary of the stream is \n%-10s%10d\n" +
                "%-10s%10d\n%-10s%10d\n%-10s%10d\n%-10s%10.2f\n",
                "Count:", stats.getCount(),
                "Max:", stats.getMax(),
                "Min:", stats.getMin(),
                "Sum:", stats.getSum(),
                "Average:", stats.getAverage());

        String[] names = {"John", "Peter", "Susan", "Kim", "Jen", "George", "Alan", "Stacy", "Michelle", "john"};

        System.out.println("Total character count for all names is "
                + Stream.of(names).mapToInt(e -> e.length()).sum());

        System.out.println("The number of digits in array values is "
                + Stream.of(values).map(e -> e + "").mapToInt(e -> e.length()).sum());

        System.out.println("The number of digits in array values is "
                + Stream.of(values).map(String::valueOf).mapToInt(String::length).sum());// liuyang 方法引用版本
    }
}
