package liuyang.lang.enums.demos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 参考：tb_pdt_task_info task_state字段的注释
 * 其中1，2 状态与 规范 表A.8 state字段规定一致
 *
 * @author liangze
 * @since 2021/2/1
 * @update liuyang(wx) 20210809
 */
@AllArgsConstructor
@Getter
public enum TaskStatusEnum {

    DEFAULT(0, "默认"),
    SUSPEND(1, "暂停"),// SUSPENDED
    RESUMED(2, "恢复"),
    UNDISTRIBUTED(3, "未下发"),
    EXECUTING(4, "执行中"),// RUNNING
    FINISHED(5, "结束"),
    FAILURE(6, "失败"),// 20210927 add
    ;

    private Integer code;
    private String message;
}
