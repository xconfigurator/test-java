package liuyang.essentials.enums.demos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 与TaskTypeEnum对应，但包含实际实现的细分类型，供任务模块内部实现使用。
 *
 * @author liuyang(wx)
 * @since 2021/8/9
 */
@AllArgsConstructor
@Getter
@Deprecated
public enum TaskTypeClassEnum {

    // 告警任务
    ALARMREPORT(1, ""),
    // 告警统计任务
    ALARMSTAT(2, "com.hbfec.pdt.modules.soap.province.service.taskcallee.task.periodic.AlmStatTask"),
    // 实时拓扑任务
    TOPREPORT(3, ""),
    // 性能指标任务
    PEFREPORT(4, "com.hbfec.pdt.modules.soap.province.service.taskcallee.task.periodic.PefReportTask"),
    // 移动台信息任务 来自："技术规范"最初规定
    //USERREPORT(5, "移动台信息任务"),
    // 用户信息上报、移动台设备信息上报、移动台使用信息上报任务 来自：“补充规定”修改。
    USERREPORT(5, ""),
    // 实现：移动台设备信息上报、移动台使用信息上报任务
    // 注："51"并不是规范中的编号类型，是实现过程中为了方便标识，5标识规范中的大类，1为规范中type=1的周期任务。
    USERREPORT_PERIODIC(51, "com.hbfec.pdt.modules.soap.province.service.taskcallee.task.periodic.MSDevReportTask"),
    USERREPORT_REALTIME(53, ""),// 实时用户信息上报任务
    // 设备信息任务
    DEVREPORT(6, ""),
    // 通话组信息上报、组织架构信息上报任务 来自：“补充规定”新增。
    GROUPREPORT(7, ""),
    ;

    private Integer code;
    private String message;
}
