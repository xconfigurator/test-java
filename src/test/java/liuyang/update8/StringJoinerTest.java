package liuyang.update8;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;
import java.util.UUID;

/**
 * @author liuyang
 * @since 2021/5/31
 */
@Slf4j
public class StringJoinerTest {

    @Test
    void test() {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        sj.add("hello");
        sj.add("world");
        log.info(sj.toString());
    }

    @Test
    void test2() {
        StringJoiner sj = new StringJoiner(" | ")
                .add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .add(UUID.randomUUID().toString());
        log.info(sj.toString());
    }
}
