package liuyang.essentials.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author xconf
 * @since 2023/10/19
 */
@Slf4j
public class LongTest {
    @Test
    void test202310190739() {
        // 因为没查到怎么在字符串前补0输出，所以就先折腾回数字，再格式化输出
        System.out.printf("%020d", Long.parseLong(Long.toBinaryString(Long.parseUnsignedLong("ff", 16))));
    }
}
