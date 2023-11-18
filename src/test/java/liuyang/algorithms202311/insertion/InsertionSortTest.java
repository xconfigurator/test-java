package liuyang.algorithms202311.insertion;

import liuyang.algorithms202311.GenTestArray;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://www.bilibili.com/list/406692798?sid=774665&spm_id_from=333.999.0.0&desc=1&oid=47634289&bvid=BV1kb411x7dw
 * 样本小且基本有序的情况下，插入排序的效率高。
 * 稳定。
 *
 * @author xconf
 * @since 2023/11/15
 */
@Slf4j
public class InsertionSortTest {

    @Test
    void test202311190527() {
        int[] array = GenTestArray.getRandom();
        log.debug("排序前 {}", array);
        insertionSort(array);
        log.debug("排序后 {}", array);
        Assertions.assertTrue(ArrayUtils.isSorted(array));
    }

    private static void insertionSort(int[] array) {
        for (int j = 1; j < array.length; j++) {// 没必要从第0个开始
            int tmp = array[j]; // 取出未排序序列中的第一个元素 “摸下一张牌”
            int i = j;
            // 从当前的最后一张牌的位置开始，不断地与前面的已排序列重元素作比较
            // array[i - 1] > tmp: 只要我手里这张牌tmp比现在有序序列中最后一张牌array[i - 1]小，就把当前已排序列最后一张牌向后移动一位。
            for (; i >= 1 && array[i - 1] > tmp; i--) {// 写成i >= 1 更容易看出插入排序和Shell排序的联系
                array[i] = array[i - 1];// 移出空位
            }
            array[i] = tmp;// 新牌落位
        }
    }
}
