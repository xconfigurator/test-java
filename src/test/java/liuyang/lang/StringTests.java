package liuyang.lang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

/**
 * @author liuyang
 * @date 2021/8/16
 */
@Slf4j
public class StringTests {

    @Test
    void test202208181917() {
        String str = "hello";
        log.info("{}", str.getClass());
    }

    @Test
    void test202207251101() {
        Pattern PATTERN_All_ENODEB = Pattern.compile("\\d_\\d");
        if (!PATTERN_All_ENODEB.matcher("1_").matches()) {
            log.info("dismatch");
        } else {
            log.info("match");
        }
    }

    @Test
    void test202204271557() {
        // /pdt-nms/ws/AlmReportService
        //String appPrefix = "pdt-nms";
        /*String appName = "";
        String requestURI = "/pdt-nms/ws/AlmReportService";

        int beginIndex = 0;
        if (appName == null || "".equals(appName.trim())) {
            beginIndex = 0;
        } else {
            beginIndex = requestURI.indexOf("/" + appName) + appName.length() + 1;
        }

        log.info(requestURI.substring(beginIndex));*/

        log.info(getSubPath("pdt-nms", "/pdt-nms/ws/AlmReportService"));
        log.info(getSubPath(null, null));
        log.info(getSubPath("", null));
        log.info(getSubPath("", ""));
        log.info(getSubPath("", "/pdt-nms/ws/AlmReportService"));

    }

    /**
     * 例：
     * 输入
     *  appName = pdt-nms
     *  requestURI = /pdt-nms/ws/AlmReportService
     * 返回
     *  /ws/AlmReportService
     *
     * @param appName
     * @param requestURI
     * @return
     */
    private String getSubPath(String appName, String requestURI) {
        if (null == requestURI || "".equals(requestURI.trim())) return requestURI;

        // 计算子串开始位置
        int beginIndex = 0;
        if (appName == null || "".equals(appName.trim())) {
            beginIndex = 0;
        } else {
            beginIndex = requestURI.indexOf("/" + appName) + appName.length() + 1;
        }

        return requestURI.substring(beginIndex);
    }

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