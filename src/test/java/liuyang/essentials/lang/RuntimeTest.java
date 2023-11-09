package liuyang.essentials.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author xconf
 * @since 2023/11/9
 */
@Slf4j
public class RuntimeTest {

    @Test
    void test() {
        log.info("maxMemory: {} MB", (Runtime.getRuntime().maxMemory() / 1024 / 1024));// JVM能使用的物理内存总量
        log.info("totalMemory: {} MB", (Runtime.getRuntime().totalMemory() / 1024 / 1024));// JVM初始化时的内存总量。
        log.info("freeMemory: {} MB", (Runtime.getRuntime().freeMemory() / 1024 / 1024));
        log.info("usedMemory: {} MB", ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024/ 1024));
        Runtime.getRuntime().gc();
        System.gc();// Runtime.getRuntime().gc();
    }
}
