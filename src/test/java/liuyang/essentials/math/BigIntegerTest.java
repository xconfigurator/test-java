package liuyang.essentials.math;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * 不可变的任意精度的整数
 *
 * @author xconf
 * @since 2023/11/9
 */
@Slf4j
public class BigIntegerTest {
    @Test
    void test() {
        BigInteger b1 = new BigInteger("123444321423432910482193821957589021483012");
        BigInteger b2 = new BigInteger("789078907890789078324637210673921075892151");

        log.info("加 {}", b1.add(b2));
        log.info("减 {}", b1.subtract(b2));
        log.info("乘 {}", b1.multiply(b2) );
        log.info("除 {}", b2.subtract(b1));
        log.info("余 {}", b2.remainder(b1) );
    }
}
