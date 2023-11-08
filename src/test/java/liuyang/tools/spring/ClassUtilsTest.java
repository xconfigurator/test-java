package liuyang.tools.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.ClassUtils;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua/?p=10&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/util/ClassUtils.html
 *
 * @author xconf
 * @since 2023/11/8
 */
@Slf4j
public class ClassUtilsTest {

    // 问题：是否加载了XX类
    // Spring Boot @ConditionalOnClass
    @Test
    void test202311090550() {
        // 方法1： Class.forName(CLASS_NAME); 看看是否抛异常。
        // 方法2： ClassUtilsTest.class.getClassLoader().loadClass(CLASS_NAME); 看看是否抛异常。
        // 方法2：使用Spring的ClassUtils。（内部也是通过Class.forName()实现）
        log.info("{}", ClassUtils.isPresent("xxx", ClassUtilsTest.class.getClassLoader()));
        log.info("{}", ClassUtils.isPresent("java.lang.String", ClassUtilsTest.class.getClassLoader()));
    }
}
