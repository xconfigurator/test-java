package liuyang.jcf;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
 * https://www.bilibili.com/video/BV1PY411e7J6/?p=71&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Arrays.html
 *
 * @author liuyang
 * @date 2021/9/16
 */
@Slf4j
public class ArraysTest {
    @Test
    void test() {
        assertEquals(false, Arrays.asList(1, 2, 3).contains(null));
        assertEquals(true, Arrays.asList(1, 2, 3).contains(1));
        assertEquals(false, Arrays.asList(1, 2, 3).contains("1"));// 类型不一致
        assertEquals(false, Arrays.asList(1, 2, 3).contains("4"));// 类型不一致
    }


}
