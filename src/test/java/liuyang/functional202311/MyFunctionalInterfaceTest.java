package liuyang.functional202311;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author xconf
 * @since 2023/11/2
 */
@Slf4j
public class MyFunctionalInterfaceTest {

    @Test
    void test() {
        MyFunctionalInterface myFunctionalInterface = () -> {
            log.info("hello");
        };
        myFunctionalInterface.foo();
    }
}