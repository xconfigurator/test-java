package liuyang.tools.excel.easyexcel.easyexcel20210210;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * 复制Excel内容（纯属为了练习）
 * @author  liuyang
 * @since 2021/2/10
 * https://www.yuque.com/easyexcel/doc/read
 * https://www.bilibili.com/video/BV1fK4y1D7Mu 17:19
 */
@Slf4j
public class TestWriteCopy {
    private static final String FILE_READ = "D:\\test\\excel\\poi_write_test_huge_head.xlsx";
    private static final String FILE_WRITE = "D:\\test\\excel\\poi_write_test_huge_head_copy.xlsx";

    public static void main(String[] args) {
        write(FILE_WRITE, read(FILE_READ));
        /*
        List<ExcelDataObj> list = read(FILE_READ);
        write(FILE_WRITE, list);
         */
    }

    private static List<ExcelDataObj> read(String pathName) {
        List<ExcelDataObj> list = new LinkedList<>();
        EasyExcel.read(pathName).head(ExcelDataObj.class).sheet().registerReadListener(new AnalysisEventListener<ExcelDataObj>() {
            @Override
            public void invoke(ExcelDataObj excelDataObj, AnalysisContext analysisContext) {
                list.add(excelDataObj);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                log.info("文件读取结束");
            }
        }).doRead();
        return list;
    }

    private static void write(String pathName, List<ExcelDataObj> list) {
        EasyExcel.write(pathName).head(ExcelDataObj.class).excelType(ExcelTypeEnum.XLSX).sheet().doWrite(list);
    }
}
