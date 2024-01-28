package liuyang.algorithms202312.ch30streamapi;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * p335
 * @author xconf
 * @since 2023/11/15
 */
public class _30_01_StreamDemo {
    public static void main(String[] args) {
        // 对比C++的字符串数组
        // string weekdays[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen", "George", "Alan", "Stacy", "Michelle", "john"};

        // Display the first four names sorted
        Stream.of(names)
                .limit(4)
                .sorted()
                .forEach(e -> System.out.print(e + " "));

        // Skip four names and display the rest sorted ignore case
        System.out.println();
        Stream.of(names)
                .skip(4)
                .sorted((e1, e2) -> e1.compareToIgnoreCase(e2))
                .forEach(e -> System.out.print(e + " "));

        System.out.println();
        Stream.of(names)
                .skip(4)
                .sorted(String::compareToIgnoreCase)// 方法引用
                .forEach(e -> System.out.print(e + " "));

        System.out.println("\nLargest string with length > 4: "
                + Stream.of(names).filter(e -> e.length() > 4).max(String::compareTo).get());

        System.out.println("Smallest string alphabetically: "
                + Stream.of(names).min(String::compareTo).get());

        System.out.println("Stacy is in names? "
                + Stream.of(names).anyMatch(e -> e.equals("Stacy")));

        System.out.println("All names start with a capital letter? "
                + Stream.of(names).allMatch(e -> Character.isUpperCase(e.charAt(0))));

        System.out.println("No name begins with Ko? "
                + Stream.of(names).noneMatch(e -> e.startsWith("Ko")));

        System.out.println("Number of distinct case-insensitive string:"
                + Stream.of(names).map(e -> e.toUpperCase()).distinct().count());

        System.out.println("First element in this stream in lowercase: "
                + Stream.of(names).map(e -> e.toLowerCase()).findFirst().get());

        System.out.println("Skip 4 and get any element in this stream: "
                + Stream.of(names).skip(4).sorted().findAny().get());

        Object[] namesInLowerCase = Stream.of(names).map(String::toLowerCase).toArray();
        System.out.println(Arrays.toString(namesInLowerCase));

        // liuyang 转成字符串数组
        String[] array = Stream.of(names).map(String::toLowerCase).toArray(String[]::new);
        System.out.println(Arrays.toString(array));
    }
}
