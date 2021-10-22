package liuyang.enums.demos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 依据：
 * 表tb_pdt_task_info.direction
 * 表tb_pdt_task_compl_info.direction
 *
 * @author liuyang(wx)
 * @since 2021/9/23
 */
@AllArgsConstructor
@Getter
public enum TaskDirectionEnum {

    SEND(0, "向下发任务"),
    RECV(1, "接收上级任务")
    ;

    private Integer code;
    private String message;
}
