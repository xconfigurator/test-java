package liuyang.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author xconf
 * @since 2023/10/3
 */
public class ZooKeeperUtil {
    public static CuratorFramework cf() {
        // 重试规则
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(2000, 2);

        CuratorFramework cf = CuratorFrameworkFactory.builder()
                .connectString("192.168.42.128:2181,192.168.42.128:2182,192.168.42.128:2183")
                .retryPolicy(retryPolicy)
                .build();
        cf.start();
        return cf;
    }
}
