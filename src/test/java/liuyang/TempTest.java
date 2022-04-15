package liuyang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author :liuyang(wx)
 * @date :2022/4/6 13:41
 */
@Slf4j
public class TempTest {

    @Test
    void test() {
        final List<String> strings = Arrays.asList("a", "b", "c", "d");
        log.info("strings = " + strings);
    }
}
