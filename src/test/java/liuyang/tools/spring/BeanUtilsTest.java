package liuyang.tools.spring;

import liuyang.essentials.springessentials.annotation.Student;
import lombok.extern.slf4j.Slf4j;
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
}
