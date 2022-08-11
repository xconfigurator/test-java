package liuyang.tools.excel.easyexcel202208111703;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author liuyang(wx)
 * @since 2022/8/11
 */
@Data
@ToString
public class LongitudeLatitudeFloatDO {
    @ExcelProperty(index = 0)
    float longitude;
    @ExcelProperty(index = 1)
    float latitude;
    @ExcelProperty(index = 2)
    float x;
    @ExcelProperty(index = 3)
    float y;
}
