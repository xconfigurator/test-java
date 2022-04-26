package liuyang.concurrency2022.blockingqueue01_start;

import liuyang.concurrency2022.computablefuture.T;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @since 2022/4/25
 */
public class _06_LinkedBlockingQueue_put {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(1);

        try {
            blockingQueue.put("one");
            T.printTimeAndThread("one被放进去了");

            blockingQueue.put("two");// 卡住了，队列满，无法放入。满足需求！
            T.printTimeAndThread("one被放进去了");
        } catch (InterruptedException e) {
            T.printTimeAndThread("取元素被中断");
        }

    }
}
