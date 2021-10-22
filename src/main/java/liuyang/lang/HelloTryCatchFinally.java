package liuyang.lang;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuyang
 * @date 2021/8/26
 */
@Slf4j
public class HelloTryCatchFinally {
    public static boolean testProcedureNormal() {
        boolean flag = true;
        try {
            flag = true;
            return flag;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            flag = false;
            return flag;
        } finally {
            log.debug("Response = " + flag);
        }
    }

    public static boolean testPeocedureAbnormal () {
        boolean flag = true;
        try {
            throw new RuntimeException("故意的");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            flag = false;
            return flag;
        } finally {
            log.debug("Response = " + flag);
        }
    }
}
