package liuyang.tools.excel.easyexcel.easyexcel20231228;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import liuyang.tools.excel.easyexcel.easyexcel20231228.dao.EmployeeDao;
import liuyang.tools.excel.easyexcel.easyexcel20231228.pojo.Employee;
import liuyang.tools.excel.easyexcel.easyexcel20231228.util.TestFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 最简单的读写示例
 * 参考：https://www.bilibili.com/video/BV1bF411D7M8/?spm_id_from=333.1007.tianma.3-1-7.click&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * @author xconf
 * @since 2023/11/8
 *        2023/12/28
 */
@Slf4j
public class EasyExcel01Test {

    @Test
    void testPath() {
        String path = EasyExcel01Test.class.getResource("/").getPath();
        log.info(path);
        String pathWithoutClass = EasyExcel01Test.class.getResource("/").getPath().replace("test-classes/", "");
        log.info(pathWithoutClass);
        log.info("{}", TestFileUtil.getPath());
    }

    /**
     * TestFileUtil
     * Employee
     * EmployeeDao
     */
    @DisplayName("简单写入")
    @Test
    void testWrite01() {
        // 视频从开始到54:25
        // 数据
        EmployeeDao dao = new EmployeeDao();
        List<Employee> data = dao.data();
        log.info("{}", data);

        // 文件名
        String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";

        // 写
        EasyExcel.write(fileName, Employee.class).sheet("模板").doWrite(data);
    }

    /**
     * EmployeeListener
     */
    @DisplayName("简单读取")
    @Test
    void testWrite02() {
        // 视频从54:25 到 1:04:05
        // 文件名
        String fileName = TestFileUtil.getPath() + "simpleWrite1703755035747.xlsx";

        // 读
        EasyExcel.read(fileName, Employee.class, new PageReadListener<Employee>(dataList -> {
            for (Employee employee : dataList) {
                log.info("{}", JSON.toJSONString(employee));
                //System.out.println(employee);
            }
        })).sheet().doRead();
    }
}
