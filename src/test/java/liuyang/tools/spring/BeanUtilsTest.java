package liuyang.tools.spring;

import liuyang.essentials.springessentials.annotation.Student;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua/?p=10&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 15:59
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/BeanUtils.html
 *
 * @author xconf
 * @since 2023/11/9
 */
@Slf4j
public class BeanUtilsTest {
    @Test
    void test202311090629() {
        Student student1 = new Student(1, "liuyang", 40);
        Student student2 = new Student();
        System.out.println(student2);
        BeanUtils.copyProperties(student1, student2);
        System.out.println(student2);
    }

    /**
     * 测试属性拷贝
     */
    @DisplayName("深拷贝：错误使用场景")
    @Test
    void test202402192346() {

        @Data
        @ToString
        class A {
            String foo;
            String bar;
            Integer[] arr;
        }

        Integer[] array = new Integer[]{1 ,2 ,3};

        A a1 = new A();
        a1.setFoo("foo");
        a1.setBar("bar");
        a1.setArr(array);

        A a2 = new A();
        BeanUtils.copyProperties(a1, a2);
        log.info("a2 = {}", a2);

        // 更改源
        array[2] = 4;
        log.info("a2 = {}", a2);

        // 更改a1中的数组元素值
        a1.getArr()[2] = 5;
        log.info("a2 = {}", a2);

        /*
        23:50:41.095 [main] INFO liuyang.tools.spring.BeanUtilsTest - a2 = A(foo=foo, bar=bar, arr=[1, 2, 3])
        23:50:41.104 [main] INFO liuyang.tools.spring.BeanUtilsTest - a2 = A(foo=foo, bar=bar, arr=[1, 2, 4])
        23:50:41.104 [main] INFO liuyang.tools.spring.BeanUtilsTest - a2 = A(foo=foo, bar=bar, arr=[1, 2, 5])
         */
        // 结论：在没有定义深拷贝规则的时候，BeanUtils.copyProperties并不会执行深拷贝。
    }

    @DisplayName("深拷贝：错误使用场景")
    @Test
    void test202402192352() {

        @Data
        @ToString
        class A implements Cloneable{
            String foo;
            String bar;
            Integer[] arr;
            @Override
            protected Object clone() throws CloneNotSupportedException {
                A a = new A();
                a.setFoo(this.foo);
                a.setBar(this.bar);
                Integer[] arrCopy = new Integer[this.arr.length];
                System.arraycopy(this.arr, 0, arrCopy, 0, this.arr.length);
                a.setArr(arrCopy);
                return a;
            }
        }

        Integer[] array = new Integer[]{1 ,2 ,3};

        A a1 = new A();
        a1.setFoo("foo");
        a1.setBar("bar");
        a1.setArr(array);

        A a2 = new A();
        BeanUtils.copyProperties(a1, a2);
        log.info("a2 = {}", a2);

        // 更改源
        array[2] = 4;
        log.info("a2 = {}", a2);

        // 更改a1中的数组元素值
        a1.getArr()[2] = 5;
        log.info("a2 = {}", a2);

        /*
        23:56:08.696 [main] INFO liuyang.tools.spring.BeanUtilsTest - a2 = A(foo=foo, bar=bar, arr=[1, 2, 3])
        23:56:08.703 [main] INFO liuyang.tools.spring.BeanUtilsTest - a2 = A(foo=foo, bar=bar, arr=[1, 2, 4])
        23:56:08.703 [main] INFO liuyang.tools.spring.BeanUtilsTest - a2 = A(foo=foo, bar=bar, arr=[1, 2, 5])
         */
        // 结论：定义了克隆规则后也不会，BeanUtils.copyProperties并不会执行深拷贝。
    }


    @DisplayName("深拷贝：正确使用场景")
    @Test
    void test202402192357() throws CloneNotSupportedException {

        @Data
        @ToString
        class A implements Cloneable{
            String foo;
            String bar;
            Integer[] arr;
            @Override
            protected Object clone() throws CloneNotSupportedException {
                A a = new A();
                a.setFoo(this.foo);
                a.setBar(this.bar);
                Integer[] arrCopy = new Integer[this.arr.length];
                System.arraycopy(this.arr, 0, arrCopy, 0, this.arr.length);
                a.setArr(arrCopy);
                return a;
            }
        }

        Integer[] array = new Integer[]{1 ,2 ,3};

        A a1 = new A();
        a1.setFoo("foo");
        a1.setBar("bar");
        a1.setArr(array);

        //A a2 = new A();
        //BeanUtils.copyProperties(a1, a2);
        A a2 = (A) a1.clone();
        log.info("a2 = {}", a2);

        // 更改源
        array[2] = 4;
        log.info("a2 = {}", a2);

        // 更改a1中的数组元素值
        a1.getArr()[2] = 5;
        log.info("a2 = {}", a2);

        /*
        23:59:06.220 [main] INFO liuyang.tools.spring.BeanUtilsTest - a2 = A(foo=foo, bar=bar, arr=[1, 2, 3])
        23:59:06.228 [main] INFO liuyang.tools.spring.BeanUtilsTest - a2 = A(foo=foo, bar=bar, arr=[1, 2, 3])
        23:59:06.228 [main] INFO liuyang.tools.spring.BeanUtilsTest - a2 = A(foo=foo, bar=bar, arr=[1, 2, 3])
         */
        // 结论：克隆就应该按照Java自己的规则去做。
        // 这与
    }

}
