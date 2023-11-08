package liuyang.tools.hutool;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;
import cn.hutool.jwt.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.Param;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hutool.cn/docs/#/jwt/JWT%E5%B7%A5%E5%85%B7-JWTUtil
 *
 * @author xconf
 * @since 2023/11/8
 */
@Slf4j
public class JWTUtilTest {

    @DisplayName("JWT创建")
    @Test
    void test202311082008() {
        Map<String, Object> map = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;
            {
                put("uid", Integer.parseInt("123"));
                put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
            }
        };

        String token = JWTUtil.createToken(map, "1234".getBytes());
        log.info("token = {}", token);
    }

    @DisplayName("JWT验证")
    @ParameterizedTest
    @ValueSource(strings={"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjEyMywiZXhwaXJlX3RpbWUiOjE3MDA3NDIwNTMzOTR9.wE21W-DV0RaNdi08MiPFxva1zv7vR7K9jud-D181_Zg"})
    void test202311082013(String token) {
        assertTrue(JWTUtil.verify(token, "1234".getBytes()));
    }


    @DisplayName("JWT解析")
    @ParameterizedTest
    @ValueSource(strings = {"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjEyMywiZXhwaXJlX3RpbWUiOjE3MDA3NDIwNTMzOTR9.wE21W-DV0RaNdi08MiPFxva1zv7vR7K9jud-D181_Zg"})
    void test202311082011(String token) {
        final JWT jwt = JWTUtil.parseToken(token);
        log.info("{}", jwt.getHeader(JWTHeader.TYPE));
        log.info("{}", jwt.getPayload("sub"));
    }
}
