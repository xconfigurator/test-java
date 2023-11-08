package liuyang.tools.guava.collect;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua?p=6&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * @author xconf
 * @since 2023/11/9
 */
@Slf4j
public class MultisetTest {
    @Test
    void testHashMultiset() {
        Multiset<Integer> multiset = HashMultiset.<Integer>create();
        multiset.addAll(Arrays.asList(1, 2, 3, 1, 2, 3, 4, 5));
        multiset.stream().forEach(System.out::println);// 排序了
        System.out.println(multiset);// 看一下HashMultiset自己的同String
        log.info("entrySet() = {}", multiset.entrySet());
        log.info("elementSet() = {}", multiset.elementSet());

        // 使用Multiset.Entry
        for (var m : multiset.entrySet()) {
            log.info("元素 = {}， 个数 = {} ", m.getElement(), m.getCount());
        }
    }

    @Test
    void testTreeMultiset() {
        TreeMultiset<Integer> multiset = TreeMultiset.<Integer>create();
        multiset.addAll(Arrays.asList(1, 2, 3, 1, 2, 3, 4, 5));
        multiset.stream().forEach(System.out::println);// 排序了
        System.out.println(multiset);// 看一下TreeMultiset自己的同String
        log.info("entrySet() = {}", multiset.entrySet());
        log.info("elementSet() = {}", multiset.elementSet());

        // 使用Multiset.Entry
        for (var m : multiset.entrySet()) {
            log.info("元素 = {}， 个数 = {} ", m.getElement(), m.getCount());
        }
    }
}
