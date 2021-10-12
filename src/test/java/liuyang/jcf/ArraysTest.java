package liuyang.jcf;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * @author liuyang
 * @date 2021/9/16
 */
@Slf4j
public class ArraysTest {
    @Test
    void test() {
        Assertions.assertEquals(false, Arrays.asList(1, 2, 3).contains(null));
        Assertions.assertEquals(true, Arrays.asList(1, 2, 3).contains(1));
        Assertions.assertEquals(false, Arrays.asList(1, 2, 3).contains("1"));// 类型不一致
        Assertions.assertEquals(false, Arrays.asList(1, 2, 3).contains("4"));// 类型不一致
    }
}
