package liuyang.lang.enums.demos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 参考：
 *  GAT 1365-2017_警用数字集群（PDT）通信系统_网管技术规范（报批稿）20160729_cc.pdf 表A.2
 *  PDT系统网管技术规范补充规定20180306.pdf 表E.2
 * 仅含标准文本中定义的任务类型
 *
 * @author liangze
 * @since 2021/2/1
 * @upate liuyang(wx) 2021/8/9
 */
@AllArgsConstructor
@Getter
public enum TaskTypeEnum {

    ALARMREPORT(1, "告警任务"),
    ALARMSTAT(2, "告警统计任务"),
    TOPREPORT(3, "实时拓扑任务"),
    PEFREPORT(4, "性能指标任务"),
    //USERREPORT(5, "移动台信息任务"),// 移动台信息任务 来自："技术规范"最初规定
    USERREPORT(5, "用户信息上报、移动台设备信息上报、移动台使用信息上报任务"),// 用户信息上报、移动台设备信息上报、移动台使用信息上报任务 来自：“补充规定”修改。
    DEVREPORT(6, "设备信息任务"),
    GROUPREPORT(7, "通话组信息上报、组织架构信息上报任务"),// 通话组信息上报、组织架构信息上报任务 来自：“补充规定”新增。
    ;

    private Integer code;
    private String message;
}
