package liuyang.algorithms202311.selection;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.bilibili.com/list/406692798?sid=774665&spm_id_from=333.999.0.0&desc=1&oid=46886067&bvid=BV1gb411J7WE
 *
 * 简单选择排序
 * 【介绍】
 * 时间复杂度高，且不稳定。
 * 作为介绍排序算法的引例，说明如下问题。
 * 1. 如何计算时间复杂度、空间复杂度。
 * 2. 如何对写好的算法进行验证。（随机数产生器，对数器）
 * 3. 编写算法程序的基本准则。
 *      由简单到复杂
 *          验证一步走一步
 *          多打印中间结果
 *      先局部后整体
 *          没思路时先细分
 *      先粗糙后惊喜
 *          变量更名
 *          语句合并
 *          边界处理
 *
 * 【思考题】
 * 1. 写一个程序证明选择排序不稳定。
 *
 * @author xconf
 * @since 2023/11/15
 */
@Slf4j
public class SelectionSortTest {
    @Test
    void test202311150540() {
        int[] arr = {1, 2, 3, 4};

        // 待测数据
        Random r = new Random();
        // 测试集1
        int[] array = Stream.generate(() -> r.nextInt(100))
                .limit(10)
                .mapToInt(Integer::valueOf)
                .toArray();
        // 测试集2
        array = IntStream.rangeClosed(1, 100).boxed().mapToInt(Integer::valueOf).toArray();
        ArrayUtils.shuffle(array);

        log.info("排序前：{}", array);
        log.info("是否有序：{}", ArrayUtils.isSorted(array));

        // 选择排序
        selectionSort(array);

        log.info("排序后：{}", array);
        log.info("是否有序：{}", ArrayUtils.isSorted(array));
    }


    @DisplayName("估测算法准确性示例")
    @RepeatedTest(10)
    void test202311151054() {
        // 1. 获取随机数组
        Random r = new Random();
        int[] array = Stream.generate(() -> r.nextInt(100))
                .limit(100)
                .mapToInt(Integer::valueOf)
                .toArray();
        //log.info("{}", Arrays.toString(array));
        // 2. 排序
        selectionSort(array);
        // 3. 判断
        Assertions.assertTrue(ArrayUtils.isSorted(array));
    }

    // 选择排序
    private static void selectionSort(int[] array) {
        /*
        for (int ele : array) {
            System.out.printf("%d\t", ele);
        }
        System.out.println("");
        */

        // 写一趟
        /*
        int minPos = 0;
        for (int j = 0; j < array.length; ++j) {
            if (array[j] < array[minPos]) {
                minPos = j;
            }
        }
        System.out.printf("minPos = %d\n", minPos);
        // 交换
        int tmp = array[0];
        array[0] = array[minPos];
        array[minPos] = tmp;

        for (int i = 0; i < array.length; ++i) {
            System.out.printf("%d\t", array[i]);
        }
        System.out.println("");*/

        // 配合循环写多趟
        //for (int i = 0; i < array.length; ++i) {
        for (int i = 0; i < array.length - 1; ++i) {// 优化一下
            // 找最小的
            int minPos = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }
            // System.out.printf("minPos = %d\n", minPos);

            // 交换
            int tmp = array[i];
            array[i] = array[minPos];
            array[minPos] = tmp;
        }
    }
}
