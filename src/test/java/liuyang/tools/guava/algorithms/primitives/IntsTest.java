package liuyang.tools.guava.algorithms.primitives;

import com.google.common.primitives.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua?p=5&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 22:22
 *
 * https://guava.dev/releases/snapshot-jre/api/docs/com/google/common/primitives/Ints.html
 *
 * @author xconf
 * @since 2023/11/9
 */
public class IntsTest {
    @Test
    void testInts() {
        Ints.asList(1, 2, 3);// Guava
        Arrays.asList(1, 2, 3);// JDK
    }

    @Test
    void testIntsReverse01() {
        int[] arr = IntStream.rangeClosed(1, 10).toArray();
        Ints.reverse(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    @Test
    void testInsReverse02() {
        int[] arr = IntStream.rangeClosed(1, 10).toArray();
        Ints.reverse(arr, 0, 5);// 逆置前5个元素 [fromIndex, toIndex)
        Arrays.stream(arr).forEach(System.out::println);
    }

    @Test
    void testLongs() {
        //Longs
    }

    @Test
    void testFloats() {
        //Floats
    }

    @Test
    void testDoubles() {
        //Doubles
    }

    @Test
    void testBooleans() {
        //Booleans

    }
}
