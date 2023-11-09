package liuyang.essentials;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author liuyang
 * @date 2021/8/26
 */
public class HelloTryCatchFinally {
    private static final Logger log = LoggerFactory.getLogger(HelloTryCatchFinally.class);
    public static boolean testFunctionNormal() {
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
        //log.info("try/catch之后");// unreachable 因为return
    }

    public static boolean testFunctionAbnormal() {
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
        //log.info("try/catch之后");// unreachable 因为return
    }

    /*
    public static boolean testProcedureNormal() {
        try {
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            log.debug("Response = " + flag);
        }
        log.info("try/catch之后");// unreachable
    }
    */

    public static void testProcedureNormal() {
        try {
            log.info("try");
        } catch (Exception e) {
            log.info("catch");
        } finally {
            log.info("finally");
        }
        log.info("after try/catch block");
    }

    public static void testProcedureAbnormal() {
        try {
            log.info("try 中抛异常");
            throw new RuntimeException("还是故意的");
        } catch (Exception e) {
            log.info("catch");
        } finally {
            log.info("finally");
        }
        log.info("after try/catch block");
    }

}