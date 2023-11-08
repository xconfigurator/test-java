package liuyang.tools.guava.algorithms.collect;

import com.google.common.collect.Lists;

import com.google.common.collect.Sets;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua?p=5&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 16:26
 *
 * @author xconf
 * @since 2023/11/9
 */
public class ListsTest {
    @Test
    void testLists() {
        // 创建ArrayList
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3);
    }

    @Test
    void testListsPartition() {
        // 一个接口，每次最多只能接收20个id
        List<Integer> collect = IntStream.rangeClosed(1, 1001).boxed().collect(Collectors.toList());
        // 神奇的partition
        List<List<Integer>> partition = Lists.partition(collect, 20);
        partition.forEach(System.out::println);// 哇呜哦!
    }

    @Test
    void testSets() {
        //Sets
    }

}
