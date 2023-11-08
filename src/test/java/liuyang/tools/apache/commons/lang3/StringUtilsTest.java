package liuyang.tools.apache.commons.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua/?p=2&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * @author xconf
 * @since 2023/11/8
 */
@Slf4j
public class StringUtilsTest {
    @DisplayName("判空 isBlank isEmpty")
    @Test
    void test202311080506() {
        // 判空串
        String str = "   ";
        assertTrue(StringUtils.isBlank(str));
        assertFalse(StringUtils.isEmpty(str));
        str = null;
        assertTrue(StringUtils.isBlank(str));
        assertTrue(StringUtils.isEmpty(str));
    }
    @DisplayName("截取")
    @Test
    void test202311082035() {
        String phone = "18931160972";
        log.info("{}", StringUtils.left(phone, 3) + "****" + StringUtils.right(phone, 4));
    }
    @DisplayName("填充")
    @Test
    void test202311082036() {
        String phone = "18931160972";
        log.info("{}", StringUtils.leftPad(phone, 20, "*"));
    }
}
