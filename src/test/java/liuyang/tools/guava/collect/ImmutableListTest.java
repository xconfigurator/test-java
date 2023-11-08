package liuyang.tools.guava.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua/?p=8&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * @author xconf
 * @since 2023/11/9
 */
public class ImmutableListTest {

    // 场景举例：分布式缓存，不希望其他人修改该值
    @Test
    void test01() {
        //ImmutableList
        //ImmutableSet
        //ImmutableMap
        ImmutableList<Integer> listG = ImmutableList.<Integer>builder().addAll(Arrays.asList(1, 2, 3)).build();
        assertThrows(UnsupportedOperationException.class, () -> {
            listG.add(4);
        });
    }

    // 下面对比一下Guava的容器和JDK提供的包装类
    @Test
    void test0201() {// 使用Guava的不可变容器，在原始容器中增加数据会抛出异常。
        List<Integer> list = Arrays.asList(1, 2, 3);

        ImmutableList<Integer> listG = ImmutableList.<Integer>builder().addAll(list).build();
        assertThrows(UnsupportedOperationException.class, () -> {
            listG.add(4);
        });

        // 在原始容器中增加数据仍然会抛出异常
        assertThrows(UnsupportedOperationException.class, () -> {
            list.add(4);
        });

        // 集合没有改变
        System.out.println(list);
        System.out.println(listG);
    }

    @Test
    void test0202() {// 使用JDK包装类生成的容器，在原始容器中添加数据不会抛出异常
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
}
