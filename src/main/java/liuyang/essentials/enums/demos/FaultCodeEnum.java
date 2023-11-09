package liuyang.essentials.enums.demos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by liangze
 * 2017-06-11 18:56
 *
 * 参考：GAT 1365-2017_警用数字集群（PDT）通信系统_网管技术规范（报批稿）20160729_cc.pdf 表C.1错误代码
 */
@AllArgsConstructor
@Getter
public enum FaultCodeEnum {

    UNDEFINED_ERROR(1, "001"),// 未知错误
    TASK_UNFOUNDED(2, "002"),// 相应任务未找到
    BAD_PARAMETER(3, "003"),// 输入参数类型不匹配
    INTERNAL_ERROR(4, "004"),// 内部处理错误，指定的任务无法完成
    // 扩展
    NO_DATA(5, "005"),// TODO 梁泽原来给这个code是4 是不是编错了
    INVALID_TASK(6, "无效的任务");// 情况：上报数据的task_id在任务表中找不到对应信息则视为无效。
    ;

    private Integer code;
    private String message;
}
