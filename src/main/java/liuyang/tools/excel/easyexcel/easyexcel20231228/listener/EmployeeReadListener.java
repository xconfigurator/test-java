package liuyang.tools.excel.easyexcel.easyexcel20231228.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import liuyang.tools.excel.easyexcel.easyexcel20231228.pojo.Employee;

/**
 * @author xconf
 * @since 2023/12/28
 */
public class EmployeeReadListener implements ReadListener<Employee> {

    // 读每行的时候都会调用。
    @Override
    public void invoke(Employee employee, AnalysisContext analysisContext) {
        //
    }

    // 读完整个excel之后会调用这个方法。
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //
    }
}
