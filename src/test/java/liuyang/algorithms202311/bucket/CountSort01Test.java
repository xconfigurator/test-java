package liuyang.algorithms202311.bucket;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 计数排序
 * https://www.bilibili.com/list/406692798?sid=774665&spm_id_from=333.999.0.0&desc=1&oid=49587719&bvid=BV1Wb41157ed
 *
 * 空间复杂度
 * O(N + R)
 *
 * 问题：
 * 视频16:13开始会描述计数排序的问题。
 * 第二个视频
 *
 * @author xconf
 * @since 2023/11/16
 */
@Slf4j
public class CountSort01Test {

    @Test
    void test202311160339() {
        // 1. 产生测试数据
        Random r = new Random();
        int[] array = Stream.generate(() -> r.nextInt(10))
                .limit(100)
                .mapToInt(Integer::valueOf)
                .toArray();
        log.info("排序前：{}", Arrays.toString(array));
        log.info("是否有序：{}", ArrayUtils.isSorted(array));

        // 2. 排序
        int[] result = countSort(array);

        // 3. 结果
        log.info("排序后：{}", Arrays.toString(result));
        log.info("是否有序：{}", ArrayUtils.isSorted(result));
    }

    @DisplayName("估测算法准确性示例")
    @RepeatedTest(10)
    void test202311160736() {
        // 1. 获取测试数据
        Random r = new Random();
        int[] array = Stream.generate(() -> r.nextInt(10))
                .limit(100)
                .mapToInt(Integer::valueOf)
                .toArray();
        // 2. 排序
        int[] result = countSort(array);

        // 3. 判断
        Assertions.assertTrue(ArrayUtils.isSorted(result));
    }


    public static int[] countSort(int[] array) {
        int[] result = new int[array.length];
        int[] count = new int[10]; // 这个计数区间是根据实际需求可以预先决定的。

        // 计数
        for (int i = 0; i < array.length; ++i) {
            count[array[i]]++;
        }

        log.debug("计数结果: {}", Arrays.toString(count));

        // 输出结果
        for (int i = 0, j = 0; i < count.length; ++i) {
            while (count[i]-- > 0) {
                result[j++] = i;
            }
        }

        return result;
    }
}
