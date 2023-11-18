package liuyang.algorithms202311;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 测试数据生成工具类
 *
 * @author xconf
 * @since 2023/11/18
 */
@Slf4j
public class GenTestArray {

    private static Random r;
    static {
        r = new Random();
    }

    /**
     * 产生10个100以内随机整数组成的数组
     * @return
     */
    public static int[] getRandom() {
        return getRandom(10);
    }

    /**
     * 产生指定书目100以内随机数组成的数组
     * @param length
     * @return
     */
    public static int[] getRandom(int length) {
        int BOUND = 100;
        return Stream.generate(() -> r.nextInt(BOUND))
                .limit(length)
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    /**
     * 1 ~ 10 乱序排列的测试数组
     * @return
     */
    public static int[] getShuffle() {
        return getShuffle(1, 10);
    }

    /**
     * 范围是 [startInclusive, endInclusive]的乱序排列数组
     * @param startInclusive
     * @param endInclusive
     * @return
     */
    public static int[] getShuffle(int startInclusive,
                                   int endInclusive) {
        int[] data = IntStream.rangeClosed(startInclusive, endInclusive)
                .boxed()
                .mapToInt(Integer::valueOf)
                .toArray();
        ArrayUtils.shuffle(data);
        return data;
    }
}
