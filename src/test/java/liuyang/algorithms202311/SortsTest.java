package liuyang.algorithms202311;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * @author xconf
 * @since 2023/11/18
 */
@Slf4j
public class SortsTest {

    @RepeatedTest(4)
    void testSelectionSort202311181816() {
        int[] array = GenTestArray.getRandom();
        Sorts.selectionSort(array);
        log.debug("{}", array);
        assertTrue(ArrayUtils.isSorted(array));
    }

    @RepeatedTest(4)
    void testBubbleSort202311181843() {
        int[] array = GenTestArray.getRandom();
        Sorts.bubbleSort(array);
        //log.debug("{}", array);
        assertTrue(ArrayUtils.isSorted(array));
    }

    @RepeatedTest(4)
    void testInsertionSort202311190601() {
        int[] array = GenTestArray.getRandom();
        Sorts.insertionSort(array);
        assertTrue(ArrayUtils.isSorted(array));
    }
}
