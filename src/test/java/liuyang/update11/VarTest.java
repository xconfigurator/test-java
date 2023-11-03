package liuyang.update11;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * JDK10+ 引入var。局部变量的类型推断
 * 不要乱用！！！
 * 测试用例列出了可用场景。
 * 主要是为了简化代码方便阅读，而不是其他目的。
 *
 * 参考视频：
 * https://www.bilibili.com/video/BV1PY411e7J6/?p=198&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 20:04
 * @author xconf
 * @since 2023/11/2
 */
@Slf4j
public class VarTest {
    @DisplayName("JDK10+ var 用于map遍历")
    @Test
    void test202311021851Map() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);
        for (var entry : map.entrySet()) {
            log.info("{} = {}", entry.getKey(), entry.getValue());
        }

        /**
         * 对标 C++ 17
         * vector<pair<int, int>> numbers = { {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5} };// 这个容器初始化列表也是C++ 11的特性。
         *
         * cout << "C++ 17" << endl;
         * for (auto [key, val] : numbers) {// C++ 17
         *     cout << key << ", " << val << endl;
         * }
         */
    }

    @DisplayName("JDK10+ var 用于set遍历")
    @Test
    void test202311032041Set() {
        var set = new LinkedHashSet<Integer>();
        set.addAll(Arrays.asList(1, 2, 3));
        for (var item : set) {
            System.out.println(item);
        }
    }

    @DisplayName("JDK10+ var 用于list遍历")
    @Test
    void test202311032044List() {
        var list = new ArrayList<String>();
        list.addAll(Arrays.asList("hello", "world"));
        for (var item : list) {
            System.out.println(item);
        }
    }

    @DisplayName("var 其他场景")
    @Test
    void test202311032050() {
        // 一般for循环
        // liuyang 个人觉得在这里就没必要这么写，int也敲三下，var也敲三下，写成var还得让编译器费事，不合算。
        for (var i = 1; i <= 5; ++i) {
            System.out.println(i);
        }

        // 返回值类型含复杂泛型结构
        // 见map循环的例子。

        // 不要乱用！！
    }
}
