package liuyang.concurrency2022;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 目标：产生4个（可变）线程，让其分别随机延迟一段时间启动
 * 分析：
 *  1. Executor.newScheduledThreadPool()
 *  2. 产生指定数量的，指定范围内的随机数
 *
 * @since 2022/9/1
 */
@Slf4j
public class ExecutorsTest20220901 {

    // 如果delay是0会怎样？
    // 答：立即执行。
    @Test
    void test202209012145() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);

        scheduledExecutorService.schedule(() -> {
            log.info("foo");
        }, 0, TimeUnit.MILLISECONDS);
        scheduledExecutorService.schedule(() -> {
            log.info("bar");
        }, 0, TimeUnit.MILLISECONDS);

        scheduledExecutorService.shutdown();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 指定范围的随机数
    // Double.valueOf(double).longValue();
    @Test
    void test202209012042() {
        final int RANGE = 1000;
        for (int i = 0; i < 10; ++i) {
            log.info("{}", Double.valueOf(RANGE * Math.random()).longValue());
        }
    }

    // 测试随机数
    // https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html
    @Test
    void test202209012039() {
        for (int i = 0; i < 10; ++i) {
            log.info("{}", Math.random());// Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
        }
    }

    // 最基本的delay
    @Test
    void test202209012037() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        scheduledExecutorService.schedule(()->{
            log.info("delay 2 seconds");
        }, 2, TimeUnit.SECONDS);

        scheduledExecutorService.schedule(() -> {
            log.info("delay 1 seconds");
        }, 1, TimeUnit.SECONDS);

        if (!scheduledExecutorService.isShutdown()){
            scheduledExecutorService.shutdown();// shutdown transactional
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch(InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }


}
