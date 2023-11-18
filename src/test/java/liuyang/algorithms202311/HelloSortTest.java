package liuyang.algorithms202311;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 测试一些排序的基础设施
 *
 * 1. 生成指定长度的含随机值的数组
 * 2. Java提供的排序工具
 *
 * 参考：
 * https://zhuanlan.zhihu.com/p/196698839#:~:text=Integer%5B%5D%20integers1%20%3D%20Arrays.stream%28data%29.boxed%28%29.toArray%28Integer%5B%5D%3A%3Anew%29%3B%20%E5%89%8D%E4%B8%A4%E6%AD%A5%E5%90%8C%E4%B8%8A%EF%BC%8C%E6%AD%A4%E6%97%B6%E6%98%AF%20Stream%3CInteger%3E%20%E3%80%82%20%E7%84%B6%E5%90%8E%E4%BD%BF%E7%94%A8,%EF%BC%8C%E4%BC%A0%E5%85%A5%20IntFunction%3CA%20%5B%5D%3E%20generator%20%E3%80%82%20%E8%BF%99%E6%A0%B7%E5%B0%B1%E5%8F%AF%E4%BB%A5%E8%BF%94%E5%9B%9E%20Integer%20%E6%95%B0%E7%BB%84%E3%80%82
 *
 * @author xconf
 * @since 2023/11/15
 */
@Slf4j
public class HelloSortTest {
    @DisplayName("产生随机测试数据 Integer[]")
    @ParameterizedTest
    @ValueSource(ints = {10, 50})
    void test202311150358(int arraySize) {
        // Math.random() 产生[0, 1)的double值
        // Random类的实例，nextInt(int bound)更符合需求
        Random r = new Random();
        Integer[] array =
                Stream.generate(() -> r.nextInt(100))
                .limit(arraySize)
                //.peek(n -> log.debug("n = {}", n))
                //.collect(Collectors.toList())// 这一步对本目的没啥用
                //.toArray(new Integer[arraySize]);// ok
                .toArray(Integer[]::new);//ok
        log.info("排序前：{}", Arrays.toString(array));
        Arrays.sort(array);// 自动装箱
        log.info("排序后：{}", Arrays.toString(array));
    }

    @DisplayName("产生随机测试数据 int[]")
    @ParameterizedTest
    @ValueSource(ints = {10, 50})
    void test202311150616(int arraySize) {
        Random r = new Random();
        int[] array = Stream.generate(() -> r.nextInt(100))
                .limit(arraySize)
                .mapToInt(Integer::valueOf)
                .toArray();
        log.info("排序前：{}", Arrays.toString(array));
        Arrays.sort(array);
        log.info("排序后:{}", Arrays.toString(array));
    }

    @DisplayName("产生范围测试数据 int[] ")
    @ParameterizedTest
    @ValueSource(ints = {10, 50})
    void test202311151027(int arraySize) {
        int[] array = IntStream.rangeClosed(1, arraySize).boxed().mapToInt(Integer::valueOf).toArray();
        ArrayUtils.shuffle(array);
        log.info("排序前：{}", Arrays.toString(array));
        Arrays.sort(array);
        log.info("排序后：{}", Arrays.toString(array));
    }

}
