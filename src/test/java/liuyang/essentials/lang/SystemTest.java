package liuyang.essentials.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 1. in out err
 * 2. System.getProperties()
 * 3. System.currentTimeMillis()
 * 4. System.arraycopy()
 *
 * @author xconf
 * @since 2023/11/9
 */
@Slf4j
public class SystemTest {
    // 查看方式1： 直接通道输出流
    @Test
    void test202311090825() {
        Properties properties = System.getProperties();
        properties.list(System.out);
    }

    // 处理方式2 变成set
    @Test
    void test202311090835() {
        Set<Map.Entry<Object, Object>> entries = System.getProperties().entrySet();
        entries.forEach(System.out::println);
    }

    /**
     * 找感兴趣的属性
     * java.version
     * java.home        Java安装目录
     * os.name
     * os.version
     * user.name        用户账户
     * user.home        用户主目录
     * user.dir         用户的当前工作目录
     */
    @Test
    void test202311090844() {
        Set<Map.Entry<Object, Object>> entries = System.getProperties().entrySet();
        // 筛选
        entries.stream().filter(entry -> "java.home".equals(entry.getKey())).forEach(System.out::println);
        entries.stream().filter(entry -> "java.version".equals(entry.getKey())).forEach(System.out::println);
        entries.stream().filter(entry -> "user.home".equals(entry.getKey())).forEach(System.out::println);
        entries.stream().filter(entry -> "user.dir".equals(entry.getKey())).forEach(System.out::println);
        entries.stream().filter(entry -> "os.name".equals(entry.getKey())).forEach(System.out::println);
        entries.stream().filter(entry -> "os.version".equals(entry.getKey())).forEach(System.out::println);
        // 取单个
        log.info("{}", System.getProperty("java.home"));
        log.info("{}", System.getProperty("java.version"));
        log.info("{}", System.getProperty("user.home"));
        log.info("{}", System.getProperty("user.dir"));
        log.info("{}", System.getProperty("os.name"));
        log.info("{}", System.getProperty("os.version"));
    }

    @Test
    void test202311090924() {
        log.info("{}", System.currentTimeMillis());
    }

    @Test
    void test202311090908() {
        int[] src = IntStream.rangeClosed(1, 10).toArray();
        int[] dest = new int[10];
        System.arraycopy(src, 0, dest, 0, 10);
        for (int i : dest) {
            System.out.println(i);
        }
    }
}
