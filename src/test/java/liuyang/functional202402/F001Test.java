package liuyang.functional202402;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * @author xconf
 * @since 2023/10/31
 */
@Slf4j
public class F001Test {

    @Test
    void test202310312008Hello() {
        // 202302写的，耽误了，今天继续。删除原来的包。
        int[] arr = {1 ,2 ,3 };
        Integer max = Collections.max(Arrays.asList(1, 2, 3));
        System.out.println(max);
        Stream.of(arr).forEach(e -> System.out.println(e));
        Arrays.asList(1, 2, 3).forEach(System.out::println);

        System.out.println("Hello".indexOf("H"));
    }
}
