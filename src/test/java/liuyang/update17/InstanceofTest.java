package liuyang.update17;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * instanceof
 *
 * JDK14预览特性
 * JDK15二次预览
 * JDK16转正
 *
 * @author xconf
 * @since 2023/11/3
 */
@Slf4j
public class InstanceofTest {

    @DisplayName("JDK14+")
    @Test
    void testJDK14() {
        Object obj = new String("hello, JDK14之后 如果匹配成功则自动转换");
        if (obj instanceof String str) {
            System.out.println(str);
        } else {
            System.out.println("不是字符串类型");
        }
    }

    @DisplayName("JDK14之前")
    @Test
    void testTraditional() {
        Object obj = new String("hello, JDK14之前");
        // 先判断
        if (obj instanceof String) {
            // 后转换
            String str = (String) obj;
            System.out.println(str);
        } else {
            System.out.println("不是字符串类型");
        }
    }
}
