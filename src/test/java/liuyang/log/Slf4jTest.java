package liuyang.log;

import liuyang.date.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author liuyang
 * @date 2021/9/16
 */
@Slf4j
public class Slf4jTest {
    @Test
    void testPlaceholder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = DateUtils.asDate(LocalDateTime.now());
        Date nowPlus7Days = DateUtils.asDate(LocalDateTime.now().plusDays(7));
        log.info("param1 = {}, param2 = {}", sdf.format(now), sdf.format(nowPlus7Days));
    }
}
