package liuyang.date202311;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneOffset;

/**
 * https://www.bilibili.com/video/BV1PY411e7J6/?p=148&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 20:04 看一下介绍就可以了
 *
 * @author xconf
 * @since 2023/11/8
 */
@Slf4j
public class JSR310InstantTantTest {

    @Test
    void test202311082341() {
        /*
        Obtains the current instant from the system clock.
        This will query the system UTC clock to obtain the current instant.
        Using this method will prevent the ability to use an alternate time-source for testing because the clock is effectively hard-coded.
        Returns:
        the current instant using the system clock, not null
         */
        log.info("{}", Instant.now());
        log.info("{}", Instant.now().atOffset(ZoneOffset.ofHours(8)));// 东八区
        log.info("{}", Instant.now().toEpochMilli());// 1970-01-01 00:00:00到now()的毫秒数
        log.info("{}", Instant.ofEpochMilli(0));

    }
}
