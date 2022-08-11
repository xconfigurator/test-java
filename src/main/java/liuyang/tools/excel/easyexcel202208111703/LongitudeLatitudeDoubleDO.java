package liuyang.tools.excel.easyexcel202208111703;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author liuyang(wx)
 * @since 2022/8/11
 */
@Data
public class LongitudeLatitudeDoubleDO {
    @ExcelProperty(index = 0)
    Double longitude;
    @ExcelProperty(index = 1)
    Double latitude;
    @ExcelProperty(index = 2)
    Double x;
    @ExcelProperty(index = 3)
    Double y;
}
