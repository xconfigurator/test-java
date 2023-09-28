package liuyang.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Matcher
 * https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/regex/Matcher.html
 *
 * matches
 * find
 * lookingAt
 *
 * @author xconf
 * @since 2023/9/28
 */
@Slf4j
public class RegularExpressions03MatcherTest {

    // https://www.bilibili.com/video/BV1Yt41197sM?p=237&vd_source=8bd7b24b38e3e12c558d839b352b32f4
    // https://www.bilibili.com/video/BV1Yt41197sM?p=238&vd_source=8bd7b24b38e3e12c558d839b352b32f4
    @DisplayName("Match的最简单使用")
    @Test
    void test202309282023() {
        Pattern p = Pattern.compile("\\d{3,5}");
        String s = "123-34345-234-00";
        Matcher m = p.matcher(s);

        // 实验 1
        assertFalse(m.matches());
        m.reset();

        // 实验 2 find
        log.info("#find");
        assertTrue(m.find());// 找一个和这个模式匹配的字串
        log.info("start:{} end:{}", m.start(), m.end());
        assertTrue(m.find());
        log.info("start:{} end:{}", m.start(), m.end());
        assertTrue(m.find());
        log.info("start:{} end:{}", m.start(), m.end());
        assertFalse(m.find());
        assertThrows(IllegalStateException.class, () -> {
            log.info("start:{} end:{}", m.start(), m.end());// java.lang.IllegalStateException: No match available
        });
        assertFalse(m.find());// 第五次
        assertThrows(IllegalStateException.class, () -> {
            log.info("start:{} end:{}", m.start(), m.end());// java.lang.IllegalStateException: No match available
        });

        // 实验 3 lookingAt(这个名字起得太差劲了)
        // Attempts to match the input sequence, starting at the beginning of the region, against the pattern.
        log.info("#lookingAt");
        assertTrue(m.lookingAt());// 每次找都从头找
        log.info("start:{} end:{}", m.start(), m.end());
        assertTrue(m.lookingAt());// 每次找都从头找
        log.info("start:{} end:{}", m.start(), m.end());
    }


    @DisplayName("matcher.find() matcher.group()")
    @Test
    void test202309282042() {
        String str = "java Java JAVa JaVa IloveJAVA you hateJava asdfafdsdsdsfdsfdsf";
        Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(str);
        while (matcher.find()) {
            log.info(matcher.group());
        }
    }

    // 替换
    // https://www.bilibili.com/video/BV1Yt41197sM?p=239&vd_source=8bd7b24b38e3e12c558d839b352b32f4
    @DisplayName("matcher.replaceAll()")
    @Test
    void test202309282043() {
        // 问题：请将目标字符串中的所有Java全部替换成C++
        String str = "java Java JAVa JaVa IloveJAVA you hateJava asdfafdsdsdsfdsfdsf";
        Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(str);
        log.info("替换前：{}", str);
        log.info("替换后：{}", matcher.replaceAll("C++"));
    }

    // 替换
    // https://www.bilibili.com/video/BV1Yt41197sM?p=239&vd_source=8bd7b24b38e3e12c558d839b352b32f4
    @DisplayName("matcher.appendReplacement()")
    @Test
    void test202309282102() {
        // 问题：请将目标字符串中的所有Java，奇数的Java替换成C++，偶数的Java替换成C。
        String str = "java Java JAVa JaVa IloveJAVA you hateJava asdfafdsdsdsfdsfdsf";
        Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(str);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (matcher.find()) {
            i++;
            if (0 == i % 2) {
                matcher.appendReplacement(sb, "C");
            } else {
                matcher.appendReplacement(sb, "C++");
            }
        }
        matcher.appendTail(sb);// 注释掉这句试试看。
        log.info("替换前：{}", str);
        log.info("替换后：{}", sb.toString());
    }

    // 分组
    // https://www.bilibili.com/video/BV1Yt41197sM?p=240&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
    @DisplayName("分组")
    @Test
    void test202309282117() {
        // 问题：请将符合指定规则的子串中的数字部分拿出来。
        // 处理：使用分组（当然也可以循环套循环）
        Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");
        String s = "123aa-34345bb-234cc-00";
        Matcher m = p.matcher(s);
        while(m.find()) {
            log.info("\t m.group() = {}, \t\t m.group(1) = {}, \t\t m.group(2) = {}", m.group(), m.group(1), m.group(2));// 组号数左小括号即可
        }
    }
}
