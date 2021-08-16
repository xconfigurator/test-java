package liuyang.date;

import liuyang.date.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author liuyang
 * @date 2021/8/10
 */
@Slf4j
public class DateJDK8Test {

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
