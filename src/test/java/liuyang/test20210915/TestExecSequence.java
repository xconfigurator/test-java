package liuyang.test20210915;

import org.junit.jupiter.api.Test;

/**
 * 2021/12/14 代码执行顺序测试
 */
public class TestExecSequence {
    @Test
    void testExecSequence() {
        boolean flag = false;
        boolean soapResp = false;
        try {
            //flag = true;
            soapResp = flag;
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("执行了Catch");
        }
        System.out.println("执行了Catch之后了么？");
        if (soapResp) {
            System.out.println("服务调用成功");
        } else {
            System.out.println("服务调用失败");
        }
        System.out.println(flag);
    }
}
