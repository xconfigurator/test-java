package liuyang.essentials.lang;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import liuyang.tools.excel.easyexcel.easyexcel202208111703.LongitudeLatitudeFloatDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author liuyang(wx)
 * @since 2022/8/11
 */
@Slf4j
public class Float202208Test {
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
    final static float northeastLongitude = 114.3567149112f;
    final static float northeastLatitude = 38.0556604113f;

    final static float northwestLongitude = 114.356994912f;
    final static  float northwestLatitude = 38.0556604113f;

    final static  float southeastLongitude = 114.3567149112f;
    final static  float southeastLatitude = 38.055174113f;

    final static  float southwestLongitude = 114.356994912f;
    final static  float southwestLatitude = 38.055174113f;

    // 坐标轴（原定定在了西南）
    final static  float northeastX = 24.54f;
    final static  float northeastY = 15.54f;

    final static  float northwestX = 0.05f;
    final static  float northwestY = 15.5f;

    final static  float southeastX = 24.43f;
    final static  float southeastY = 0.06f;

    final static  float southwestX = 0.05f;
    final static  float southwestY = 0.06f;

    @Test
    void testNextFloat() {
        float deltaLongitude = northeastLongitude - northwestLongitude;
        float deltaX = northeastX - northwestX;
        log.info("deltaLongitude = {}, deltaX = {}", deltaLongitude, deltaX);
        log.info("abs deltaLongitude = {}, abs deltaX = {}", Math.abs(deltaLongitude), Math.abs(deltaX));
    }

    @Test
    void genMocLLAdnCorrespondingXYToExcel() {
        final int DATA_NUM = 10000;
        final String FILE_WRITE = "E:\\data_" + DATA_NUM + "points_float_Uniformly" + System.currentTimeMillis() +".xlsx";

        List<LongitudeLatitudeFloatDO> list = new LinkedList<>();
        for (int i = 0; i < DATA_NUM; ++i) {
            LongitudeLatitudeFloatDO record = new LongitudeLatitudeFloatDO();
            // uniformly
            float randomNumX = random.nextFloat();
            float randomNumY = random.nextFloat();

            // Gaussian
            //float randomNumX = (float) random.nextGaussian();
            //float randomNumY = (float) random.nextGaussian();

            float pointLongitude = randomRange(southeastLongitude, southwestLongitude, randomNumX);// 经度
            float pointLatitude = randomRange(southeastLatitude, northeastLatitude, randomNumY);// 纬度
            float pointX = randomRange(southwestX, southeastX, randomNumX);
            float pointY = randomRange(southwestY, northwestY, randomNumY);

            record.setLongitude(pointLongitude);
            record.setLatitude(pointLatitude);
            record.setX(pointX);
            record.setY(pointY);

            list.add(record);
        }

        // EasyExcel.write(pathName).head(ExcelDataObj.class).excelType(ExcelTypeEnum.XLSX).sheet().doWrite(list);
        EasyExcel
                .write(FILE_WRITE)
                .head(LongitudeLatitudeFloatDO.class)
                .excelType(ExcelTypeEnum.XLSX)
                .sheet()
                .doWrite(list);
    }

    // 202208111646
    @RepeatedTest(50)
    void genMocLLAndCorrespondingXY() {
        // uniformly
        //float randomNumX = random.nextFloat();
        //float randomNumY = random.nextFloat();

        // Gaussian
        float randomNumX = (float) random.nextGaussian();
        float randomNumY = (float) random.nextGaussian();

        float pointLongitude = randomRange(southeastLongitude, southwestLongitude, randomNumX);// 经度
        float pointLatitude = randomRange(southeastLatitude, northeastLatitude, randomNumY);// 纬度
        float pointX = randomRange(southwestX, southeastX, randomNumX);
        float pointY = randomRange(southwestY, northwestY, randomNumY);

        System.out.printf("%.9f\t%.9f\t%.9f\t%.9f\n", pointLongitude, pointLatitude, pointX, pointY);
    }

    // 随机数外提版本
    public static float randomRange(float lowerBound, float upperBound, float randomNum) {
        float delta = Math.abs(upperBound - lowerBound);
        float randomDelta = delta * randomNum;
        return lowerBound + randomDelta;
    }

    /*
    https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Random.html#nextInt()
    nextDouble()
    Returns the next pseudorandom, uniformly distributed double value between 0.0 and 1.0 from this random number generator's sequence.
    */
    public static float randomRange(float lowerBound, float upperBound) {
        float delta = Math.abs(upperBound - lowerBound);
        float randomDelta = delta * (float) random.nextDouble();
        return lowerBound + randomDelta;
    }

    /*
    https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Random.html#nextInt()
    nextGaussian()
    Returns the next pseudorandom, Gaussian ("normally") distributed double value with mean 0.0 and standard deviation 1.0 from this random number generator's sequence.
    */
    public static float randomRangeGaussian(float lowerBound, float upperBound) {
        float delta = Math.abs(upperBound - lowerBound);
        float randomDelta = delta * (float) random.nextGaussian();
        return lowerBound + randomDelta;
    }
}
