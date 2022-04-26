package liuyang.concurrency2022.blockingqueue01_start;

import liuyang.concurrency2022.completablefuture.T;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 功能1：固定容量
 * 功能2：队列空，取不出来东西。
 * 功能3：队列满，放不进东西。
 * java.util.concurrent.BlockingQueue
 *      https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/BlockingQueue.html
 * java.util.concurrent.LinkedBlockingQueue
 *      https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/LinkedBlockingQueue.html
 * @since 2022/4/25
 */
public class _05_LinkedBlockingQueue_tack {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(4);// 可设置固定大小

        try {
            blockingQueue.take();// 卡住了，队列空，一直等待。满足需求！
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
            T.printTimeAndThread("取元素被中断");
        }
    }
}
