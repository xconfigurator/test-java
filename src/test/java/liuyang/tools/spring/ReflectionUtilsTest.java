package liuyang.tools.spring;

import liuyang.essentials.springessentials.annotation.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.ReflectionUtils;

import java.util.Objects;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua/?p=10&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 04:59
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/util/ReflectionUtils.html
 *
 * @author xconf
 * @since 2023/11/8
 */
@Slf4j
public class ReflectionUtilsTest {

    @DisplayName("不包含继承的信息")
    @Test
    void test202311090616Local() {
        // 字段
        ReflectionUtils.doWithLocalFields(Student.class, field -> {
            log.info("字段名：{}， \t\t\t字段类型{}, 声明于：{}", field.getName(), field.getType(), field.getDeclaringClass().getName());
        });
        // 方法
        ReflectionUtils.doWithLocalMethods(Student.class, mc -> {
            log.info("方法名：{}， \t\t\t\t参数个数：{}， \t\t参数类型：{}, 声明于：{}", mc.getName(), mc.getParameterCount(), mc.getParameterTypes(), mc.getDeclaringClass().getName());
        });
    }

    @DisplayName("包含继承的信息")
    @Test
    void test202311090617All() {
        // 字段
        ReflectionUtils.doWithFields(Student.class, field -> {
            log.info("字段名：{}， \t\t\t字段类型{}， 声明于：{}", field.getName(), field.getType(), field.getDeclaringClass().getName());
        });
        // 方法
        ReflectionUtils.doWithMethods(Student.class, mc -> {
            log.info("方法名：{}， \t\t\t\t参数个数：{}， \t\t参数类型：{}, 声明于：{}", mc.getName(), mc.getParameterCount(), mc.getParameterTypes(), mc.getDeclaringClass().getName());
        });
    }
}
