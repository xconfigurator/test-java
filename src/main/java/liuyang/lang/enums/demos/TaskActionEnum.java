package liuyang.lang.enums.demos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 参考：GAT 1365-2017_警用数字集群（PDT）通信系统_网管技术规范（报批稿）20160729_cc.pdf 表A.2
 *
 * @author liuyang(wx)
 * @since 2021/8/9
 */
@AllArgsConstructor
@Getter
public enum TaskActionEnum {

    ADD(1, "新增任务"),
    DEL(3, "删除任务"),
    ;

    private Integer code;
    private String message;
}
