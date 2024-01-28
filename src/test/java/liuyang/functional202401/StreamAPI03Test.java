package liuyang.functional202401;

import liuyang.functional202203.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 更多用法
 * 视频：https://www.bilibili.com/video/BV1sC4y1K7ET/?p=7&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * 关于中间操作和终止操作的更多的例子
 *
 * @author xconf
 * @since 2024/1/27
 */
@Slf4j
public class StreamAPI03Test {

    private static final User[] arrayOfUsers = {
            User.builder()
                    .id(1L)
                    .username("zhangsan")
                    .name("张 三")
                    .age(30)
                    .enabled(true)
                    .mobile("13000000001")
                    .roles(List.of("ROLE_ADMIN", "ROLE_USER"))
                    .build(),
            User.builder()
                    .id(2L)
                    .username("lisi")
                    .name("李 四")
                    .age(32)
                    .enabled(false)
                    .mobile("13000000002")
                    .roles(List.of("ROLE_ADMIN"))
                    .build(),
            User.builder()
                    .id(3L)
                    .username("wangwu")
                    .name("王 五")
                    .age(41)
                    .enabled(true)
                    .mobile("13000000003")
                    .roles(List.of("ROLE_USER"))
                    .build(),
            User.builder()
                    .id(3L)
                    .username("foo")
                    .name("福 气")
                    .age(18)
                    .enabled(true)
                    .mobile("13000000003")
                    .roles(List.of("ROLE_USER"))
                    .build(),
            User.builder()
                    .id(3L)
                    .username("bar")
                    .name("巴 蜀")
                    .age(19)
                    .enabled(true)
                    .mobile("13000000003")
                    .roles(List.of("ROLE_USER"))
                    .build(), // liuyang 202401280607 最后这个逗号很诡异，加不加都不报错！
    };

    /**
     * 1. 创建流
     * of, builder, empty, ofNullable, generate, concat, 集合.stream()
     *
     * 2. 中间操作
     * filter
     * map, mapToInt, mapToLong, mapToDouble
     * flatMap, flatMapToInt, flatMapToLong, flatMapToDouble
     * mapMulti, mapMultiToInt, mapMultiToLong, mapMultiToDouble
     * parallel, unordered, onClose, sequential
     * distinct, sorted, peek, limit, skip, takeWhile, dropWhile
     * 重点：filter, map, flatMap, distinct, sorted, peek, takeWhile
     *
     * 3. 终止操作(流都是懒加载的，直到明确指定终止操作才实际进行运行)
     * forEach, forEacheOrdered
     * toArray
     * reduce, collect, toList
     * min, max, count
     * anyMatch, nonMatch
     * findFirst, findAny
     * iterator
     */

    /**
     * filter, map,
     */
    @Test
    void test202401271846IntermediateOperation() {
        // 流中前一个元素完整走一遍流水线之后下一个元素才开始走流水线。
        Arrays.stream(arrayOfUsers)
                .filter(user -> user.getAge() > 18)
                .map(user -> user.getName())
                .peek(name -> log.info("{}", name))
                .flatMap(name -> Arrays.stream(name.split(" ")))
                .forEach(System.out::println);
    }

    @DisplayName("takeWhile 过滤，不满足条件立即终止")
    @Test
    void test202401280657() {
        // filter
        List<Integer> collect1 = List.of(1, 2, 3, 4, 5, 6)
                .stream()
                .filter(i -> i > 2)// 遍历流中每个元素
                .collect(Collectors.toList());
        log.info("filter 正序 = {}", collect1);
        // takeWhile
        List<Integer> collect2 = List.of(1, 2, 3, 4, 5, 6)
                .stream()
                .takeWhile(i -> i > 2)// 条件不满足即终止
                .collect(Collectors.toList());
        log.info("takeWhile 正序 = {}", collect2);
        // takeWhile
        List<Integer> collect3 = List.of(6, 5, 4, 3, 2, 1)
                .stream()
                .takeWhile(i -> i > 2)// 条件不满足即终止
                .collect(Collectors.toList());
        log.info("takeWhile 倒序 = {}", collect3);
    }

    @Test
    void test202401280711() {
        // 找出大于15岁的人
        List<User> collect = Arrays.stream(arrayOfUsers).filter(user -> user.getAge() > 15)
                .collect(Collectors.toList());
        log.info("{}", collect);

        // 按角色分组
        Map<List<String>, List<User>> collect1 = Arrays.stream(arrayOfUsers).filter(user -> user.getAge() > 15)
                .collect(Collectors.groupingBy(user -> user.getRoles()));
        log.info("{}", collect1);
    }
}

