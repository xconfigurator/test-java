package liuyang.validator20230215;

import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author xconf
 * @since 2023/12/29
 */
@Slf4j
public class FooService {

    // 非Bean入参校验示例
    // 实际使用场景需要结合AOP，并不是直接这么用的。
    public String getByName(@NotNull String name) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[1];
        String methodName = stackTraceElement.getMethodName();// getByName
        Method declaredMethod = null;
        try {
            declaredMethod = this.getClass().getDeclaredMethod(methodName, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> validatedInfo = ValidationUtil.validateNotBean(this, declaredMethod, new Object[]{name});
        log.info("{}", validatedInfo);
        return "OK";
    }
}
