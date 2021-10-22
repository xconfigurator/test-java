package liuyang.enums.demos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * GAT 1365-2017_警用数字集群（PDT）通信系统_网管技术规范（报批稿）20160729_cc.pdf
 * 表B.89 拓扑上报操作输入参数
 * 注：
 * 目前来看只有拓扑上报的字段是opCode，其他类似的字段都是opType，见OpTypeEnum。
 * 但实际动作及取值都类似，这里严格按照规范命名，方便核对。
 *
 * @author liuyang(wx)
 * @since 2021/10/21
 */
@AllArgsConstructor
@Getter
public enum OpCodeEnum {
    ADD(1, "增加"),
    REMOVE(2, "移除"),
    UPDATE(3, "更新"),
    ;

    private Integer code;
    private String message;
}
