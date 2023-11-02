package liuyang.functional202311;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * Lambda表达式各格式距离
 *
 * 【Lambda表达式】
 * Lambda表达式适用接口中只有一个抽象方法的情况。
 * https://www.bilibili.com/video/BV1PY411e7J6/?p=195&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * 【函数式接口】
 * 1. 函数式接口：接口中只声明有一个抽象方法，则称之为函数式接口。只有函数式接口才能使用Lambda表达式。
 * 2. JDK8中提供的函数式接口存放在：java.util.function
 * 3. 4个基本的函数式接口：
 *      Consumer<T> void accept(T t)
 *          https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/function/Consumer.html
 *      Supplier<T> T get()
 *          https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/function/Supplier.html
 *      Function<T, R> R apply(T t)
 *          https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/function/Function.html
 *      Predicate<T> boolean test(T t) 确定类型为T的对象是否满足某约束，并返回boolean值。
 *          https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/function/Predicate.html
 *
 * 【说明】
 *  Lambda表达式就是给函数式接口来提供实现对象的。
 *
 * @author xconf
 * @since 2023/11/2
 */
@Slf4j
public class Lambda02Test {

    // 常用
    @DisplayName("格式一： 无参无返回值")
    @Test
    void test01() throws ExecutionException, InterruptedException, TimeoutException {
        Runnable r = () -> {
            log.info("格式一： 无参无返回值");
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> submit = executorService.submit(r);
        submit.get(10, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    @DisplayName("格式二：需要一个参数，没有返回值")
    @Test
    void test02() {
        Consumer<String> consumer = (String s) -> {
            log.info(s);
        };
        consumer.accept("格式二：需要一个参数，没有返回值");
    }

    @DisplayName("格式三：省略参数类型")
    @Test
    void test03() {
        Consumer<String> consumer = (s) -> log.info(s);
        consumer.accept("语法格式三：省略参数类型");
    }

    // 常用
    @DisplayName("格式四：如果只有一个参数，则参数列表的小括号可以省略。")
    @Test
    void test04() {
        Consumer<String> consumer = s -> log.info(s);
        consumer.accept("语法格式三：如果只有一个参数，则参数列表的小括号可以省略。");
    }

    // 常用
    @DisplayName("格式五：两个以上参数，多条执行语句，有返回值。")
    @Test
    void test05() {
        Comparator<Integer> comparator = (x, y) -> {
            if (x > y) {
                return 1;
            } else if (x < y) {
                return -1;
            } else {
                return 0;
            }
        };
        log.info("{}", comparator.compare(12, 21));
    }

    // 常用
    @DisplayName("格式六：只有一条语句，return与大括号都可以正略")
    void test06() {
        Comparator<Integer> comparator = (x, y) -> x > y? 1 : x < y? -1 : 0;
        log.info("{}", comparator.compare(12, 21));
    }
}
