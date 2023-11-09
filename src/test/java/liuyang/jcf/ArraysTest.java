package liuyang.jcf;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


/**
 * https://www.bilibili.com/video/BV1PY411e7J6/?p=71&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 视频前18分钟介绍了如何使用。不用在看了，看测试用例即可。
 *
 * https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Arrays.html
 *
 * 拼接
 *
 * 排序
 * sort
 *
 * 二分查找
 * binarySearch
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

    @DisplayName("判等 equals")
    @Test
    void test202311100058() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        int[] c = {4, 5, 6};
        int[] d = {1, 3, 2};
        assertTrue(() -> Arrays.equals(a, b));
        assertFalse(() -> Arrays.equals(a, c));
        assertFalse(() -> Arrays.equals(a, d));// 数组是有序的
    }

    @DisplayName("显示数组内容 toString")
    @Test
    void test202311100110() {
        int[] array = IntStream.rangeClosed(1, 100).toArray();
        System.out.println(array);
        System.out.println(Arrays.toString(array));
    }

    @DisplayName("填充数组 fill")
    @Test
    void test202311100112() {
        int[] a = new int[100];
        System.out.println(Arrays.toString(a));
        Arrays.fill(a, 6);
        System.out.println(Arrays.toString(a));
    }

    @DisplayName("附：获得特定List的操作")
    @Test
    void test202311100116() {
        // 例1. 需要得到一个拥有100个元素且初值均为0的列表
        Integer[] a1 = new Integer[100];            // 第一步
        Arrays.fill(a1, 0);                     // 第二步
        List<Integer> list1 = Arrays.asList(a1);    // 第三步
        System.out.println(list1);

        // 例2. 需要得到一个拥有100个元素且初值均为6的列表
        Integer[] a2 = new Integer[100];            // 第一步
        Arrays.fill(a2, 6);                     // 第二步
        List<Integer> list2 = Arrays.asList(a2);    // 第三步
        System.out.println(list2);

        // 2. 错误演示
        List<int[]> errlist1 = Arrays.asList(new int[100]);// 错误演示。 其实注意到IntelliJ自动生成的泛型就可以发现不对劲了！
        System.out.println(errlist1);//[[I@3b07a0d6]
        List<Integer> errlist2 = Arrays.asList(new Integer[100]);
        System.out.println(errlist2);// [null, null, null, null, null, null, null,
    }

    @DisplayName("排序和查找")
    @Test
    void test202311100137() {
        // 1. 准备数据
        int[] a = IntStream.rangeClosed(1, 100).toArray();
        System.out.println(Arrays.toString(a));
        // 搞乱 Arrays里没有shuffle。 那就改用填写随机数吧
        fillRandomData(a);
        System.out.println(Arrays.toString(a));

        // 2. 排序
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        // 3. 查找
        System.out.println(Arrays.binarySearch(a, 55));
        System.out.println(Arrays.binarySearch(a, 54));
        System.out.println(Arrays.binarySearch(a, 60));
        System.out.println(Arrays.binarySearch(a, 73));
        System.out.println(Arrays.binarySearch(a, 84));
    }

    private void fillRandomData(int[] arr) {
        Random r = new Random();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = r.nextInt(100);
        }
    }
}
