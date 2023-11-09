package liuyang.essentials.enums.demos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 网管级别
 * 注：需要与tb_sys_params表中记录（level）值相对应。
 *
 * @author liuyang(wx)
 * @since 2021/10/9
 */
@AllArgsConstructor
@Getter
public enum SysLevelEnum {
    MINISTRY(1, "部"),// 部级网管
    PROVINCE(2, "省"),// 省级网管
    CITY(3, "市");// 市级网管

    private Integer code;
    private String message;
}
