package liuyang.validator20230215;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 演示在非Spring MVC环境中使用BeanValidation
 *
 * @since 2023/2/16
 */
public class ValidationUtil {
    private static Validator validator;// Validator是线程安全的
    private static Validator failFastValidator;
    private static ExecutableValidator executableValidator;// 用于非Bean情况下校验入参和返回值。
    static {
        // 视频参考：https://www.bilibili.com/video/BV17i4y157Ah?p=6&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        // 视频参考：https://www.bilibili.com/video/BV17i4y157Ah/?p=14&vd_source=8bd7b24b38e3e12c558d839b352b32f4
        failFastValidator = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
        // 视频参考：https://www.bilibili.com/video/BV17i4y157Ah?p=15&vd_source=8bd7b24b38e3e12c558d839b352b32f4
        executableValidator = validator.forExecutables();
    }

    public static List<String> validate(User user) {
        Set<ConstraintViolation<User>> validateSet = validator.validate(user);
        List<String> info = validateSet.stream().map(v ->
                "属性: " + v.getPropertyPath()
                        + ", 属性值：" + v.getInvalidValue()
                        + ", 校验不通过的提示信息：" + v.getMessage()
                        + ", 消息模板（EL被替换之前）:" + v.getMessageTemplate()).collect(Collectors.toList());
        return info;
    }

    public static List<String> validateFailFast(User user) {
        Set<ConstraintViolation<User>> validateSet = failFastValidator.validate(user);
        List<String> info = validateSet.stream().map(v ->
                "属性: " + v.getPropertyPath()
                        + ", 属性值：" + v.getInvalidValue()
                        + ", 校验不通过的提示信息：" + v.getMessage()
                        + ", 消息模板（EL被替换之前）:" + v.getMessageTemplate()).collect(Collectors.toList());
        return info;
    }
    public static <T> List<String> validateNotBean(T object, Method method, Object[] parameterValues, Class<?>... groups) {
        Set<ConstraintViolation<T>> validateSet = executableValidator.validateParameters(object, method, parameterValues, groups);
        List<String> info = validateSet.stream().map(v ->
                "属性: " + v.getPropertyPath()
                        + ", 属性值：" + v.getInvalidValue()
                        + ", 校验不通过的提示信息：" + v.getMessage()
                        + ", 消息模板（EL被替换之前）:" + v.getMessageTemplate()).collect(Collectors.toList());
        return info;
    }
}
