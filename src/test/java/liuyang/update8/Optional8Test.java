package liuyang.update8;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * 视频
 * https://www.bilibili.com/video/BV1PY411e7J6/?p=199&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 45:51 ~
 *
 * @author xconf
 * @since 2023/11/4
 */
@Slf4j
public class Optional8Test {

    /**
     * Optional避免空指针异常的示例
     */
    @Test
    void test01() {
        String str = "迪丽热巴";
        Optional<String> optional1 = Optional.ofNullable(str);
        log.info("{}", optional1.orElse("杨幂"));
        str = null;
        log.info("{}", optional1.orElse("杨幂"));

        Optional<String> optional2 = Optional.ofNullable(null);
        log.info("{}", optional2.orElse("杨幂"));
    }

    /**
     * get()
     */
    @Test
    void test02() {
        String str = "迪丽热巴";
        Optional<String> optional1 = Optional.ofNullable(str);
        log.info("{}", optional1.get());

        Optional<String> optional2 = Optional.ofNullable(null);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            log.info("{}", optional2.get());
        });
    }
}
