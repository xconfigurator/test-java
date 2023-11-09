package liuyang.essentials.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author xconf
 * @since 2023/11/9
 */
@Slf4j
public class RandomTest {
    @Test
    void test() {
        // 类比：Math.random() [0, 1)
        Random r = new Random();
        // 具体规格看代码注释
        r.nextGaussian();
        //
        r.nextInt();// 均匀分布
        r.nextInt(100);// [0, n) 均匀分布
        r.nextLong();
        r.nextFloat();
        r.nextDouble();
        //
        byte[] bytes = new byte[16];
        r.nextBytes(bytes);
    }
}
