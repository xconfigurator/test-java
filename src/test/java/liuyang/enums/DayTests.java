package liuyang.enums;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author liuyang
 * @date 2021/8/9
 */
public class DayTests {
    @Test
    void testDays() {
        Arrays.stream(Day.values()).forEach(System.out::println);
    }
}
