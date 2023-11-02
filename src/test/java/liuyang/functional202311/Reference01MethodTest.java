package liuyang.functional202311;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 * https://www.bilibili.com/video/BV1PY411e7J6/?p=196&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * 方法引用可以看做是基于Lambda表达式的进一步刻画。
 * 场景：
 * 当需要提供一个函数式接口的实例时，使用Lambda表达式。
 * 当满足一定条件时可以使用方法引用或者构造器引用去替换Lambda表达式。
 * 也就是说，如果可以使用方法引用，则一定也可以使用Lambda表达式或者匿名内部类的方法来实现相同的效果。
 *
 * 方法引用的本质：
 * 使用方法引用作为函数式接口的实例。
 *
 * 形式：
 * 1. 类::静态方法
 * 2. 对象::实例方法
 * 3. 类::实例方法 （总结在视频40:19左右。）
 *      函数式接口中的抽象方法a与其内部实现时调用的对象的某个方法b返回值类型相同。
 *      且抽象方法a中有n个参数，方法b中有n-1个参数
 *      抽象方法a的第1个参数作为方法b的调用者
 *      抽象方法a的后n-1个参数作为方法b的n-1个参数且类型相同（或一致（满足拆箱\装箱， 多态））
 *
 * @author xconf
 * @since 2023/11/2
 */
@Slf4j
public class Reference01MethodTest {
    /**
     * 举例：
     * Comparator中的int compare(T o1, T o2)
     * Integer中的int compare(T o1, T o2)
     */
    @DisplayName("类::静态方法")
    @Test
    void test0101() {
        //Comparator<Integer> comparator = Integer::compareTo;// 竟然可以?! 这是为何？！！！！ liuyang 202311022152 解释：见test0301
        Comparator<Integer> comparator = Integer::compare;// public static int compare(int x, int y)
        log.info("{}", comparator.compare(1, 2));
        log.info("{}", comparator.compare(2, 1));
    }

    /**
     * 举例:
     * Function中的R apply(T t)
     * Math中的Long round(Double d)
     */
    @DisplayName("类::静态方法")
    @Test
    void test0102() {
        Function<Double, Long> function = Math::round;// public static long round(double a) {
        log.info("{}", function.apply(1.23456));
    }

    /**
     * 举例：
     * Consumer中的void accept(T t)
     * PrintStream中的void println(T t)
     */
    @DisplayName("对象::实例方法")
    @Test
    void test0201() {
        Consumer<String> consumer1 = System.out::println;// 这个println并不是一个静态方法。
        consumer1.accept("对象::实例方法");

        // 解释一下更清晰
        PrintStream ps = System.out;
        Consumer<String> consumer2 = ps::println;// 这样可以看清楚是 “对象::实例方法"的形式。
        consumer2.accept("对象::实例方法");
    }

    /**
     * 举例：
     * Supplier中的T get()
     * Employee中的String getName()
     */
    @DisplayName("对象::实例方法")
    @Test
    void test0202() {
        @Data
        @AllArgsConstructor
        class Employee {
            Integer id;
            String name;
            Integer age;
        }
        Employee employee = new Employee(1001, "刘洋", 40);

        Supplier<String> supplier = employee::getName;// liuyang:感觉像起了个通用的别名。
        log.info("{}", supplier.get());
    }

    /**
     * 举例：
     * Comparator中的int compare(T t1, T t2)
     * String中的int compareTo(t2) （非static）
     */
    @DisplayName("类::实例方法")
    @Test
    void test0301() {
        Comparator<String> comparator1 = String::compareTo;// public int compareTo(String anotherString) {
        log.info("{}", comparator1.compare("123", "456"));
        log.info("{}", comparator1.compare("def", "abc"));

        // 不好理解？看一下等价的Lambda表达式形式
        Comparator<String> comparator2 = (t1, t2) -> t1.compareTo(t2);// public int compareTo(String anotherString) {
        log.info("{}", comparator2.compare("123", "456"));
        log.info("{}", comparator2.compare("def", "abc"));
    }

    /**
     * 举例：
     * BiPredicate中的boolean test(T t1, T t2)
     * String中的boolean equals(Object anObject)
     */
    @DisplayName("类::实例方法")
    @Test
    void test0302() {
        BiPredicate<String, String> biPredicate = String::equals;// public boolean equals(Object anObject) {
        log.info("{}", biPredicate.test("123", "123"));
        log.info("{}", biPredicate.test("789", "456"));
    }

    /**
     * 举例：
     * Function中的R apply(T t)
     * Employee中的String getName()
     */
    @DisplayName("类::实例方法")
    @Test
    void test0303() {
        @Data
        @AllArgsConstructor
        class Employee {
            Integer id;
            String name;
            Integer age;
        }
        Employee employee = new Employee(1001, "刘洋", 40);

        Function<Employee, String> function = Employee::getName;
        log.info("{}", function.apply(employee));
    }
}
