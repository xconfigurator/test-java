package liuyang.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

/**
 * @author xconf
 * @since 2023/10/3
 */
@Slf4j
public class ZooKeeperTest {

    CuratorFramework cf;

    @BeforeEach
    void init() {
        cf = ZooKeeperUtil.cf();
    }

    @DisplayName("不报错就成，证明没有语法错误，但不能说明可以连接上集群（把IP写错，照样可以启动，但直到执行操作时才会抛异常）")
    @Test
    void test202310031410() {
        CuratorFramework cf = ZooKeeperUtil.cf();
        log.info("cf = {}", cf);
    }

    @DisplayName("查询子节点信息")
    @Test
    void test202310031432查询子节点信息() throws Exception {
        //CuratorFramework cf = ZooKeeperUtil.cf();
        log.info("{}", cf.getChildren().forPath("/"));
    }

    @DisplayName("查询节点数据")
    @Test
    void test202310031433查询节点数据() throws Exception {
        //CuratorFramework cf = ZooKeeperUtil.cf();
        log.info("{}", cf.getData().forPath("/zookeeper"));

        if (null == cf.checkExists().forPath("/liuyang")) return;
        log.info("{}", new String(cf.getData().forPath("/liuyang"), StandardCharsets.UTF_8));// 可先从zkCli中执行 create /liuyang; set /liuyang 123; set /liuyang abc // 输出的是ASCII值
    }

    @DisplayName("查")
    @Test
    void test202310031439查() throws Exception {
        String znodePath = "/liuyang2";

        // 若节点不存在会抛异常。
        if (null == cf.checkExists().forPath(znodePath)) {
            log.info("节点{}不存在",znodePath);
            return;
        }

        log.info("{}", new String(cf.getData().forPath(znodePath), StandardCharsets.UTF_8));
    }

    @DisplayName("增")
    @Test
    void test202310031440增() throws Exception {
        //CuratorFramework cf = ZooKeeperUtil.cf();
        cf.create().withMode(CreateMode.PERSISTENT).forPath("/liuyang2", "abc".getBytes());
    }

    @DisplayName("改")
    @Test
    void test202310031450改() throws Exception {
        String znodePath = "/liuyang2";

        // 若节点不存在会抛异常。
        if (null == cf.checkExists().forPath(znodePath)) {
            log.info("节点{}不存在",znodePath);
            return;
        }

        cf.setData().forPath(znodePath, "abcd".getBytes());
    }

    @DisplayName("删")
    @Test
    void test202310031446删() throws Exception {
        cf.delete().forPath("/liuyang2");
    }

    @DisplayName("查看节点（znode）状态")
    @Test
    void test202310031503查看Znode节点是否存在() throws Exception {
        Stat stat = cf.checkExists().forPath("/zookeeper");
        log.info("{}", stat);
    }
}
