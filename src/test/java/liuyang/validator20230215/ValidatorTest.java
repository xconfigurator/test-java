package liuyang.validator20230215;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class ValidatorTest {

    @Test
    void demo() {
        User user = new User();
        List<String> validate = ValidationUtil.validate(user);
        log.info(validate.toString());
    }


}
