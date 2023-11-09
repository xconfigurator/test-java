package liuyang.essentials.lang;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import liuyang.tools.excel.easyexcel202208111703.LongitudeLatitudeDoubleDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @since 20220809
 */
@Slf4j
class Double202208Test {

    @Test
    void testDouble() {
        log.info("Double MAX_VALUE = {}", Double.MAX_VALUE);
        log.info("Double MIN_VALUE = {}", Double.MIN_VALUE);
    }

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
    final static double northeastLongitude = 114.3567149112;
    final static double northeastLatitude = 38.0556604113;

    final static double northwestLongitude = 114.356994912;
    final static double northwestLatitude = 38.0556604113;

    final static double southeastLongitude = 114.3567149112;
    final static double southeastLatitude = 38.055174113;

    final static double southwestLongitude = 114.356994912;
    final static double southwestLatitude = 38.055174113;

    // 坐标轴（原定定在了西南）
    final static double northeastX = 24.54;
    final static double northeastY = 15.54;

    final static double northwestX = 0.05;
    final static double northwestY = 15.5;

    final static double southeastX = 24.43;
    final static double southeastY = 0.06;

    final static double southwestX = 0.05;
    final static double southwestY = 0.06;

    // UWB
    /*
    UWB设备：
    (0,0)(114.3569949112,38.0555174113)
    (24.48,0)(114.3567149112,38.0555184113)
     */
    final static double uwbALongitude = 114.3569949112;
    final static double uwbALatitude = 38.0555174113;
    final static double uwbBLongitude = 114.3567149112;
    final static double uwbBLatitude = 38.0555184113;

    final static double uwbAX = 0.0;
    final static double uwbAY = 0.0;
    final static double uwbBX = 24.48;
    final static double uwbBY = 0.0;


    @Test
    void genMocLLAdnCorrespondingXYToExcel() {
        final int DATA_NUM = 10000;
        final String FILE_WRITE = "E:\\data_" + DATA_NUM + "points_double_Uniformly" + System.currentTimeMillis() +".xlsx";

        List<LongitudeLatitudeDoubleDO> list = new LinkedList<>();
        for (int i = 0; i < DATA_NUM; ++i) {
            LongitudeLatitudeDoubleDO record = new LongitudeLatitudeDoubleDO();
            // uniformly
            double randomNumX = random.nextDouble();
            double randomNumY = random.nextDouble();

            // Gaussian
            //float randomNumX = (float) random.nextGaussian();
            //float randomNumY = (float) random.nextGaussian();

            double pointLongitude = randomRange(southeastLongitude, southwestLongitude, randomNumX);// 经度
            double pointLatitude = randomRange(southeastLatitude, northeastLatitude, randomNumY);// 纬度
            double pointX = randomRange(southwestX, southeastX, randomNumX);
            double pointY = randomRange(southwestY, northwestY, randomNumY);

            record.setLongitude(pointLongitude);
            record.setLatitude(pointLatitude);
            record.setX(pointX);
            record.setY(pointY);

            list.add(record);
        }

        // EasyExcel.write(pathName).head(ExcelDataObj.class).excelType(ExcelTypeEnum.XLSX).sheet().doWrite(list);
        EasyExcel
                .write(FILE_WRITE)
                .head(LongitudeLatitudeDoubleDO.class)
                .excelType(ExcelTypeEnum.XLSX)
                .sheet()
                .doWrite(list);
    }

    @RepeatedTest(50)
    void genMocLLAndCorrespondingXY() {
        // uniformly
        //float randomNumX = random.nextFloat();
        //float randomNumY = random.nextFloat();

        // Gaussian
        double randomNumX = random.nextGaussian();
        double randomNumY = random.nextGaussian();

        double pointLongitude = randomRange(southeastLongitude, southwestLongitude, randomNumX);// 经度
        double pointLatitude = randomRange(southeastLatitude, northeastLatitude, randomNumY);// 纬度
        double pointX = randomRange(southwestX, southeastX, randomNumX);
        double pointY = randomRange(southwestY, northwestY, randomNumY);

        // double的输出格式字符串也是%f
        System.out.printf("%.9f\t%.9f\t%.9f\t%.9f\n", pointLongitude, pointLatitude, pointX, pointY);
    }

    public static double randomRange(double lowerBound, double upperBound, double randomNum) {
        double delta = Math.abs(upperBound - lowerBound);
        double randomDelta = delta * randomNum;
        return lowerBound + randomDelta;
    }
}
