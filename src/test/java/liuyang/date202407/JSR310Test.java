package liuyang.date202407;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author xconf
 * @since 2024/7/23
 */
@Slf4j
public class JSR310Test {
    @Test
    void test() {
        String dateTimeString = "2024-07-01T08:27:09.890+08:00;Asia/Shanghai";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSV;V");

        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTimeString, formatter);
        System.out.println("Parsed ZonedDateTime: " + zonedDateTime);
    }


}
