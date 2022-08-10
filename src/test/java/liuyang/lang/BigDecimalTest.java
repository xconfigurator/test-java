package liuyang.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author liuyang(wx)
 * @since 2022/8/10
 */
@Slf4j
class BigDecimalTest {

    // 需求：模拟经纬度范围
    /*
    模拟的经纬度范围
    蓝牙设备：
    （0.05，0.06）（114.356994912，38.055174113）
    （24.43，0.06）（114.3567149112，38.055174113）
    （24.54，15.54）（114.3567149112，38.0556604113）
    （0.05，15.5）（114.356994912，38.0556604113）
    UWB设备：
    (0,0)(114.3569949112,38.0555174113)
    (24.48,0)(114.3567149112,38.0555184113)
     */

    @Test
    void test() {
        //private float longitude;// 经度
        //private float latitude;// 纬度

        // 使用float这个精度真的好吗？
        log.info("hei!");
    }
}
