package liuyang.tools.hutool;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author xconf
 * @since 2023/11/8
 */
@Slf4j
public class IdUtilTest {

    // https://www.hutool.cn/docs/#/core/%E5%B7%A5%E5%85%B7%E7%B1%BB/%E5%94%AF%E4%B8%80ID%E5%B7%A5%E5%85%B7-IdUtil
    @DisplayName("IdUtil")
    @Test
    void test202311080518() {
        // Snowflake
        log.info("Snowflake:\t{}", IdUtil.getSnowflakeNextId());// long
        log.info("Snowflake:\t{}", IdUtil.getSnowflakeNextIdStr());// String
        //
        log.info("UUID:\t\t{}", IdUtil.randomUUID());
        log.info("UUID:\t\t{}", IdUtil.simpleUUID());

        // for MongoDB
        log.info("MongoDB:\t\t{}", IdUtil.objectId());
        log.info("MongoDB:\t\t{}", ObjectId.next());
    }
}
