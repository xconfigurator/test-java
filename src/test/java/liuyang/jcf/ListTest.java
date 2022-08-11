package liuyang.jcf;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @since 20220809
 */
@Slf4j
class ListTest {
    private static final Random random = new Random();

    @Test
    void testList() {
        List<Integer> integers = Arrays.asList(1, 2, 3);

        log.info("integers.get(0) = {}", integers.get(0));
        log.info("integers.get(1) = {}", integers.get(1));
        log.info("integers.get(2) = {}", integers.get(2));
        //log.info("integers.get(3) = {}", integers.get(3));// 下标越界

        // 从List中随机取出一个记录
        for (int i = 0; i < 100; ++i) {
            log.info("random in list = {}", integers.get(getRandomIndex(integers.size())));
        }
    }
    private int getRandomIndex(int listSize) {
        return random.nextInt(listSize); // 0 ~ listSize - 1 正好覆盖List全集合
    }

    @Test
    void testRandom() {
        final int UPPER_BOUND = 10;

        List<Integer> data = new LinkedList<>();
        for (int i = 0; i < 10000000; ++i) {
            // [0, 10) 0 ~ 9
            //data.add(random.nextInt(UPPER_BOUND));
            // (0, 10] 1 ~ 10
            //data.add((int) random.nextInt(UPPER_BOUND) + 1);
            // [0, 10] 0 ~ 10
            data.add((int) random.nextInt(UPPER_BOUND + 1));
        }

        log.info("max = {}", Collections.max(data));
        log.info("min = {}", Collections.min(data));
    }
}
