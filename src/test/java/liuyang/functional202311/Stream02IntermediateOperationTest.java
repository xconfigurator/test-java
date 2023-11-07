package liuyang.functional202311;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * 中间操作(intermediate operations) 惰性
 * https://www.bilibili.com/video/BV1PY411e7J6/?p=197&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 15:13 开始
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
public class Stream02IntermediateOperationTest {

    @DisplayName("1. 筛选与切片")
    @Test
    void test202311070525() {
        /**
         * 15:13
         * 1. 筛选与切片
         * filter(Predicate p)      排除某些元素
         * distinct()               去重。根据流中对象的hashCode()和equals()
         * limit(long maxSzie)      截断。
         * skip(long n)             跳过。返回一个扔掉了前n个元素的流。若流中不足n个，则返回一个空流。与limit(n)互补。
         */
        // "切片"
        Stream<String> stream = Stream.of("a", "b", "c");
        stream.skip(1).limit(3).forEach(System.out::println);
    }

    @DisplayName("2. 映射")
    @Test
    void test202311072000() {
        /**
         * 30:15
         * 2. 映射
         * map(Function f)          将元素转换成其他形式或提取信息。该函数会被应用到每个元素上。
         */
        Stream<String> stream = Stream.of( "a", "b", "c");
        stream.map(String::toUpperCase).forEach(System.out::println);
        // 练习题:34:59
    }

    @DisplayName("3. 排序")
    @Test
    void test202311072001() {
        /**
         * 39:05
         * 3. 排序
         * sorted()                 自然排序（需要实现Comparable compareTo）
         * sorted(Comparator c)     定制排序
         * 注意：原来的数组或集合本身顺序并不发生变化！！！ Stream不会改变原对象。返回的是一个新对象。
         */
    }
}
