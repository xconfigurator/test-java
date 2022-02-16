package liuyang.lang.enums.demos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by liangze
 * 2021-02-01
 *
 * 参考：GAT 1365-2017_警用数字集群（PDT）通信系统_网管技术规范（报批稿）20160729_cc.pdf 表C.11
 */
@AllArgsConstructor
@Getter
public enum AlmSeverityEnum {

    CRITICAL(1, "紧急告警"),
    MAJOR(2, "重要告警"),
    MINOR(3, "次要告警"),
    NORMAL(4, "一般通知"),
    ;

    private Integer code;
    private String message;
}
