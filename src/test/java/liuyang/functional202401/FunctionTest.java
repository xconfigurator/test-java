package liuyang.functional202401;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author xconf
 * @since 2024/1/27
 */
@Slf4j
public class FunctionTest {

    /**
     * 判断42这个字符串是奇数还是偶数
     * 视频：https://www.bilibili.com/video/BV1sC4y1K7ET/?p=4&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
     * 21:43左右
     */
    @Test
    void test202401271722() {
        // 1. 定义数据提供者
        Supplier<String> supplier = () -> "42";// 只出不进 .get()
        // 2. 断言
        Predicate<String> isNumber = str -> str.matches("-?\\d+(\\.\\d+)?");//
        // 3. 转换器
        Function<String, Integer> change = Integer::parseInt;// 有进有出 .apply
        // 4. 消费者：打印数字
        Consumer<Integer> consumer = i -> {// 只进不出 .accept
            if (i % 2 == 0) {
                log.info("{} 是偶数", i);
            } else {
                log.info("{} 是奇数", i);
            }
        };
        // 串在一起，实现需求
        if (isNumber.test(supplier.get())) {
            consumer.accept(change.apply(supplier.get()));
        } else {
            log.info("非法字符串");
        }
    }
}
