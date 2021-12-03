package liuyang.date.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateUtilsTest {

    @Test
    void testAdjust() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("调整后的时间 (次日凌晨)= {}", sdf.format(DateUtils.adjustStartTime(date)));
        log.info("调整后的时间 (次日凌晨) + 随机时间(15分钟内均匀分布) = {}", sdf.format(DateUtils.plusRandomTime(DateUtils.adjustStartTime(date))));
    }

}
