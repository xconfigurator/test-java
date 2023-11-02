package liuyang.functional202311;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * 最基本的Lambda表达时示例
 * https://www.bilibili.com/video/BV1PY411e7J6/?p=195&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * @author xconf
 * @since 2023/11/2
 */
@Slf4j
public class Lambda01Test {
    @DisplayName("简化Runnable编写")
    @Test
    void test01() {
        // ///////////////////////////////////////////////////
        // Lambda
        Runnable r2 = () -> {
            log.info("runnable2");
        };
        r2.run();// 方法调用，仅作示例。

        // ///////////////////////////////////////////////////
        // 传统写法
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable1");
            }
        };
        r1.run();// 方法调用，仅作示例。
    }

    @DisplayName("简化Comparator编写")
    @Test
    void test02() {
        // ///////////////////////////////////////////////////////
        // Lambda
        Comparator<Integer> comparator2 = (o1, o2) -> Integer.compare(01, 02);
        System.out.println(comparator2.compare(12, 21));
        // 另：还可以使用方法引用
        Comparator<Integer> comparator3 = Integer::compare;
        System.out.println(comparator3.compare(12, 21));

        // ///////////////////////////////////////////////////////
        // 传统写法
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(01, 02);
            }
        };
        System.out.println(comparator1.compare(12, 21));
    }
}
