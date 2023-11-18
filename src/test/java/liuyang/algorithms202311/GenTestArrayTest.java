package liuyang.algorithms202311;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;

/**
 * @author xconf
 * @since 2023/11/18
 */
@Slf4j
public class GenTestArrayTest {
    @RepeatedTest(2)
    void testGenTestArray() {
        int[] arrayRandom = GenTestArray.getRandom();
        log.info("getRandom() = {}", arrayRandom);
        int[] arrayShuffle = GenTestArray.getShuffle();
        log.info("getShuffle() = {}", arrayShuffle);
    }


}
