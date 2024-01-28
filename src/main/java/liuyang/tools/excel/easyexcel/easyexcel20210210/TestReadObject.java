package liuyang.tools.excel.easyexcel.easyexcel20210210;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * 读取成一个对象
 * @author  liuyang
 * @since 2021/2/11
 * https://www.yuque.com/easyexcel/doc/read
 * https://www.bilibili.com/video/BV1fK4y1D7Mu 23:39
 */
@Slf4j
public class TestReadObject {

    private static final String FILE = "D:\\test\\excel\\poi_write_test_huge.xlsx"; // 读出65536行
    // private static final String FILE = "D:\\test\\excel\\poi_write_test_huge_head.xlsx"; // 读出65537行 ok
    // private static final String FILE = "D:\\test\\excel\\test.xlsx";

    public static void main(String[] args) {
        List<ExcelDataObj> list = new LinkedList<>();
        EasyExcel.read(FILE)
                .head(ExcelDataObj.class) // 映射对象必须填写的！
                .sheet() // Sheet0可以不写
                .registerReadListener(new AnalysisEventListener<ExcelDataObj>() {
                    @Override
                    public void invoke(ExcelDataObj excelDataObj, AnalysisContext analysisContext) {
                        list.add(excelDataObj);
                    }

                    @Override
                    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                        log.info("读取文件结束");
                    }
                }).doRead();
        // list.stream().forEach(System.out::println);
        System.out.println(list.get(0));
        log.info("list.size() = " + list.size());
    }
}

// 不能写在这里 因为在这里不能声明成public class
/*
@Data
@ToString
class ExcelDataObj {
    @ExcelProperty(index = 0) // @ExcelProperty("ID") 如果有标题用这个, 支持中文。
    private String id;
    @ExcelProperty(index = 1) // @ExcelProperty("姓名") 如果有标题用这个, 支持中文。
    private String name;
    @ExcelProperty(index = 2)
    private String email;
    @ExcelProperty(index = 3)
    private String prop3;
    @ExcelProperty(index = 4)
    private String prop4;
    @ExcelProperty(index = 5)
    private String prop5;
    @ExcelProperty(index = 6)
    private String prop6;
    @ExcelProperty(index = 7)
    private String prop7;
    @ExcelProperty(index = 8)
    private String prop8;
    @ExcelProperty(index = 9)
    private String prop9;
}
 */