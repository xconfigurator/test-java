package liuyang.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author xconf
 * @since 2023/10/1
 */
@Slf4j
public class BitOperationTest {


    @Test
    void test202310141820() {
        log.info("二进制: \t\t{}", Integer.toBinaryString(17));
        log.info("二进制: \t\t{}", Integer.toBinaryString(10001));
    }

    @Test
    void test202310011002() {
        log.info("二进制：\t\t{}", Integer.toBinaryString(8));
        log.info("十六进制：\t{}", Integer.toHexString(8));
        log.info("八进制：\t\t{}", Integer.toOctalString(8));

        //
        log.info("{}", Integer.valueOf("0000000000000111", 2));
        log.info("{}", Integer.valueOf("01001001", 2));
    }

}
