package liuyang.test20210915;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author liuyang
 * @date 2021/9/15
 */
@Slf4j
public class ForStatementOrStreamTest {
    @Test
    void testFor() {
        //List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List<Integer> integers = Arrays.asList();
        //List<Integer> integers = null;// NullPointerException
        for (Integer i : integers) {
            System.out.println(i);
        }
    }

    @Test
    void testStream() {
        //List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List<Integer> integers = Arrays.asList();
        //List<Integer> integers = null;// NullPointerException
        integers.stream().forEach(i -> {
            System.out.println(i);
        });
    }
}
