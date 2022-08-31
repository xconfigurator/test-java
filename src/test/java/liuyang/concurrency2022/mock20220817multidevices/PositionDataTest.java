package liuyang.concurrency2022.mock20220817multidevices;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author liuyang(wx)
 * @since 2022/8/9
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
@Slf4j
//@ActiveProfiles("dev")
public class PositionDataTest {

    //@Value("${spring.uls.url}")
    //private String ulsUrl;

    //@Autowired
    //DeviceInfoService deviceInfoService;

    private static Map<Integer, String> dicDeviceType = new HashMap<>();
    // TODO POC-蓝牙/POC-GPS如何区分
    static {
        dicDeviceType.put(4, "50");// 蓝牙标签  (业务数据库) 4   (位置数据库)50
        dicDeviceType.put(1, "51");// POC-蓝牙 1  51
        dicDeviceType.put(1, "24");// POC-GPS 1  24
        dicDeviceType.put(6, "60");// UWB标签 6  60
    }

    private static Random random = new Random();

    /*
    模拟的经纬度范围
    蓝牙设备：
    （0.05，0.06）（114.356994912，38.055174113）
    （24.43，0.06）（114.3567149112，38.055174113）
    （24.54，15.54）（114.3567149112，38.0556604113）
    （0.05，15.5）（114.356994912，38.0556604113）
    UWB设备：
    (0,0)(114.3569949112,38.0555174113)
    (24.48,0)(114.3567149112,38.0555184113)
     */

    /*
    // 设备信息必填字段
    PositionAccessDTO dto = new PositionAccessDTO();
    // 必填字段
    private String deviceId; // 设备Id
    private String deviceType;// 设备类型
    private float longitude;// 经度
    private float latitude;// 纬度
    private String height;// 高度
    private String date;// 位置推送时间
    private String extraData;// 扩展字段
     */

    @Test
    public void mockBluetoothData() {
        // 1. 查出蓝牙标签设备
        //List<DeviceInfoDO> deviceInfoDOList = deviceInfoService.list();//TODO

        // 2. 从拼接并模拟
        // TODO
    }

    /*
    private PositionAccessDTO produceBluetoothData(DeviceInfoDO deviceInfoDO) {
        // 2. 拼接蓝牙标签内容
        PositionAccessDTO dto = new PositionAccessDTO();
        // 设备信息必填字段
        PositionAccessDTO dto = new PositionAccessDTO();
        // 必填字段
        //private String deviceId; // 设备Id
        //private String deviceType;// 设备类型
        //private float longitude;// 经度
        //private float latitude;// 纬度
        //private String height;// 高度
        //private String date;// 位置推送时间
        //private String extraData;// 扩展字段

        dto.setDeviceId(deviceInfoDO.getDeviceId());
        dto.setDeviceType(transformDeviceType(deviceInfoDO.getDeviceStyle()));

        return dto;
    }*/


    @Test
    public void mockPocBluetoothData() {
        // TODO

    }

    @Test
    public void mocPocGPSData() {
        // TODO

    }

    @Test
    public void mocUWBData() {
        // TODO

    }

    /*
    @Test
    public void deviceInfoServiceTest() {
        deviceInfoService.list().stream().forEach(System.out::println);
    }
     */

    /*
        由泽阳提供
        蓝牙标签  (业务数据库) 4   (位置数据库)50
        POC-蓝牙 1  51
        POC-GPS 1  24
        UWB标签 6  60
     */
    private String transformDeviceType(Integer deviceStyle) {
        return dicDeviceType.get(deviceStyle);
    }



    // 0 ~ listSize - 1的整型值
    private int getRandomIndex(int listSize) {
        return (int) random.nextInt(listSize); // 0 ~ listSize - 1 正好覆盖List全集合
    }

    @Test
    public void testRandom() {
        List<Integer> data = new LinkedList<>();
        for (int i = 0; i < 10000000; ++i) {
            data.add((int) random.nextInt(10));// 0 ~ 9
            //data.add((int) random.nextInt(10) + 1);// 1 ~ 10
        }
        log.info("max = {}", Collections.max(data));
        log.info("min = {}", Collections.min(data));
    }

    @Test
    public void testList() {
        List<Integer> integers = Arrays.asList(1, 2, 3);

        log.info("integers.get(0) = {}", integers.get(0));
        log.info("integers.get(1) = {}", integers.get(1));
        log.info("integers.get(2) = {}", integers.get(2));
        //log.info("integers.get(3) = {}", integers.get(3));// 下标越界

        // 从List中随机取出一个记录
        for (int i = 0; i < 100; ++i) {
            log.info("random in list = {}", integers.get(getRandomIndex(integers.size())));
        }
    }
}