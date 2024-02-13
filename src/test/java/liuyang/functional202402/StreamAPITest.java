package liuyang.functional202402;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 马士兵教育的这套Stream API讲得比较简要。适合快速复习一下概念。
 * 深入细节的操作应该参考其他视频和资料。
 *
 * @author xconf
 * @since 2024/1/29
 */
@Slf4j
public class StreamAPITest {

    @Test
    void test202401290524() {
        List<String> list = Arrays.asList("张无忌", "周芷若", "赵敏", "张强", "张三丰");
        list.stream()
                .filter(e -> e.startsWith("张"))
                .filter(e -> e.length() == 3)
                .forEach(System.out::println);
    }

    @Test
    void test202401290714() {
        int[] arr = {1, 2, 3, 4};
        // 比较一下
        log.info("{}", Stream.of(arr));
        log.info("{}", Arrays.stream(arr));
        // 这个能打印么？
        Stream.of(arr).forEach(System.out::println);// failure
        // 这个能打印么？
        Arrays.stream(arr).forEach(System.out::println);// ok
    }

    @Test
    void test202401290729() {
        log.info("skip");
        Arrays.asList(1, 2, 3, 4).stream().skip(2).forEach(System.out::println);
        log.info("concat");
        Stream.concat(Arrays.asList(1, 2).stream(), Arrays.asList(2, 3).stream()).forEach(System.out::println);
    }
}
