package liuyang.jcf;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * https://www.bilibili.com/video/BV1PY411e7J6/?p=162&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Collections.html
 *
 * 还可以操作Map
 *
 * 排序
 * reverse
 * shuffle
 * sort
 * sort(List, Comparator)
 * swap(List, int, int)
 *
 * 查找
 * max
 * max(Collection, Comparator)
 *
 * unmodifiableXxx 参见Guava中ImmutableList给的例子。
 *
 * @author xconf
 * @since 2023/11/9
 */
@Slf4j
public class CollectionsTest {

    @DisplayName("排序")
    @Test
    void test202311091920() {
        List<Integer> list = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        log.info("reverse\t{}", list);
        Collections.shuffle(list);
        log.info("shuffle\t{}", list);
        Collections.sort(list);
        log.info("sort\t\t{}", list);
        Collections.sort(list, (a, b) -> b - a);
        log.info("sort\t\t{}", list);
        Collections.swap(list, 0, 19);// java.lang.IndexOutOfBoundsException: Index 20 out of bounds for length 20
        log.info("swap\t\t{}", list);
    }

    @DisplayName("查找")
    @Test
    void test202311091921() {
        List<Integer> list = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
        log.info("max\t{}", Collections.max(list));
        log.info("binarySearch\t{}", Collections.binarySearch(list, 10));
        log.info("binarySearch\t{}", Collections.binarySearch(list, 55));
        log.info("frequency of 2 = \t{}", Collections.frequency(list, 2));
        List<Integer> list665 = IntStream.generate(() -> 2).limit(665).boxed().collect(Collectors.toList());// 665个2 先这样写吧，能用。
        list.addAll(list665);
        log.info("frequency of 2 = \t{}", Collections.frequency(list, 2));
        list.remove(5);// 注意5是索引位置， 实际是想删除6这个元素。
        System.out.println(list);
        Collections.replaceAll(list, 2, 6);
        log.info("frequency of 6 = \t{}", Collections.frequency(list, 6));
    }

    @DisplayName("复制 - 错误调用")
    @Test
    void test202311091933() {
        List<Integer> src = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        List<Integer> dest = new LinkedList<>();// 这样是不行的！
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Collections.copy(dest, src);// java.lang.IndexOutOfBoundsException: Source does not fit in dest
        });
        System.out.println(dest);
    }

    @DisplayName("复制 - 正确调用")
    @Test
    void test202311091936() {
        List<Integer> src = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        //List<Integer> dest = new LinkedList<>();
        // 需要保证dest.size() == 100
        List<Integer> dest = Arrays.asList(new Integer[100]);
        Collections.copy(dest, src);
        System.out.println(dest);
    }

    @DisplayName("unmodifiable - 使用")
    @Test
    void test2023110919443() {
        List<Integer> list = Collections.unmodifiableList(Arrays.asList(1, 2, 3));
        assertThrows(UnsupportedOperationException.class, () -> {
            list.add(4);
        });
        System.out.println(list);
    }

    @DisplayName("unmodifiable - 验证")
    @Test
    void test202311091944() {
        List<Integer> list = Arrays.asList(1, 2, 3);

        // jdk 看上去没问题
        List<Integer> listJdk = Collections.unmodifiableList(Arrays.asList(1, 2, 3));
        assertThrows(UnsupportedOperationException.class, () -> {
            listJdk.add(4);
        });

        // 之前的jdk版本是list.add()不会抛异常，集合改变
        // 实测JDK17 已经修复了这个问题。JDK17的行为已经与Guava一致了。
        assertThrows(UnsupportedOperationException.class, () -> {
            list.add(4);
        });

        // 集合改变了
        System.out.println(list);
        System.out.println(listJdk);
    }

    // https://www.bilibili.com/video/BV1PY411e7J6/?p=162&vd_source=8bd7b24b38e3e12c558d839b352b32f4 24:50
    @DisplayName("同步")
    @Test
    void test202311091945SynchronizedXxx() {
        // 将集合包装成线程同步集合。
        List<Integer> list = new LinkedList<>();
        List<Integer> listSync = Collections.synchronizedList(list);

        Set<Integer> set = new TreeSet<>();
        Set<Integer> setSync = Collections.synchronizedSet(set);

        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> mapSync = Collections.synchronizedMap(map);
    }

    // https://www.bilibili.com/video/BV1PY411e7J6/?p=162&vd_source=8bd7b24b38e3e12c558d839b352b32f4 29:16 有一道练习题
    @DisplayName("练习题")
    @Test
    void test202311092003() {
        // TODO 练习题 待有空了练一下。
    }
}
