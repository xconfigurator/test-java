package liuyang.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author :liuyang(wx)
 * @date :2022/4/6 13:41
 */
@Slf4j
public class ArraysAsListTest {

    // List的下标是从0开始还是从1开始
    @Test
    void test202212071835() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        log.info("list.get(0) = {}", list.get(0));
        log.info("list.get(1) = {}", list.get(1));

    }

    // 测试数组初始化
    @Test
    void test202211200940() {
        int[][] arr = {
                {7, 5, -21}
                ,{23, 21, 5}
                ,{-5, -4, -4}
                ,{-24, 10, -20}
                ,{16, 23, 30}
        };
        for (int i = 0; i < arr.length; ++i) {
            System.out.println("");
            for (int j = 0; j < arr[i].length; ++j) {
                System.out.print(arr[i][j]);
                System.out.print("\t");
            }
        }
    }

    @Test
    void test() {
        final List<String> strings = Arrays.asList("a", "b", "c", "d");
        log.info("strings = " + strings);
    }
}
