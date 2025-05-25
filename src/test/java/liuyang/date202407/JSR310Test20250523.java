package liuyang.date202407;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.Date;

/**
 * 补充：2025/5/23
 * 文心一言：Java 计算两个时间点之间相差的分钟数
 * 提问背景：2505222205 1批次 灌封结束到灭菌开始时间 MES记录计算为负值
 * 王毅，装车第一柜结束时间：2025/5/23 6:59:12
 * 李凯旋，灭菌第一柜开始时间：2025/5/23 6:59:02
 *
 * @author xconf
 * @since 2025/5/25
 */
@Slf4j
public class JSR310Test20250523 {

    /**
     * LocaalDateTime
     * Duration
     */
    @Test
    void test202505240838() {
        LocalDateTime tSterilization = LocalDateTime.of(2025, 5, 23,6, 59, 2);
        LocalDateTime tZhuangChe = LocalDateTime.of(2025, 5, 23, 6, 59, 12);

        //long minutesDiff = Duration.between(tZhuangChe, tSterilization).toMinutes();
        //int minutesPart = Duration.between(tZhuangChe, tSterilization).toMinutesPart();
        long seconds = Duration.between(tZhuangChe, tSterilization).toSeconds();// 使用这个计算口径
        //int secondsPart = Duration.between(tZhuangChe, tSterilization).toSecondsPart();

        //log.info("{} mins {} minsPart {} seconds {} secondsPart", minutesDiff, minutesPart, seconds, secondsPart);
        log.info("灌装结束至灭菌开始共：{} min", String.format("%.1f",seconds / 60.0));// 使用这个计算口径
    }

    /**
     * Instant
     * Duration
     */
    @Test
    void test202505241001() {
        Instant iSterilization = Instant.parse("2025-05-23T06:59:02Z");
        Instant tZhuangChe = Instant.parse("2025-05-23T06:59:12Z");

        long seconds = Duration.between(tZhuangChe, iSterilization).toSeconds();

        log.info("灌装结束至灭菌开始共：{} min", String.format("%.1f",seconds / 60.0));// 使用这个计算口径
    }

    /**
     * ZonedDateTime
     * Duration
     */
    @Test
    void test202505241009() {
        LocalDateTime tSterilization = LocalDateTime.of(2025, 5, 23,6, 59, 2);
        LocalDateTime tZhuangChe = LocalDateTime.of(2025, 5, 23, 6, 59, 12);

        ZonedDateTime ztSterilization = ZonedDateTime.of(tSterilization, ZoneId.of("Asia/Shanghai"));
        ZonedDateTime ztZhuangChe = ZonedDateTime.of(tZhuangChe, ZoneId.of("Asia/Shanghai"));

        long seconds = Duration.between(ztZhuangChe, ztSterilization).toSeconds();

        log.info("灌装结束至灭菌开始共：{} min", String.format("%.1f",seconds / 60.0));// 使用这个计算口径
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    void testOldAPI() {
        Date endDate = new Date(2025 - 1900, 5 - 1, 23, 6, 59, 2);   // 2023年1月1日12:45
        Date startDate = new Date(2025 - 1900, 5 - 1, 23, 6, 59, 12); // 2023年1月1日10:30

        long diffInMillis = endDate.getTime() - startDate.getTime();
        long minutesDiff = diffInMillis / (60 * 1000);

        System.out.println("相差分钟数: " + minutesDiff); // 输出: 相差分钟数: 135
        log.info("灌装结束至灭菌开始共：{} min", String.format("%.1f", diffInMillis / (60 * 1000.0)));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    void 计算当前时间与指定时间的分钟差() {
        LocalDateTime tExamination =  LocalDateTime.of(2027, 12, 24, 0, 0,0);
        LocalDateTime tNow = LocalDateTime.now();

        long days = Duration.between(tNow, tExamination).toDays();

        log.info("距入学考试还有 {} 天", days);
    }
}
