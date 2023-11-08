package liuyang.tools.guava.collect;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Map;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua/?p=7&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * @author xconf
 * @since 2023/11/9
 */
@Slf4j
public class MultimapTest {
    @Test
    void testHashMultimap() {
        // 一个键存多个值
        Multimap<Integer, String> multimap = HashMultimap.<Integer, String>create();
        multimap.put(1, "foo");
        multimap.put(1, "bar");
        multimap.put(2, "liuyang");
        System.out.println(multimap);

        // 每个值都是一个集合
        Collection<String> strings = multimap.get(1);

        // 操作
        log.info("{}", multimap.containsEntry(2, "liuyang"));
        log.info("{}", multimap.containsEntry(1, "bar"));
        log.info("{}", multimap.containsEntry(1, "liuyang"));

        // 转成JDK JCF结构
        Map<Integer, Collection<String>> map = multimap.asMap();
        // 注1：从泛型里面就可已看出multimap的结构了。
        // 注2：好像Multiset并没有对应方法。不过Multiset底层是一个Map<E, count>结构来实现的。
    }

    @Test
    void testTreeMultimap() {
        // 一个键存多个值
        Multimap<Integer, String> multimap = TreeMultimap.<Integer, String>create();
        multimap.put(1, "foo");
        multimap.put(1, "bar");
        multimap.put(2, "liuyang");
        System.out.println(multimap);
    }
}
