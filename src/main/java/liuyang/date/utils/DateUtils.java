package liuyang.date.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

/**
 * 积累
 * @author liuyang
 * @date 2021/8/10
 *
 * 参考liangze from pdt-soap-city
 */
public class DateUtils {

    // Date -> LocalDateTime
    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    // Date -> LocalDate
    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    // LocalDateTime -> Date
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    // LocalDate -> Date
    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 调整到次日凌晨执行
     * 由于设备上报是约定在凌晨零点1分钟的时候，省级上报开始时间统一约定为凌晨顶点15分中的时候开始。
     * @param startTime
     * @return
     */
    public static Date adjustStartTime(Date startTime) {
        //return startTime;// 202110281308 调试需要 立即启动
        if (startTime.getTime() < System.currentTimeMillis()) {// 情况：如果设定的时间早于今天，那么也要按照次日凌晨再启动处理。
            startTime = new Date();
        }
        LocalDateTime startTimeLdt = DateUtils.asLocalDateTime(startTime);
        // 调整到设定日期当天的凌晨
        LocalDateTime startTimeMidnight = LocalDateTime.of(startTimeLdt.getYear(), startTimeLdt.getMonth(), startTimeLdt.getDayOfMonth(), 0, 0, 0);
        // 调整到次日，加十五分钟。
        startTime = DateUtils.asDate(startTimeMidnight.plusDays(1).plusMinutes(15));
        return startTime;
    }

    /**
     * 错峰执行 减少上级网关拥塞
     *
     * @param startTime
     * @return
     */
    public static Date plusRandomTime(Date startTime) {
        //return startTime;// 202110281307 调试需要 立即启动
        int randomPlusMinutes = new Random().nextInt(15);// [0, 15)均匀分布的随机数
        startTime = DateUtils.asDate(DateUtils.asLocalDateTime(startTime).plusMinutes(randomPlusMinutes));
        return startTime;
    }
}
