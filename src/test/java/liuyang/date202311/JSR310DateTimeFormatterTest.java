package liuyang.date202311;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * https://www.bilibili.com/video/BV1PY411e7J6/?p=148&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 29:28
 *
 * SimpleDateFormatter -> java.util.Date
 * DateTimeFormatter -> LocalDateTime LocalDate LocalTime
 *
 * @author xconf
 * @since 2023/11/8
 */
@Slf4j
public class JSR310DateTimeFormatterTest {

    @DisplayName("自定义格式")
    @Test
    void test202311090023() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        // 格式化
        log.info("{}", dateTimeFormatter.format(LocalDateTime.now()));
        // 解析
        log.info("{}", LocalDateTime.from(dateTimeFormatter.parse("2023-11-09 00:39:38.542")));
    }

    @DisplayName("预设格式")
    @Test
    void test202311082341() {
        // 预定义格式
        LocalDateTime now = LocalDateTime.now();

        log.info("ISO_LOCAL_DATE_TIME\t{}", DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(now));
        log.info("ISO_LOCAL_DATE\t\t{}", DateTimeFormatter.ISO_LOCAL_DATE.format(now));
        log.info("ISO_LOCAL_TIME\t\t{}", DateTimeFormatter.ISO_LOCAL_TIME.format(now));

        log.info("ISO_DATE_TIME\t\t\t{}", DateTimeFormatter.ISO_DATE_TIME.format(now));
        log.info("ISO_DATE\t\t\t\t{}", DateTimeFormatter.ISO_DATE.format(now));
        log.info("ISO_TIME\t\t\t\t{}", DateTimeFormatter.ISO_TIME.format(now));

        log.info("ISO_WEEK_DATE\t\t\t{}", DateTimeFormatter.ISO_WEEK_DATE.format(now));// 周视图。

        // liuyang 2023/11/9 下面的调用貌似有错，先不深究，已经够用了。
        //log.info("ISO_OFFSET_DATE_TIME\t{}", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(now));
        //log.info("ISO_OFFSET_DATE\t{}", DateTimeFormatter.ISO_OFFSET_DATE.format(now));
        //log.info("ISO_OFFSET_TIME\t{}", DateTimeFormatter.ISO_OFFSET_TIME.format(now));

        //log.info("ISO_INSTANT\t{}", DateTimeFormatter.ISO_INSTANT.format(now));
        //log.info("ISO_ORDINAL_DATE\t{}", DateTimeFormatter.ISO_ORDINAL_DATE.format(now));
        //log.info("ISO_ZONED_DATE_TIME\t{}", DateTimeFormatter.ISO_ZONED_DATE_TIME.format(now));

        // 小应用：把字符串解析回来
        TemporalAccessor parse = DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2023-11-09T00:32:09.390362");
        LocalDateTime from = LocalDateTime.from(parse);
        // 这就有了日期对象！！！
    }
}
