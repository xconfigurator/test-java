package liuyang.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author liuyang
 * @date 2021/8/26
 */
@Slf4j
public class HelloTryCatchFinallyTest {
    @Test
    void testNormal() {
        log.info("caller resp = {}", HelloTryCatchFinally.testFunctionNormal());
    }

    @Test
    void testAbnormal() {
        log.info("caller resp = {}", HelloTryCatchFinally.testFunctionAbnormal());
    }

    @Test
    void testNoramlProcecure() {
        HelloTryCatchFinally.testProcedureNormal();
    }
    @Test
    void testAbnromalProcedure() {
        HelloTryCatchFinally.testProcedureAbnormal();
    }
}