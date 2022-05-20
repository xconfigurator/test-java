package liuyang.functional202203;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class SortedTests {

    @Test
    void test() {

        List<Integer> arr = Arrays.asList(1, 2, 3, 4);
        List<Integer> integers = new ArrayList<>();
        integers.addAll(arr);

        /*
        int size = mpTopReportToDeleteReqeust.getTopList().size();
                for (int i = size - 1; i >= 0; --i) {
                    mpTopReportToDeleteReqeust.getTopList().remove(i);
                   }
        */
        int size = integers.size();
        for (int i = size - 1; i >= 0; --i) {
            integers.remove(i);
        }
        log.info("integers = {}", JSON.toJSON(integers));

        List<Integer> arr2 = Arrays.asList(5, 6, 7);
        List<Integer> mpTopToDeleteListIntersection  = new ArrayList<>();
        mpTopToDeleteListIntersection.addAll(arr2);

        integers.addAll(mpTopToDeleteListIntersection);
        log.info("integers = {}", JSON.toJSON(integers));
    }


    @Test
    void test2() {

        List<Integer> arr = Arrays.asList(1, 2, 3, 4);
        List<Integer> integers = new ArrayList<>();
        integers.addAll(arr);

        /*
        int size = mpTopReportToDeleteReqeust.getTopList().size();
                for (int i = size - 1; i >= 0; --i) {
                    mpTopReportToDeleteReqeust.getTopList().remove(i);
                   }
        */
        /*int size = integers.size();
        for (int i = size - 1; i >= 0; --i) {
            integers.remove(i);
        }*/
        integers.removeAll(integers);
        log.info("integers = {}", JSON.toJSON(integers));

        List<Integer> arr2 = Arrays.asList(5, 6, 7);
        List<Integer> mpTopToDeleteListIntersection  = new ArrayList<>();
        mpTopToDeleteListIntersection.addAll(arr2);

        integers.addAll(mpTopToDeleteListIntersection);
        log.info("integers = {}", JSON.toJSON(integers));
    }
}
