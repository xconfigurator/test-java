package liuyang.essentials.math;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import liuyang.tools.excel.easyexcel202208111703.LongitudeLatitudeBigDecimalDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author liuyang(wx)
 * @since 2022/8/10
 */
@Slf4j
class BigDecimal202208Test {

    private static final Random random = new Random();

    // 需求：模拟经纬度范围
    /*
    模拟的经纬度范围
    蓝牙设备：
    （0.05，0.06）（114.356994912，38.055174113）// southwest
    （24.43，0.06）（114.3567149112，38.055174113）// southeast
    （24.54，15.54）（114.3567149112，38.0556604113）// northeast
    （0.05，15.5）（114.356994912，38.0556604113）// northwest
    UWB设备：
    (0,0)(114.3569949112,38.0555174113)
    (24.48,0)(114.3567149112,38.0555184113)
     */
    // 经纬度
    final static BigDecimal northeastLongitude = new BigDecimal("114.3567149112");
    final static BigDecimal northeastLatitude = new BigDecimal("38.0556604113");

    final static BigDecimal northwestLongitude = new BigDecimal("114.356994912");
    final static BigDecimal northwestLatitude = new BigDecimal("38.0556604113");

    final static BigDecimal southeastLongitude = new BigDecimal("114.3567149112");
    final static BigDecimal southeastLatitude = new BigDecimal("38.055174113");

    final static BigDecimal southwestLongitude = new BigDecimal("114.356994912");
    final static BigDecimal southwestLatitude = new BigDecimal("38.055174113");

    // 坐标轴（原定定在了西南）
    final static BigDecimal northeastX = new BigDecimal("24.54");
    final static BigDecimal northeastY = new BigDecimal("15.54");

    final static BigDecimal northwestX = new BigDecimal("0.05");
    final static BigDecimal northwestY = new BigDecimal("15.5");

    final static BigDecimal southeastX = new BigDecimal("24.43");
    final static BigDecimal southeastY = new BigDecimal("0.06");

    final static BigDecimal southwestX = new BigDecimal("0.05");
    final static BigDecimal southwestY = new BigDecimal("0.06");

    @Test
    void genMocLLAdnCorrespondingXYToExcel() {
        final int DATA_NUM = 10000;
        final String FILE_WRITE = "E:\\data_" + DATA_NUM + "points_BigDecimal_Gaussian_" + System.currentTimeMillis() +".xlsx";

        List<LongitudeLatitudeBigDecimalDO> list = new LinkedList<>();
        for (int i = 0; i < DATA_NUM; ++i) {
            LongitudeLatitudeBigDecimalDO record = new LongitudeLatitudeBigDecimalDO();
            // uniformly
            //double randomNumX = random.nextDouble();
            //double randomNumY = random.nextDouble();

            // Gaussian
            double randomNumX = random.nextGaussian();
            double randomNumY = random.nextGaussian();

            BigDecimal pointLongitude = randomRange(southeastLongitude, southwestLongitude, randomNumX);// 经度
            BigDecimal pointLatitude = randomRange(southeastLatitude, northeastLatitude, randomNumY);// 纬度
            BigDecimal pointX = randomRange(southwestX, southeastX, randomNumX);
            BigDecimal pointY = randomRange(southwestY, northwestY, randomNumY);

            record.setLongitude(pointLongitude);
            record.setLatitude(pointLatitude);
            record.setX(pointX);
            record.setY(pointY);

            list.add(record);
        }

        // EasyExcel.write(pathName).head(ExcelDataObj.class).excelType(ExcelTypeEnum.XLSX).sheet().doWrite(list);
        EasyExcel
                .write(FILE_WRITE)
                .head(LongitudeLatitudeBigDecimalDO.class)
                .excelType(ExcelTypeEnum.XLSX)
                .sheet()
                .doWrite(list);
    }
    public static BigDecimal randomRange(BigDecimal lowerBound, BigDecimal upperBound, double randomNum) {
        BigDecimal delta = upperBound.subtract(lowerBound).abs();
        BigDecimal randomDelta = delta.multiply(new BigDecimal(randomNum));// 这个随机值的精度无关紧要
        return lowerBound.add(randomDelta);
    }

    @RepeatedTest(4)
    void testMathRandom() {
        //private float longitude;// 经度
        //private float latitude;// 纬度

        // 使用float这个精度真的好吗？
        log.info("{}", Math.random());
    }

    @RepeatedTest(4)
    void testRandomNextGaussian() {
        log.info("{}", random.nextGaussian());
    }


}