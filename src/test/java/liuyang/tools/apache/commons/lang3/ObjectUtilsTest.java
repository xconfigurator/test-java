package liuyang.tools.apache.commons.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua/?p=2&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 23:52
 *
 * @author xconf
 * @since 2023/11/8
 */
@Slf4j
public class ObjectUtilsTest {
    @DisplayName("e.g. 在字符串数组中找到第一个非空字符串")
    @Test
    void test202311082119() {
        //String[] arr = {null, null, "", "hello", null};// ""
        String[] arr = {null, null, "foo", "hello", null};// "foo"
        log.info("{}", ObjectUtils.firstNonNull(arr));// 注意空串也是NonNull！
    }

    @DisplayName("identityToString 貌似是Spring使用了这个")
    @Test
    void test202311082202() {
        log.info("{}", ObjectUtils.identityToString("abc"));
    }
}
