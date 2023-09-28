package liuyang.lang;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java正则“脚手架”
 *
 * 视频参考：https://www.bilibili.com/video/av36806419/?p=230&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * java.util.regex
 * java.util.regex.Pattern
 * java.util.regex.Matcher
 *
 * @author xconf
 * @since 2023/9/27
 */
@Slf4j
public class RegularExpressions01Test {
    @DisplayName("Java中正则表达式最简单使用")
    @Test
    void test202309271934() {
        assertTrue("abc".matches("[a-z]{3}"));
        assertTrue("abc".matches("..."));
    }

    @DisplayName("replaceAll")
    @Test
    void test202309280722() {
        // 把字符串中所有数字变成-
        log.info("{}", "a8729a".replaceAll("\\d", "-"));
    }

    @DisplayName("Pattern用法")
    @Test
    void test202309280735() {
        // javadoc: Pattern
        // https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/regex/Pattern.html
        Pattern pattern = Pattern.compile("[a-z]{3}");
        Matcher matcher = pattern.matcher("abc");
        assertTrue(matcher.matches());
    }
}
