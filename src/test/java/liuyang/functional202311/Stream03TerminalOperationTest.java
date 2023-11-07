package liuyang.functional202311;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * 终端操作 (terminal operation)
 * https://www.bilibili.com/video/BV1PY411e7J6/?p=197&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 48:34 开始
 * 不再详细跟做笔记了。先看康师傅视频跟着梳理一下Stream API的结构，
 * 后续：
 * 1. 再翻imooc的视频教程跟练。
 * 2. 再翻书：
 * 《Java 8函数式编程》
 * 《Java语言程序设计》 梁勇
 *
 * @author xconf
 * @since 2023/11/7
 */
@Slf4j
public class Stream03TerminalOperationTest {

    @DisplayName("1. 匹配与查找")
    @Test
    void test202311072147() {
        /**
         * 1. 匹配与查找
         * 48:34
         * allMatch(Predicate p)            检查是否匹配所有元素
         * anyMatch(Predicate p)            检查是否只找匹配一个元素
         * nonMatch(Predicate p)            检查是否没有匹配所有元素
         * findFirst()                      返回第一个元素
         * findAny()                        返回当前流中的任意元素
         * count()                          返回流中元素总数
         * max(Comparator c)                返回流中最大值
         * min(Comparator c)                返回流中最小值
         * forEach(Consumer c)              内部迭代（使用Collection接口需要用户去做迭代，称为外部迭代。相反，Stream API使用内部迭代——它帮你把迭代做了。）
         */
        // 注：对集合，JDK8 增加了一个forEach方法，可以直接用list.forEach(System.out::println)输出。
        // 小结：对List而言，可以使用的遍历方法
        // 1. 一般for + 索引。1. 一般for + Iterator。 2. 增强for循环。 4. 集合类本身提供的forEach。 5. 转换成stream之后再使用forEach。
    }

    @DisplayName("2. 规约")
    @Test
    void test202311072201() {
        /**
         * 2. 规约
         * 1:05:43
         * reduce(T identity, BinaryOperator b)         可以将流中元素反复合起来，得到一个值。返回T.
         * reduce(BinaryOperator b)                     可以将流中元素反复合起来，得到一个值。返回Optional<T>.
         */
        // 练习 计算11到100的和。
        System.out.println(IntStream.rangeClosed(1, 100).reduce(0, (a, b) -> a + b));// identity可以视为初始值。
        System.out.println(IntStream.rangeClosed(1, 100).parallel().reduce(0, Integer::sum));// liuyang:这样用并行流对不对？
        System.out.println(IntStream.rangeClosed(1, 100).reduce(Integer::sum).getAsInt());
    }

    @DisplayName("3. 收集")
    @Test
    void test202311072203() {
        /**
         * 3. 收集
         * 1:14:23
         * collect(Collector c)              将流转换为其他形式。接收一个Collector接口来实现，用于给Stream中元素做汇总的方法。
         */
        /**
         * 另外Collector接口中的方法实现决定了如何对流执行收集的操作（如收集到List、Set、Map）
         * 另外，Collectors类提供了很多静态方法，可以方便地创建常见收集器实例。
         * e.g. .collect(Collectors.toList())
         */
    }
}
