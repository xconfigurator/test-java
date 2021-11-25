package liuyang.test20210915;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author liuyang
 * @date 2021/9/28
 */
@Slf4j
public class ClassTest {
    @Test
    void testClassName() {
        log.info("this.getClass().getName() = " + this.getClass().getName());
        log.info("this.getClass().getCanonicalName() = " + this.getClass().getCanonicalName());
        log.info("this.getClass().getSimpleName() = " + this.getClass().getSimpleName());
        log.info("this.getClass().getTypeName() = " + this.getClass().getTypeName());
        //log.info("this.getClass().getPackageName() = " + this.getClass().getPackageName());
    }

    // 大多数情况下getName和getCanonicalName没什么不同。但存在两个特例，比较一下。
    @Test
    void testClassName2() {
        int[] arr = {1, 2, 3};
        log.info(arr.getClass().getName());
        log.info(arr.getClass().getCanonicalName());

        class A {}
        A a = new A();
        log.info(a.getClass().getName());
        log.info(a.getClass().getCanonicalName());
    }
}
