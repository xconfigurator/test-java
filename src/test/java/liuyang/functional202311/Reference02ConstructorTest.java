package liuyang.functional202311;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用 41:44开始
 * 数组引用也归结到构造器引用
 * https://www.bilibili.com/video/BV1PY411e7J6/?p=196&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * TODO 看看这段AI补的对不对
 * AI（数组引用也是构造器引用，但是数组引用是引用传递，而构造器引用是值传递。）
 *
 * @author xconf
 * @since 2023/11/2
 */
@Slf4j
public class Reference02ConstructorTest {
    /**
     * 构造器引用
     * Supplier中对的T get()
     */
    @Test
    void test01() {
        @NoArgsConstructor
        @ToString
        class Employee {
            Integer id;
            String name;
            Integer age;
        }
        Supplier<Employee> supplier = Employee::new;
        log.info("{}", supplier.get());
    }

    /**
     * 构造器引用
     * Function中的R apply(T t)
     */
    @Test
    void test02() {
        //@NoArgsConstructor// 有没有无参构造方法都可以运行。
        @ToString
        class Employee {
            Integer id;
            String name;
            Integer age;
            Employee(Integer id) {
                this.id = id;
            }
        }
        Function<Integer, Employee> function = Employee::new;
        log.info("{}", function.apply(1));
    }

    /**
     * 构造器引用
     * BiFunction中的R apply(T t, U u)
     */
    @Test
    void test03() {
        @ToString
        class Employee {
            Integer id;
            String name;
            Integer age;
            Employee(Integer id, String name) {
                this.id = id;
                this.name = name;
            }
        }
        BiFunction<Integer, String, Employee> biFunction = Employee::new;
        log.info("{}", biFunction.apply(1, "刘洋"));
    }

    /**
     * 数组引用
     * 数组名[]::new
     * Function中的R apply(T t)
     */
    @Test
    void test04() {
        @NoArgsConstructor
        @ToString
        class Employee {
            Integer id;
            String name;
            Integer age;
        }
        Function<Integer, Employee[]> function = Employee[]::new;
        // apply的参数就是数组的长度
        Arrays.stream(function.apply(4)).forEach(System.out::println);// 数目时对的，不过貌似还是有问题。202311030014 liuyang TODO
    }
}
