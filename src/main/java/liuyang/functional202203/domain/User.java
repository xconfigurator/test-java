package liuyang.functional202203.domain;

import lombok.*;
import java.io.Serializable;
import java.util.List;

/**
 * 这是一个删减版的对象，去掉了JPA，完整版的可查看test-spring-boot-env下的那个。
 */
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增长 ID，唯一标识
     */
    @Getter
    @Setter
    private Long id;

    /**
     * 用户名
     */
    @Getter
    @Setter
    private String username;

    /**
     * 手机号
     */
    @Getter
    @Setter
    private String mobile;

    /**
     * 姓名
     */
    @Getter
    @Setter
    private String name;

    /**
     * 是否激活，默认激活
     */
    @Getter
    @Setter
    @Builder.Default
    private boolean enabled = true;

    /**
     * 密码哈希
     */
    @Getter
    @Setter
    private String password;

    /**
     * 电邮地址
     */
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private int age;

    @Getter
    public List<String> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        return id != null && id.equals(((User) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                "}";
    }
}