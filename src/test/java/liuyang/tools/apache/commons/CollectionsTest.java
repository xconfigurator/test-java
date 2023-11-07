package liuyang.tools.apache.commons;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua/?p=3&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * 非空判断
 * 并，交，差
 *
 * @author xconf
 * @since 2023/11/8
 */
@Slf4j
public class CollectionsTest {

    @DisplayName("非空判断")
    @Test
    void test202311080532() {
        Assertions.assertTrue(CollectionUtils.isEmpty(Collections.emptyList()));
        Assertions.assertTrue(MapUtils.isEmpty(new HashMap<>()));
    }

    @DisplayName("并、交、差")
    @Test
    void test202311080533() {
        // 并
        Assertions.assertIterableEquals(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                CollectionUtils.union(Arrays.asList(1, 2, 3, 4), Arrays.asList(4, 5, 6, 7)));
        // 交
        Assertions.assertIterableEquals(
                Arrays.asList(4),
                CollectionUtils.intersection(Arrays.asList(1, 2, 3, 4), Arrays.asList(4, 5, 6, 7)));

        // 差
        Assertions.assertIterableEquals(
                Arrays.asList(1, 2, 3),
                CollectionUtils.subtract(Arrays.asList(1, 2, 3, 4), Arrays.asList(4, 5, 6, 7)));
    }
}
