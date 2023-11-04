package liuyang.update11;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * JDK9 String底层由char[] 改为 byte[]
 *      相关的StringBuffer和StringBuilder也跟着改变了。
 * JDK11 String有了一些新的方法
 * JDK12 String实现了Constable接口
 *
 * @author xconf
 * @since 2023/11/4
 */
@Slf4j
public class String11Test {

    /**
     * JDK11 String新增了一些方法
     */
    @Test
    void test11() {
        log.info("{}", " ".isBlank());
        log.info("{}", "Javastack".strip());
        log.info("{}", "Javastack".stripTrailing());
        log.info("{}", "Javastack".stripLeading());
        log.info("{}", "Java".repeat(3));
        log.info("{}", "A\nB\nC".lines().count());
    }

    @Test
    void test12() {
        var result1 = "foo".transform(intput -> intput + "bar");
        log.info("{}", result1);

        var result2 = "foo".transform(input -> input + "bar").transform(String::toUpperCase);
        log.info("{}", result2);
    }
}
