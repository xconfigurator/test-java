package liuyang.validator20230215;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author xconf
 * @since 2023/2/16
 *
 * 常用校验的约束注解
 * @Null
 * @NotNull   注: 除了@NotEmpty和@NotBlank之外，建议在其他验证注解前加上@NotNull或@NotBlank，因为其他的注解不判null
 * @NotEmpty 备注是的集合 size > 0 或字符串 != null &&  !""
 * @NotBlank != null && !"" & !"  "
 * @AssertTrue  被注释的元素必须是true
 * @AssertFalse 被注释的元素必须是false
 * @Min(value)  被注释的元素必须是一个数字，>= (注意并不校验非空，符合指责单一原则)
 * @Max(value)  被注释的元素必须是一个数字, <=
 *  Hibernate还提供了@Range（min = , max = ）
 * @DecimalMin(value)
 * @DecimalMax(value)
 * @Size(max, min)              被注释的元素大小必须在指定的范围内。
 * @Digits(integer, fraction)   被注释的元素必须是一个数字，其值必须在可以接受的范围内。
 * @Past            被注释的元素必须是一个过去的日期
 * @PastOrPresent
 * @Future          被注释的元素必须是一个将来的日期
 * @NegativeOrZero  <= 0
 * @Pattern(value)  被注释的元素必须符合指定的正则表达式
 *  e.g. 手机号码验证正则表达式 @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$")
 * @Email           被注释的元素必须是电子邮箱地址
 * @URL
 * 要看所有可用的注解：
 *  可以参见
 *      javax.validation.constraints.*
 *      org.hibernate.validator.constraints.*
 *
 *
 *
 */
public class User {
    private Long id;
    @NotNull
    private String name;
    private Integer age;
    private String email;
    private String phone;
    private LocalDateTime birthDay;
    private String peronalPage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDateTime birthDay) {
        this.birthDay = birthDay;
    }

    public String getPeronalPage() {
        return peronalPage;
    }

    public void setPeronalPage(String peronalPage) {
        this.peronalPage = peronalPage;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDay=" + birthDay +
                ", peronalPage='" + peronalPage + '\'' +
                '}';
    }
}
