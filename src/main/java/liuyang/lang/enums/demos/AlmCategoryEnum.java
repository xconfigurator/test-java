package liuyang.lang.enums.demos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by liangze
 * 2021-02-01
 *
 * 参考：GAT 1365-2017_警用数字集群（PDT）通信系统_网管技术规范（报批稿）20160729_cc.pdf 表C.10
 */
@AllArgsConstructor
@Getter
public enum AlmCategoryEnum {

    COMMUNICATION(1, "通信告警"),
    SOFTWARE(2, "软件告警"),
    ENVIRONMENT(3, "环境告警"),
    QOS(4, "QoS告警"),
    EQUIPMENT(5, "设备告警"),
    NMS(6, "网管告警"),
    ;

    private Integer code;
    private String message;
}
