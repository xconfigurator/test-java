package liuyang.date;

import liuyang.date.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;

/**
 * 可参考文档：
 * https://www.jianshu.com/p/048ee8580639
 *
 * @author liuyang
 * @date 2021/8/10
 */
@Slf4j
public class DateJDK8Test {

    @Test
    void test202208312322() {
        // 需要获得java.util.Date实例相对当前凌晨的差值(毫秒数)
        Date date = new Date();
        LocalDateTime now =  Instant
                .ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        LocalDateTime today0am = now.withHour(0).withMinute(0).withSecond(0).withNano(0);
        log.info("now = {}", now);// e.g. 23:35:10.909 [main] INFO liuyang.date.DateJDK8Test - now = 2022-08-31T23:35:10.903
        log.info("today0am = {}", today0am);// e.g. 23:35:10.911 [main] INFO liuyang.date.DateJDK8Test - today0am = 2022-08-31T00:00
        long nowMilli = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long today0amMilli = today0am.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long delta = nowMilli - today0amMilli;
        log.info("delta       = {}", delta);

        int deltaInt = Long.valueOf(delta).intValue();
        log.info("deltaInt    = {}", deltaInt);

        // 一天的总毫秒数
        log.info("一天的总毫秒数 = {}", 24 * 3600 * 1000);
        /*
        // 输出示例
        23:52:42.183 [main] INFO liuyang.date.DateJDK8Test - now = 2022-08-31T23:52:42.176
        23:52:42.186 [main] INFO liuyang.date.DateJDK8Test - today0am = 2022-08-31T00:00
        23:52:42.186 [main] INFO liuyang.date.DateJDK8Test - delta       = 85962176
        23:52:42.186 [main] INFO liuyang.date.DateJDK8Test - 一天的总毫秒数 = 86400000
         */
        /*
        06:49:17.566 [main] INFO liuyang.date.DateJDK8Test - now = 2022-09-01T06:49:17.560
        06:49:17.568 [main] INFO liuyang.date.DateJDK8Test - today0am = 2022-09-01T00:00
        06:49:17.568 [main] INFO liuyang.date.DateJDK8Test - delta       = 24557560
        06:49:17.569 [main] INFO liuyang.date.DateJDK8Test - deltaInt    = 24557560
        06:49:17.569 [main] INFO liuyang.date.DateJDK8Test - 一天的总毫秒数 = 86400000
         */
    }

    @Test
    void test202205201321() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);
        log.info(dtf.format(LocalDateTime.now()));
    }

    @Test
    void test20220201319() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // LocalDateTime -> String
        log.info(dtf.format(LocalDateTime.now()));
    }

    // 时间差值
    @Test
    void test202205201102() throws ParseException {
        // type1: 也许不好，但能用
        // 日期间隔
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateBegin = sdf.parse("2014-02-22 07:01:01");
        Date dateEnd = new Date();
        long days = Duration.between(DateUtils.asLocalDateTime(dateBegin), DateUtils.asLocalDateTime(dateEnd)).toDays();
        log.info("days = {}", days);

        // type2: 推荐
        // 参考：https://www.jianshu.com/p/048ee8580639
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldtBegin = LocalDateTime.parse("2014-02-22 07:01:01", dtf);// String -> LocalDateTime
        long days2 = Duration.between(ldtBegin, LocalDateTime.now()).toDays();
        log.info("days = {}", days2);
    }

    @Test
    void test202109261319() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 取上个月的1号
        Date startDate = DateUtils.asDate(LocalDate.now().minusMonths(1).withDayOfMonth(1));
        log.info("上月1日：" + sdf.format(startDate));
        // 本月1号
        Date startDateThisMonth = DateUtils.asDate(LocalDate.now().withDayOfMonth(1));
        log.info("本月1日：" + sdf.format(startDateThisMonth));
    }

    @Test
    void testDateTimeFormatter() {
        String date = "2021-09-26";// 2021-09-26 ok 2021-9-26 error
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        log.info(localDate.toString());
    }


    // 指定的时间必须大于当前时间
    @Test
    void test202109161051() {
        // 模拟基准时间
        Date dateLocalDateCurr = DateUtils.asDate(LocalDate.now());
        Date dateLocalDateTimeCurr = DateUtils.asDate(LocalDateTime.now());
        // 模拟错误的时间
        Date dateLocalDateErr = DateUtils.asDate(LocalDate.now().minusDays(1));
        Date dateLocalDateTimeErr = DateUtils.asDate(LocalDateTime.now().minusDays(1));

        if (dateLocalDateErr.getTime() < dateLocalDateCurr.getTime()) {
            log.error("指定的日期不能小于当前时间");
        }
        if (dateLocalDateTimeErr.getTime() < dateLocalDateTimeCurr.getTime()) {
            log.error("指定的时间不能小于当前时间");
        }
    }

    // 获得次日凌晨的时刻
    @Test
    void test202108100928() {
        // 联合写
        Date startTime = new Date();
        startTime = DateUtils.asDate(
                DateUtils.asLocalDateTime(startTime)
                        .plusDays(1).withHour(0).withMinute(0).withSecond(1).withNano(0)
        );
        log.info("tmr = {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTime));
    }

    // 获得次日凌晨的时刻 第二种写法
    @Test
    void test202110121027() {
        Date date = DateUtils.asDate(LocalDateTime.of(LocalDate.now(), LocalTime.MIN).plusDays(1).plusHours(1).plusMinutes(1));
        log.info("tmr = {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }

    // 获得次日凌晨的时刻
    @Test
    void test202108100927() {
        // 参考：https://blog.csdn.net/qq_32871365/article/details/105610769
        /*
        //从一个 Instant和区域ID获得 LocalDateTime实例
        LocalDateTime localDateTime=LocalDateTime.ofInstant(currentTime.toInstant(), ZoneId.systemDefault());
        //获取第第二天零点时刻的实例
        LocalDateTime toromorrowTime=LocalDateTime.ofInstant(currentTime.toInstant(), ZoneId.systemDefault())
                .plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        //ChronoUnit日期枚举类,between方法计算两个时间对象之间的时间量
        long seconds = ChronoUnit.SECONDS.between(localDateTime, toromorrowTime);
        return (int)seconds;
         */

        // 分开写
        // 1. 入参
        Date date = new Date(); // LocalDateTime now = LocalDateTime.now();
        // 2. 计算
        //LocalDateTime tomorrow = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime tomorrowLocalDateTime = DateUtils.asLocalDateTime(date).plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        log.info("tomorrowLocalDateTime = {}", tomorrowLocalDateTime);
        // 3. 转回Date
        Date dateTomorrow = DateUtils.asDate(tomorrowLocalDateTime);
        log.info("dataTomorrow = {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTomorrow));
    }
}
