package liuyang.enums.demos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 参考：
 * GAT 1365-2017_警用数字集群（PDT）通信系统_网管技术规范（报批稿）20160729_cc.pdf
 * 表A.8 更改任务状态操作输入参数
 *
 * @author liuyang(wx)
 * @since 2021/9/23
 */
@AllArgsConstructor
@Getter
public enum TaskChangeStatusEnum {

    SUSPEND(1, "暂停"),
    RESUMED(2, "恢复"),
    ;

    private Integer code;
    private String message;
}
