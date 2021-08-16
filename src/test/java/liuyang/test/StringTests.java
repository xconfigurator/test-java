package liuyang.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author liuyang
 * @date 2021/8/16
 */
public class StringTests {

    @AllArgsConstructor
    @Getter
    class A {
        private String str;
    }

    @Test
    void testEquals() {
        A a = new A("");
        //Assertions.assertNotEquals("", a.getStr());
        if ("" == a.getStr()) {
            System.out.println("等");// 很神奇，竟然相等。但最不要这样写！！！
        } else {
            System.out.println("不等");
        }

        if ("".equals(a.getStr())) {
            System.out.println("推荐写法 等");
        } else {
            System.out.println("推荐写法 不等");
        }
    }
}
