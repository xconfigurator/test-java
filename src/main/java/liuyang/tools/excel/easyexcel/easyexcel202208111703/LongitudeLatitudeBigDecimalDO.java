package liuyang.tools.excel.easyexcel.easyexcel202208111703;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liuyang(wx)
 * @since 2022/8/11
 */
@Data
public class LongitudeLatitudeBigDecimalDO {
    @ExcelProperty(index = 0)
    BigDecimal longitude;
    @ExcelProperty(index = 1)
    BigDecimal latitude;
    @ExcelProperty(index = 2)
    BigDecimal x;
    @ExcelProperty(index = 3)
    BigDecimal y;
}
