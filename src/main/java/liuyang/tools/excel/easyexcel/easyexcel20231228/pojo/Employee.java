package liuyang.tools.excel.easyexcel.easyexcel20231228.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xconf
 * @since 2023/12/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @ExcelProperty("员工编号")
    private Long id;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("入职日期")
    private Date date;
    @ExcelProperty("薪资")
    private Double salary;
}
