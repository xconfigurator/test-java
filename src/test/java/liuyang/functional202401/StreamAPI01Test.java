package liuyang.functional202401;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * 介绍
 * 视频：https://www.bilibili.com/video/BV1sC4y1K7ET/?p=5&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * @author xconf
 * @since 2024/1/27
 */
@Slf4j
public class StreamAPI01Test {

    @DisplayName("1. 找出集合中最大偶数")
    @Test
    void test202401271821() {
        // 写法1
        OptionalInt result = IntStream.rangeClosed(1, 10).filter(i -> i % 2 == 0).max();
        log.info("最大偶数 = {}", result.getAsInt());

        // 写法2
        IntStream.rangeClosed(1, 10).filter(i -> i % 2 == 0).max()
                .ifPresent(e -> log.info("最大偶数 = {}", e));
    }
}
