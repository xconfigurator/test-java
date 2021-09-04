package liuyang.tools.excel.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;

/**
 * @author  liuyang
 * @since 2021/2/10
 * https://www.yuque.com/easyexcel/doc/read
 * https://www.bilibili.com/video/BV1fK4y1D7Mu
 */
@Slf4j
public class TestRead {

    private static final String FILE = "D:\\test\\excel\\poi_write_test_huge.xlsx";

    public static void main(String[] args) {
        ExcelReaderBuilder rb = EasyExcel.read();
        rb.autoCloseStream(true);
        rb.file(FILE);
        rb.excelType(ExcelTypeEnum.XLSX);
        rb.sheet("Sheet0");// 若不指定sheet 则会读取所有sheet
        // 不指定泛型
        /*
        rb.registerReadListener(new AnalysisEventListener() {
            @Override
            public void invoke(Object o, AnalysisContext analysisContext) {
                // TODO
                log.info(o.toString());
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                log.info("读取文件结束");
            }
        });
        */
        // 指定泛型
        rb.registerReadListener(new AnalysisEventListener<Map<Integer, String>>() {

            @Override
            public void invoke(Map<Integer, String> integerStringMap, AnalysisContext analysisContext) {
                Set<Integer> keySet = integerStringMap.keySet();
                for (Integer k : keySet) {
                    System.out.print(integerStringMap.get(k) + "\t");
                }
                System.out.println();
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                log.info("读取文件结束");
            }
        });

        ExcelReader reader = rb.build();
        reader.readAll();
        reader.finish();
    }
}
