package liuyang.tools.excel.easyexcel.easyexcel20210210;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.util.Date;

@Data
@ToString
public class ExcelDataObj { // 注意必须是public class
    /*
    @ExcelProperty("昵称") // @ExcelProperty("ID") 如果有标题用这个, 支持中文。
    private String nick;
    @ExcelProperty("加入时间") // @ExcelProperty("姓名") 如果有标题用这个, 支持中文。
    private Date date;
    @ExcelProperty("签名")
    private String text;
     */
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