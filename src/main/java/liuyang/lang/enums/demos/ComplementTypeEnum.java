package liuyang.lang.enums.demos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 补报类型
 * 参考：GAT 1365-2017_警用数字集群（PDT）通信系统_网管技术规范（报批稿）20160729_cc.pdf 表A.71等补报操作请求参数表
 *
 * @author liuyang(wx)
 * @since 2021/9/24
 */
@AllArgsConstructor
@Getter
public enum ComplementTypeEnum {

    IGNORE(1, "忽略重复数据"),
    OVERRIDE(2, "覆盖重复数据")
    ;

    private Integer code;
    private String message;
}
