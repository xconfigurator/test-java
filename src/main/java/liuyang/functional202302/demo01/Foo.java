package liuyang.functional202302.demo01;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author xconf
 * @since 2023/2/23
 */
public class Foo {
    public static void main(String[] args) {
        int[] arr = {1 ,2 ,3 };
        Integer max = Collections.max(Arrays.asList(1, 2, 3));
        System.out.println(max);
        Stream.of(arr).forEach(e -> System.out.println(e));
        Arrays.asList(1, 2, 3).forEach(System.out::println);

        System.out.println("Hello".indexOf("H"));
    }
}
