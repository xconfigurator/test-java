package liuyang.algorithms202312.ch30streamapi;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * p349
 * @author xconf
 * @since 2023/11/17
 */
public class _30_06_CollectGroupDemo {
    public static void main(String[] args) {
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen", "George", "Alan", "Stacy", "Michelle", "john"};
        Map<String, Long> map1 = Stream.of(names).map(e -> e.toUpperCase()).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(map1);

        Map<Object, Long> map2 = Stream.of(names).collect(Collectors.groupingBy(e -> e.charAt(0), TreeMap::new, Collectors.counting()));
        System.out.println(map2);

        int[] values = {2, 3, 4, 1, 2, 3, 2, 3, 4, 5, 1, 421};
        IntStream.of(values)
                .mapToObj(e -> e)
                .collect(Collectors.groupingBy(e -> e, TreeMap::new, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " occurs " + v + (v > 1 ? " times" : " time'")));

        MyStudent[] students = {
                new MyStudent("John", "Lu", "CS", 32, 78),
                new MyStudent("Susan", "Yao", "Math", 31, 85.4),
                new MyStudent("Kim", "Johnson", "CS", 30, 78.1)
        };

        System.out.printf("%10s%10s\n", "Department", "Average");
        Stream.of(students)
                .collect(Collectors.groupingBy(MyStudent::getMajor, TreeMap::new, Collectors.averagingDouble(MyStudent::getScore)))
                .forEach((k, v) -> System.out.printf("%10s%10.2f\n", k, v));
    }
}

@AllArgsConstructor
@Getter
class MyStudent {
    private String firstName;
    private String lastName;
    private String major;
    private int age;
    private double score;
}
