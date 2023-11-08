package liuyang.tools.guava.base;

import com.google.common.base.Preconditions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua/?p=9&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * 类比 JSR 303 349 380 BeanValidation
 *
 * @author xconf
 * @since 2023/11/9
 */
public class PreconditionsTest {

    // 校验
    @Test
    void test() {
        assertThrows(NullPointerException.class, () -> {
            Preconditions.checkNotNull(null, "参数不能为空");
        });
        String param = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Preconditions.checkArgument(param != null, "参数不能为空");
        });
    }
}
