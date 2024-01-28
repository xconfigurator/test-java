package liuyang.functional202401;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 基本用法
 * 视频：https://www.bilibili.com/video/BV1sC4y1K7ET/?p=6&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * @author xconf
 * @since 2024/1/27
 */
@Slf4j
public class StreamAPI02Test {

    /**
     * 1. 创建流
     * of, builder, empty, ofNullable, generate, concat, 集合.stream()
     *
     * 2. 中间操作
     * filter
     * map, mapToInt, mapToLong, mapToDouble
     * flatMap, flatMapToInt, flatMapToLong, flatMapToDouble
     * mapMulti, mapMultiToInt, mapMultiToLong, mapMultiToDouble
     * parallel, unordered, onClose, sequential
     * distinct, sorted, peek, limit, skip, takeWhile, dropWhile
     * 重点：filter, map, flatMap, distinct, sorted, peek, takeWhile
     *
     * 3. 终止操作(流都是懒加载的，直到明确指定终止操作才实际进行运行)
     * forEach, forEacheOrdered
     * toArray
     * reduce, collect, toList
     * min, max, count
     * anyMatch, nonMatch
     * findFirst, findAny
     * iterator
     */

    @DisplayName("创建流")
    @Test
    void test202401271844CreateStream() {
        // 1. 使用Stream
        Stream.of(1, 2, 3);
        Stream.concat(Stream.of(1, 2, 3), Stream.of(4, 5, 6));
        Stream.builder().add("1").add("2").add("3").build();

        // 2. 通过容器
        List.of(1, 2).stream();
        Map.of().keySet().stream();
        Map.of("k1", "v1", "k2", "v2").values().stream();
    }

    @DisplayName("中间操作 终止操作 并行流")
    @Test
    void test202401271853() {
        // 注意流操作最好不要操作有状态数据，如果需要则加锁或考虑使用其他方案。
        long count = IntStream.rangeClosed(1, 5)
                .parallel()// 如果不加，则都在主线程执行，与for循环无差别，如果加上了则并行，可以通过观察日志发现。
                .filter(i -> {
                    log.info("看看是哪个线程在执行 正在过滤 {}的操作", i);
                    return i > 2;
                })// intermediate operation
                .count();// terminal operation
        log.info("大于2的个数： count = {}", count);
    }
}
