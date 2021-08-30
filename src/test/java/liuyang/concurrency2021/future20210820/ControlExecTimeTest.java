package liuyang.concurrency2021.future20210820;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liuyang
 * @date 2021/8/27
 */
@Slf4j
public class ControlExecTimeTest {

    @BeforeEach
    void init () {
        ControlExecTime.EXEC_TIME = 1000l;
        // ControlExecTime.TIME_OUT = 99l; // 10001l;
        ControlExecTime.TIME_OUT = 10001l; // 10001l;
    }

    @Test
    void test() {
        //boolean b = ControlExecTime.timeControlMethod(ControlExecTime.IsAliveResponse.class);
        //log.info("是否超时 = {}", b);
        ControlExecTime.TimeControlReturnType<ControlExecTime.IsAliveResponse> isAliveResponseTimeControlReturnType
                = ControlExecTime.timeControlMethod(ControlExecTime.IsAliveResponse.class);
        log.info("response = {}", JSON.toJSONString(isAliveResponseTimeControlReturnType));
        if (isAliveResponseTimeControlReturnType.isTimeout()) {
            log.info("##超时！");
        } else {
            log.info("##未超时！");
        }
    }
}
