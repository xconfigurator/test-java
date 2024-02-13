package liuyang.tools.apache.commons.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua/?p=2&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 31:30
 * https://commons.apache.org/proper/commons-lang/javadocs/api-release/index.html
 * @author xconf
 * @since 2023/11/8
 */
@Slf4j
public class ArrayUtilsTest {
    @DisplayName("数组判空")
    @Test
    void test202311082210() {
        int[] arr = null;
        assertTrue(ArrayUtils.isEmpty(arr));
        assertTrue(ArrayUtils.isEmpty(new int[]{}));
        assertFalse(ArrayUtils.isEmpty(new int[]{1}));
    }

    @DisplayName("添加元素")
    @Test
    void test202311082217() {
        // System.arraycopy();

        int[] a = {1};
        a = ArrayUtils.add(a, 2);
        a = ArrayUtils.add(a, 3);
        a = ArrayUtils.add(a, 4);
        a = ArrayUtils.add(a, 5);
        Arrays.stream(a).forEach(System.out::println);

        log.info("探究：可以看出实际上是创建了新的数组");
        int[] arr = {1};
        // System.arraycopy
        ArrayUtils.add(arr, 2);
        ArrayUtils.add(arr, 3);
        ArrayUtils.add(arr, 4);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
