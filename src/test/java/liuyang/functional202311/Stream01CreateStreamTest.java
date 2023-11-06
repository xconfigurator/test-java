package liuyang.functional202311;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.bilibili.com/video/BV1PY411e7J6/?p=197&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 09:26 开始。前面废话。
 *
 * 1. Stream实例化
 * 2. 中间操作
 * 3. 终止操作(终端操作)
 *
 * @author xconf
 * @since 2023/11/2
 */
@Slf4j
public class Stream01CreateStreamTest {
    // 方式1： 通过集合获取流
    @Test
    void test01() {
        // 顺序流
        Stream<Integer> s1 = Arrays.asList(1, 2, 3).stream();
        // 并行流
        Stream<Integer> s2 = Arrays.asList(1, 2, 3).parallelStream();
    }

    // 通方式2：过数组获取流
    @Test
    void test02() {
        Stream<Integer> streamInteger = Arrays.stream(new Integer[]{1, 2, 3});

        // 泛型只能用类，所以这种情况就处理成了IntStream
        int[] arr = new int[]{1, 2, 3};
        IntStream streamInt = Arrays.stream(arr);
    }

    // 方式3：Stream.of
    @Test
    void test03() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
    }
}
