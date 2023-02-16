package liuyang.validator20230215;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 演示在非Spring MVC环境中使用BeanValidation
 * @since 2023/2/16
 */
public class ValidationUtil {
    private static Validator validator;
    private static Validator failFastValidator;
    private static ExecutableValidator executableValidator;// 用于校验入参和返回值。
    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        failFastValidator = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
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

}
