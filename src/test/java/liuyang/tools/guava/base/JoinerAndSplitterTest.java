package liuyang.tools.guava.base;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua?p=5&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 *  Joiner/Splitter
 *  下划线和驼峰互转
 *  Lists
 *  Ints
 *  Multiset
 *  HashMultimap
 *  ImmutableList
 *  Preconditions
 *
 * @author xconf
 * @since 2023/11/8
 */
@Slf4j
public class JoinerAndSplitterTest {

    // https://guava.dev/releases/snapshot-jre/api/docs/com/google/common/base/Joiner.html
    // 把集合通过指定分隔符连接成字符串
    @Test
    void testJoiner01() {
        // 最简使用
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        log.info("{}", Joiner.on(",").join(list1));
    }
    @Test
    void testJoiner02() {
        // 处理null
        List<String> list2 = Arrays.asList("1", "2", "3", null);
        log.info("{}",Joiner.on(",").skipNulls().join(list2));
        log.info("{}",Joiner.on(",").useForNull("foo").join(list2));
    }

    // 对比使用JDK8+ Stream API也可以完成类似的效果
    @Test
    void testJoinerJDK8StreamAPI() {
        List<String> list = Arrays.asList("1", "2", "3", null);
        String collect = list.stream().filter(StringUtils::isNotBlank).collect(Collectors.joining(","));
        log.info("Stream API: {}", collect);
    }

    // https://guava.dev/releases/snapshot-jre/api/docs/com/google/common/base/Splitter.html
    // 通过指定的分隔符把字符串转换为集合
    @Test
    void testSplitter01() {
        String str = "1, 2, 3";
        List<String> strings = Splitter.on(",").splitToList(str);
        strings.forEach(System.out::println);
    }

    @Test
    void testSplitter02() {
        // 含空字符串
        String str = "a, b, , c, c";// 不行!!!!!!
        Splitter.on(",").omitEmptyStrings().trimResults().splitToList(str).forEach(System.out::println);// 所以omitEmptyStrings和trimResults联用是一个好办法。
        Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str).forEach(System.out::println);// 貌似顺序没关系。

        // 解释为啥还要加个trimResults
        System.out.println("解释为啥还要加个trimResults:");
        str = "a, b, , c, c";// 不ok
        Splitter.on(",").omitEmptyStrings().splitToList(str).forEach(System.out::println);
        System.out.println("###################");
        str = "a, b,, c, c";// ok
        Splitter.on(",").omitEmptyStrings().splitToList(str).forEach(System.out::println);

    }
}
