package liuyang.essentials.enums.demos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 以下文档中描述opType编码及含义均一致：
 * GAT 1365-2017_警用数字集群（PDT）通信系统_网管技术规范（报批稿）20160729_cc.pdf
 *      表C.2 用户信息参数
 * PDT系统网管技术规范补充规定20180306.pdf
 *      表69 组织架构信息数据
 *      表67 通话组信息数据
 *
 * @author liuyang(wx)
 * @since 2021/10/21
 */
@AllArgsConstructor
@Getter
public enum OpTypeEnum {
    ADD(1, "增加"),
    DELETE(2, "删除"),
    MODIFY(3, "修改"),
    ;
    private Integer code;
    private String message;
}
