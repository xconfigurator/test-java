package liuyang.tools.excel.easyexcel.easyexcel20231228.dao;

import cn.hutool.core.util.IdUtil;
import com.alibaba.excel.util.ListUtils;
import liuyang.tools.excel.easyexcel.easyexcel20231228.pojo.Employee;

import java.util.Date;
import java.util.List;

/**
 * @author xconf
 * @since 2023/12/28
 */
public class EmployeeDao {

    public List<Employee> data() {
        List<Employee> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setId(IdUtil.getSnowflakeNextId());
            employee.setName("foo" + Math.random());
            employee.setDate(new Date());
            employee.setSalary(Math.random() * 1000);
            list.add(employee);
        }
        return list;
    }
}
