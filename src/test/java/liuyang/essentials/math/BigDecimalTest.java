package liuyang.essentials.math;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author xconf
 * @since 2023/11/9
 */
@Slf4j
public class BigDecimalTest {

    @Test
    void test() {
        BigDecimal bd1 = new BigDecimal("123456.351");
        BigDecimal bd2 = new BigDecimal("11");
        //log.info("{}", bd1.divide(bd2, BigDecimal.ROUND_HALF_UP));
        log.info("{}", bd1.divide(bd2, RoundingMode.HALF_UP));// 四舍五入
        log.info("{}", bd1.divide(bd2, 15, RoundingMode.HALF_UP));// 保留小数15位 四舍五入
    }
}
