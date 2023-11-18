package liuyang.algorithms202311.swap;

import liuyang.algorithms202311.GenTestArray;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 选泡插
 * 快堆归希
 * 桶计基
 * https://www.bilibili.com/list/406692798?sid=774665&spm_id_from=333.999.0.0&desc=1&oid=47634224&bvid=BV1kb411x7ou
 * 视频4分钟左右的编程引导，很好！
 *
 * @author xconf
 * @since 2023/11/15
 */
@Slf4j
public class BubbleSortTest {

    @Test
    void test202311181818() {
        int[] array = GenTestArray.getRandom();
        log.debug("排序前 {}", array);
        bubbleSort(array);
        log.debug("排序后 {}", array);
        Assertions.assertTrue(ArrayUtils.isSorted(array));
    }

    //
    private static void bubbleSort(int[] array) {
        for (int j = array.length - 1; j >= 0; j--) {
            boolean hasSwaped = false; // 标记该次循环中是否发生了交换，若无，则说明整个序列有序。
            for (int i = 0; i < j; i++) { // 一趟冒泡
                // 每次循环找出一个最大元素，被交换到最右端。
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    hasSwaped = true;// 发生了交换
                }
            }
            if (!hasSwaped) {
                break;// 若全程无交换，则跳出循环。
            }
        }
    }
}
