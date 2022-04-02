package liuyang.lang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author liuyang
 * @date 2021/8/16
 */
@Slf4j
public class StringTests {


    @Test
    void testSplit() {
        String omcUrl = "https://193.168.110.198:2000";
        String ip = omcUrl.split(":")[1].replaceAll("//", "");
        String port = omcUrl.split(":")[2];
        log.info(ip);
        log.info(port);
    }


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
