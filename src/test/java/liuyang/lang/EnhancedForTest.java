package liuyang.lang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class EnhancedForTest {

    @Test
    void test01() {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        for (Integer i : integers) {
            System.out.println(i);
        }
    }

    // 注意！
    @Test
    void test02() {
        List<Integer> integers = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            for (Integer i : integers) {
                System.out.println("会进来么？");
                System.out.println(i);
            }
        });
    }
}
