package liuyang.algorithms202311.selection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Stream;

/**
 * 简单选择排序
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
        int[] array = Stream.generate(() -> r.nextInt(100))
                .limit(10)
                .mapToInt(Integer::valueOf)
                .toArray();
        log.info("排序前：{}", array);

        // 选择排序
        selectionSort(array);

        log.info("排序后：{}", array);
    }

    // 选择排序
    private void selectionSort(int[] array) {

    }
}
