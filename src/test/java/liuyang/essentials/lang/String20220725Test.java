package liuyang.essentials.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author liuyang(wx)
 * @since 2022/7/25
 *        2023/11/05 从test-spring-boot-env复制过来
 */
@Slf4j
public class String20220725Test {

    @Test
    void test202211191044() {
        // 拆
        String data = "{\"data\":[{\"alist\":[{\"adis\":19.801,\"aid\":\"A4\"},{\"adis\":11.972,\"aid\":\"A1\"},{\"adis\":9.672,\"aid\":\"A2\"},{\"adis\":51.534,\"aid\":\"A7\"},{\"adis\":20.255,\"aid\":\"A3\"},{\"adis\":47.57,\"aid\":\"A5\"},{\"adis\":49.181,\"aid\":\"A6\"}],\"alarm\":0,\"x\":61.039,\"y\":5.2,\"alarmfeedback\":0,\"z\":1.812,\"time\":\"2022-10-19 14:51:51:540\",\"battery\":0.9,\"tid\":1,\"ltype\":7}],\"mt\":\"position\"}$_{\"data\":[{\"alist\":[{\"adis\":19.801,\"aid\":\"A4\"},{\"adis\":11.972,\"aid\":\"A1\"},{\"adis\":9.672,\"aid\":\"A2\"},{\"adis\":51.534,\"aid\":\"A7\"},{\"adis\":20.255,\"aid\":\"A3\"},{\"adis\":47.57,\"aid\":\"A5\"},{\"adis\":49.181,\"aid\":\"A6\"}],\"alarm\":0,\"x\":61.039,\"y\":5.2,\"alarmfeedback\":0,\"z\":1.812,\"time\":\"2022-10-19 14:51:51:540\",\"battery\":0.9,\"tid\":1,\"ltype\":7}],\"mt\":\"position\"}$_";
        final String[] strArr = data.split("\\$_");
        for (int i = 0; i < strArr.length; ++i) {
            log.info("strArr[] = {}", strArr[i]);
        }
        // 去掉尾部
        final Pattern pattern = Pattern.compile("^.*\\$_$");
        List<String> result = new LinkedList<>();
        System.out.println(strArr.length);
        for (int i = 0; i < strArr.length; ++i) {
            log.info("r = {}", pattern.matcher(strArr[i]).replaceAll(""));
        }
        result.stream().forEach(r -> log.info("result = {}", r));
    }


    @ParameterizedTest
    @ValueSource(strings = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "001", "10", "20", "200", "1", "12", "123" })
    void test202211171112(String provinceId) {
        final Pattern pattern = Pattern.compile("^0+");
        String s = pattern.matcher(provinceId).replaceFirst("");
        log.info("处理前 = {}， 处理后 = {}", provinceId, s);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1_-1","2_-1", "1_1", "2_2", "1_-1", "2_0"
            ,"_", "_1", "1_", "x_x", ""})
    void test202207251101(String keyValue) {
        Pattern PATTERN_All_ENODEB = Pattern.compile("-?\\d_-?\\d");
        if (!PATTERN_All_ENODEB.matcher(keyValue).matches()) {
            log.info("dismatch");
        } else {
            log.info("match");
        }
    }

    @Test
    void test202207251602() {
        String[] arr = {};
        for (String str : arr) {
            log.debug("foo");
        }
        log.debug("bar");
    }
}
