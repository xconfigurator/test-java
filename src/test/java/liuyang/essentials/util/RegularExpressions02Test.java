package liuyang.essentials.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Java正则举例（需要识记的内容）
 *
 * @author xconf
 * @since 2023/9/28
 */
@Slf4j
public class RegularExpressions02Test {

    // 1. 元字符 https://www.bilibili.com/video/av36806419/?p=232&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
    // 关于Quantifier（谓词） 的扩展说明 https://www.bilibili.com/video/BV1Yt41197sM/?p=243&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
    @DisplayName(". * + ?")
    @Test
    void testQuantifiers202309280754() {
        assertTrue("a".matches("."));
        assertTrue("aa".matches("aa"));
        assertTrue("aaaa".matches("a*"));
        assertTrue("aaaa".matches("a+"));
        assertTrue("".matches("a*"));
        assertFalse("aaaa".matches("a?"));
        assertTrue("".matches("a?"));
        assertTrue("a".matches("a?"));
        assertTrue("214523145234532".matches("\\d{3,100}"));// liuyang: 好神奇，你写成{3, 100}试试。
        assertFalse("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
        assertTrue("192".matches("[0-2][0-9][0-9]"));
    }

    // 2. Character classes 范围 https://www.bilibili.com/video/BV1Yt41197sM?p=233&vd_source=8bd7b24b38e3e12c558d839b352b32f4
    @DisplayName("Character classes")
    @Test
    void testCharacterClasses() {
        // https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/regex/Pattern.html
        assertTrue("a".matches("[abc]"));// [abc]	a, b, or c (simple class)
        assertTrue("d".matches("[^abc]"));// [^abc]	Any character except a, b, or c (negation)
        assertTrue("a".matches("[a-zA-Z]"));// [a-zA-Z]	a through z or A through Z, inclusive (range)
        assertTrue("a".matches("[a-d[m-p]]"));// [a-d[m-p]]	a through d, or m through p: [a-dm-p] (union)
        assertTrue("m".matches("[a-d]|[m-p]"));
        assertTrue("d".matches("[a-z&&[def]]"));// [a-z&&[def]]	d, e, or f (intersection)
        assertTrue("d".matches("[a-z&&[^bc]]"));// [a-z&&[^bc]]	a through z, except for b and c: [ad-z] (subtraction)
        assertFalse("m".matches("[a-z&&[^m-p]]"));// [a-z&&[^m-p]]	a through z, and not m through p: [a-lq-z](subtraction)
    }

    // 3. 其他元字符 https://www.bilibili.com/video/BV1Yt41197sM?p=234&vd_source=8bd7b24b38e3e12c558d839b352b32f4
    @DisplayName("Predefined character classes \\s \\w \\d")
    @Test
    void testPredefinedCharacterClasses() {
        assertTrue(" \n\r\t".matches("\\s{4}"));
        assertFalse(" ".matches("\\S"));
        assertTrue("a_8".matches("\\w{3}"));
        assertTrue("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
        //assertFalse("\\".matches("\\"));// IntelliJ会直接纠错
        assertTrue("\\".matches("\\\\"));
    }

    @DisplayName("POSIX character classes")
    @Test
    void test202309281947() {
        assertTrue("a".matches("\\p{Lower}"));
    }

    // 4. Boundary matchers 边界处理 https://www.bilibili.com/video/BV1Yt41197sM?p=235&vd_source=8bd7b24b38e3e12c558d839b352b32f4
    @DisplayName("^ $")
    @Test
    void testBoundaryMatchers() {
        assertTrue("hello sir".matches("^h.*"));
        assertTrue("hello sir".matches(".*ir$"));
        assertTrue("This is a dog.".matches(".*\\bis\\b.*"));
        assertFalse("Thisisadog.".matches(".*\\bis\\b.*"));
        assertTrue("Thisisadog.".matches(".*is.*"));

        // while lines
        assertTrue("".matches("^$"));
        assertTrue("".matches("^\\s*$"));
        assertTrue(" \n".matches("^\\s*$"));
        assertTrue("\t".matches("^\\s*$"));
        assertTrue("\r".matches("^\\s*$"));
    }


    @DisplayName("email")
    @Test
    void testEmail202309282019() {
        assertTrue("dfdsafsafdsdsafdsafdsa@adsffsdfdsa.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));
    }
}
