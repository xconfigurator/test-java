package liuyang.tools.excel.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 简化使用版本
 * @author  liuyang
 * @since 2021/2/10
 * https://www.yuque.com/easyexcel/doc/read
 * https://www.bilibili.com/video/BV1fK4y1D7Mu 17:19
 */
@Slf4j
public class TestReadSimple {

    private static final String FILE = "D:\\test\\excel\\poi_write_test_huge.xlsx";

    public static void main(String[] args) {
        List<Map<Integer, String>> list = new LinkedList<>();
        EasyExcel.read(FILE).sheet("Sheet0").registerReadListener(new AnalysisEventListener<Map<Integer, String>>() {

            @Override
            public void invoke(Map<Integer, String> integerStringMap, AnalysisContext analysisContext) {
                list.add(integerStringMap);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                log.info("读取文件结束");
                // list.stream().forEach(System.out::println);
            }
        }).doRead();// 别忘了这个doRead()

        list.stream().forEach(System.out::println);
        log.info("list.size() = " + list.size());
    }
}
