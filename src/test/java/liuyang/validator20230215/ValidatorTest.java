package liuyang.validator20230215;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class ValidatorTest {

    @Test
    void demo01() {
        User user = new User();
        List<String> validate = ValidationUtil.validate(user);
        log.info(validate.toString());
    }

    @Test
    void validNotBean() {
        // 仅做示例，真正使用场景需要结合AOP，而并不是示例里面演示的那样用。
        FooService fooService = new FooService();
        fooService.getByName(null);
        fooService.getByName("liuyang");
    }
}
