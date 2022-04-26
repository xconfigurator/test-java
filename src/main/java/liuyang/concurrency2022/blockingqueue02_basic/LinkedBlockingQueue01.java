package liuyang.concurrency2022.blockingqueue02_basic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/BlockingQueue.html
 *
 * @author :liuyang(wx)
 * @date :2022/2/21 14:40
 */
public class LinkedBlockingQueue01 {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(3);
        // docs
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/BlockingQueue.html
        // put/take

        try {
            blockingQueue.take();
            // 死等：       take()                     put()
            // 等一会：     poll(long, TimeUnit)       offer(E, long, TimeUnit)
            // 一刻都不等：  poll()                     offer(E)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
