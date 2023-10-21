package liuyang.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author xconf
 * @since 2023/10/19
 */
@Slf4j
public class IntegerTest {

    /**
     * 16 -> 2
     */
    @Test
    void test202310211902() {
        // 先看一下答案中的掩码的二进制形式都是啥
        System.out.printf("%020d\n", Integer.parseInt(Integer.toBinaryString(Integer.parseUnsignedInt("ff", 16))));
        System.out.printf("%020d\n", Long.parseLong(Integer.toBinaryString(Integer.parseUnsignedInt("7f00", 16))));
        System.out.printf("%020d\n", Long.parseLong(Integer.toBinaryString(Integer.parseUnsignedInt("18000", 16))));
        System.out.printf("%020d\n", Long.parseLong(Integer.toBinaryString(Integer.parseUnsignedInt("20000", 16))));
        System.out.printf("%020d\n", Long.parseLong(Integer.toBinaryString(Integer.parseUnsignedInt("40000", 16))));
        System.out.printf("%s", Integer.toBinaryString(Integer.parseUnsignedInt("80000", 16)));
    }


    /**
     * 2 -> 16
     */
    @Test
    void test202310211901() {
        // 二进制转化成十六进制
        /*
        00000000000011111111
        00000111111100000000
        00011000000000000000
        00100000000000000000
        01000000000000000000
        10000000000000000000
         */
        System.out.printf("%s\n", Long.toHexString(Long.parseLong("00000000000011111111", 2)));
        System.out.printf("%s\n", Long.toHexString(Long.parseLong("00000111111100000000", 2)));
        System.out.printf("%s\n", Long.toHexString(Long.parseLong("00011000000000000000", 2)));
        System.out.printf("%s\n", Long.toHexString(Long.parseLong("00100000000000000000", 2)));
        System.out.printf("%s\n", Long.toHexString(Long.parseLong("01000000000000000000", 2)));
        System.out.printf("%s\n", Long.toHexString(Long.parseLong("10000000000000000000", 2)));
    }


    /**
     *  《C Primer Plus（第6版）中文版习题解答》 P278 设计掩码
     */
    @Test
    void test202310190714() {
        log.info("{} {} {}", "0xFF", Integer.parseUnsignedInt("00ff", 16), Integer.toBinaryString(Integer.parseUnsignedInt("00ff", 16)));
        log.info("{} {} {}", "0x7f00", Integer.parseUnsignedInt("7f00", 16), Integer.toBinaryString(Integer.parseUnsignedInt("7f00", 16)));
        log.info("{} {} {}", "0x18000", Integer.parseUnsignedInt("18000", 16), Integer.toBinaryString(Integer.parseUnsignedInt("18000", 16)));

        // 先看一下答案中的掩码的二进制形式都是啥
        System.out.printf("%020d\n", Integer.parseInt(Integer.toBinaryString(Integer.parseUnsignedInt("ff", 16))));
        System.out.printf("%020d\n", Long.parseLong(Integer.toBinaryString(Integer.parseUnsignedInt("7f00", 16))));
        System.out.printf("%020d\n", Long.parseLong(Integer.toBinaryString(Integer.parseUnsignedInt("18000", 16))));
        System.out.printf("%020d\n", Long.parseLong(Integer.toBinaryString(Integer.parseUnsignedInt("20000", 16))));
        System.out.printf("%020d\n", Long.parseLong(Integer.toBinaryString(Integer.parseUnsignedInt("40000", 16))));
        System.out.printf("%s", Integer.toBinaryString(Integer.parseUnsignedInt("80000", 16)));

        // 二进制转化成十六进制
        /*
        00000000000011111111
        00000111111100000000
        00011000000000000000
        00100000000000000000
        01000000000000000000
        10000000000000000000
         */
        System.out.printf("%s\n", Long.toHexString(Long.parseLong("00000000000011111111", 2)));
        System.out.printf("%s\n", Long.toHexString(Long.parseLong("00000111111100000000", 2)));
        System.out.printf("%s\n", Long.toHexString(Long.parseLong("00011000000000000000", 2)));
        System.out.printf("%s\n", Long.toHexString(Long.parseLong("00100000000000000000", 2)));
        System.out.printf("%s\n", Long.toHexString(Long.parseLong("01000000000000000000", 2)));
        System.out.printf("%s\n", Long.toHexString(Long.parseLong("10000000000000000000", 2)));
    }
}
