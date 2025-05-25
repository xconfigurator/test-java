package liuyang.update17;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * JDK14 预览
 * JDK15 二次预览
 * JDK16 转正
 * https://www.bilibili.com/video/BV1PY411e7J6?p=199&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 21:22 ~ 35:00
 *
 * Record不能替代JavaBean
 *
 *
 *
 * @author xconf
 * @since 2023/11/4
 * @update 2024/2/19    https://www.bilibili.com/video/BV1Km4y1k7bn/?p=7&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 */
@Slf4j
public class Record16Test {

    @Test
    void test202311040000() {
        // 引用数据类型：数组、类、接口、Enum、Annotation、Record（IntelliJ New Java Class中列出的都是引用数据类型。）

        @AllArgsConstructor
        @Data
        class OrderOld {
            final int orderId;
            final String orderName;
        }
        OrderOld orderOld = new OrderOld(1, "orderOld");
        System.out.println(orderOld);

        // Record示例
        record OrderNew(int orderId, String orderName) {
        }
        OrderNew orderNew = new OrderNew(1, "orderNew");
        System.out.println(orderNew);
    }


    // 视频参考 https://www.bilibili.com/video/BV1Km4y1k7bn/?p=7&vd_source=8bd7b24b38e3e12c558d839b352b32f4
    @Test
    void test202402192113() {
        record Student(Integer id, String name, String email, Integer age){}

        Student foo = new Student(1, "foo", "foo@163.com", 40);
        Student bar = new Student(2, "bar", "bar@163.com", 40);
        Student foo2 = new Student(1, "foo", "foo@163.com", 40);// 属性与foo完全相同

        // 没有get set
        log.info("id = {}, name = {}", foo.id, foo.name);
        log.info("id = {}, name = {}", bar.id(), bar.name());

        // equals
        Assertions.assertFalse(foo.equals(bar));
        Assertions.assertTrue(foo.equals(foo2));// foo  foo2属性完全相同
    }
}
