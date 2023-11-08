package liuyang.tools.guava.base;

import com.google.common.base.CaseFormat;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua?p=5&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 12:25
 *
 * @author xconf
 * @since 2023/11/9
 */
@Slf4j
public class 下划线和驼峰互转 {

    @Test
    void 测试Guava中的下划线转驼峰() {
        String str = "t_actor";
        log.info("{}", CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str));// 首字母小写
        log.info("{}", CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, str));// 首字母大写
    }

    @Test
    void 测试Guava中的驼峰转下划线() {
        log.info("{}", CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "tActor"));
        log.info("{}", CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, "tActor"));// 见识一下CaseFormat.UPPER_UNDERSCORE 原来就是全大写
    }

    @Test
    void 测试() {
        System.out.println("""
                Java略带骚气的"隐藏"技能
                中文类名
                """);
    }
}
