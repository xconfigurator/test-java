package liuyang.essentials.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author xconf
 * @since 2023/11/9
 */
@Slf4j
public class MathTest {
    @Test
    void testAbs() {
        log.info("{}", Math.abs(-1));
    }

    @Test
    void testCeil() {// 向上取整
        log.info("{}", Math.ceil(3.3));
        log.info("{}", Math.ceil(-3.3));
        log.info("{}", Math.ceil(5.1));
    }

    @Test
    void testFloor() {
        log.info("{}", Math.floor(3.3));
        log.info("{}", Math.floor(-3.3));
        log.info("{}", Math.floor(5.1));
    }

    @Test
    void testRound() {
        // 人工计算，Math.floor(x + 0.5) 不管正负都这样算，就ok
        // 四舍五入想表达的是“离河两岸哪边近就靠到哪边”。如果在中间，就向大的方向靠。
        log.info("{}", Math.round(5.5));// 6
        log.info("{}", Math.round(5.4));// 5
        log.info("{}", Math.round(-3.3));// -3
        log.info("{}", Math.round(-3.8));// -4
        log.info("{}", Math.round(-12.3));// -12
        log.info("{}", Math.round(-12.6));// -13
        log.info("{}", Math.round(-12.5));// -12 中间的向大的方向靠
        log.info("{}", Math.round(-11.8));// -12
        log.info("{}", Math.round(11.8));// 12
    }

    @Test
    void testPow() {
        // 幂
        log.info("{}", Math.pow(2, 3));
    }

    @Test
    void testSqrt() {
        // 开方
        log.info("{}", Math.sqrt(3));// 孤独的根号三
        log.info("{}", Math.sqrt(2));
    }

    @Test
    void testRandom() {
        // [0, 1)的随机数
        for (int i = 0; i < 10; ++i) {
            System.out.println(Math.random());
        }
    }

    @Test
    void testPI() {
        log.info("PI: {}", Math.PI);
    }

    // max, min, sin, cos, tan, asin, acos, atan

}
