package liuyang.lang.enums.demos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 参考：GAT 1365-2017_警用数字集群（PDT）通信系统_网管技术规范（报批稿）20160729_cc.pdf 表A.2
 *
 * @author liangze
 * @since 2021/2/1
 */
@AllArgsConstructor
@Getter
public enum TaskPeriodicityEnum {

    PERIODIC(1, "周期性任务"),
    SINGLE(2, "单次任务"),
    REALTIME(3, "实时任务"),
    ;

    private Integer code;
    private String message;
}
