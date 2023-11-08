package liuyang.tools.apache.commons.lang3;

import lombok.extern.slf4j.Slf4j;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.math.NumberUtils;// 注意这个包名！！
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua/?p=2&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 12:21
 *
 * @author xconf
 * @since 2023/11/8
 */
@Slf4j
public class NumberUtilsTest {

    @DisplayName("整数")
    @Test
    void test202311082039() {
        assertFalse(NumberUtils.isDigits("12.3aaa"));
        assertFalse(NumberUtils.isDigits("12.3"));
        assertFalse(NumberUtils.isDigits("-12.3"));
        assertFalse(NumberUtils.isDigits("+123"));
        assertFalse(NumberUtils.isDigits("-123"));
        assertTrue(NumberUtils.isDigits("0123"));// 可！
        assertFalse(NumberUtils.isDigits("0x123"));// 不可
        assertTrue(NumberUtils.isDigits("123"));
    }

    @DisplayName("整数、浮点数都可以接受（仅十进制）")
    @Test
    void test202311082105() {
        // isParsable() 十进制
        assertFalse(NumberUtils.isParsable("12.3aaa"));
        assertTrue(NumberUtils.isParsable("12.3"));
        assertTrue(NumberUtils.isParsable("-12.3"));
        assertFalse(NumberUtils.isParsable("+123"));// 不可
        assertTrue(NumberUtils.isParsable("-123"));// 可！
        assertTrue(NumberUtils.isParsable("0123"));
        assertTrue(NumberUtils.isParsable("09"));// 默认按十进制处理
        assertFalse(NumberUtils.isParsable("0x123"));// 不可 默认按十进制处理
        assertTrue(NumberUtils.isParsable("123"));
    }

    @DisplayName("整数、浮点数都可以接受（进制相关）")
    @Test
    void test202311082145() {
        // isCreatable() 进制相关 具体差别看源码注释
        assertTrue(NumberUtils.isCreatable("+123"));// 这个比前面的都宽泛
        assertTrue(NumberUtils.isCreatable("0123"));
        assertFalse(NumberUtils.isCreatable("09"));// 8进制中没有9
        assertTrue(NumberUtils.isCreatable("0x123"));
    }
}
