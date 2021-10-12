package liuyang.date;

import liuyang.date.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author liuyang
 * @date 2021/8/10
 */
@Slf4j
public class DateJDK8Test {

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
