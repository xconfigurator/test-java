package liuyang.date202311;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * https://www.bilibili.com/video/BV1PY411e7J6/?p=148&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * @author xconf
 * @since 2023/11/5
 */
@Slf4j
public class JSR310LocalDateTimeTest {

    @DisplayName("LocalDate LocalTime LocalDateTime - now()")
    @Test
    void test202311082229Now() {// 现在
        log.info("{}", LocalDate.now());
        log.info("{}", LocalTime.now());
        log.info("{}", LocalDateTime.now());
    }

    @DisplayName("LocalDate LocalTime LocalDateTime - of()")
    @Test
    void test202311082325Of() {// 指定
        log.info("{}", LocalDate.of(2023, 7,9));// 不像Date和Calendar有“偏移”的问题。
        log.info("{}", LocalTime.of(6, 30, 01));
        log.info("{}", LocalDateTime.of(2023, 7, 9, 6, 30, 01));
    }

    @DisplayName("计算 - 体现不可变性")
    @Test
    void test202311082326() {
        // 体现不可变性
        LocalDateTime ldt1 = LocalDateTime.now();
        LocalDateTime ldt2 = ldt1.withDayOfMonth(15);// 基于时间ldt1调整到当月15号
        log.info("{}", ldt1);
        log.info("{}", ldt2);
        log.info("{}", ldt1);

        // 其他计算
        log.info("当前日期5天后:{}", ldt1.plusDays(5));
        log.info("当前日期5天前:{}", ldt1.minusDays(5));

        // 是否闰年
        log.info("是否闰年:{}", ldt1.toLocalDate().isLeapYear());
    }
}
