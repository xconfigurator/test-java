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

    @Test
    void test202310201402() {
        List<Double> list = Arrays.asList(1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,11.0,12.0,13.0,14.0,15.0);
        //String tmp = "1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0 10 11 12 13 14 15";
        //System.out.println(tmp.replaceAll(" ", ","));
        log.info("sum = {}", list.stream().mapToDouble(d -> d).sum());
        log.info("avg = {}", list.stream().mapToDouble(d -> d).average());
    }

    @Test
    void test202310171811() {
        int a[] = {1, 2, 3};
        log.info("a = {}", a);
        for (int i : a) {
            System.out.println(i);
        }
    }

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
