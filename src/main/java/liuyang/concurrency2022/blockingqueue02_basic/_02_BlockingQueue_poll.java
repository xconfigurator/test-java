package liuyang.concurrency2022.blockingqueue02_basic;

import liuyang.concurrency2022.completablefuture.T;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 指定等待时间
 * https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/BlockingQueue.html#poll(long,java.util.concurrent.TimeUnit)
 */
public class _02_BlockingQueue_poll {
    public static void main(String[] args) {
        BlockingQueue<String> shaobingQueue = new LinkedBlockingQueue<>();

        Thread xiaoBai = new Thread(() -> {
            T.printTimeAndThread("小白 收拾东西，准备开张");
            T.printTimeAndThread("小白 接到电话 往家里跑");
        });

        Thread roadPeopleA = new Thread(() -> {
            T.printTimeAndThread("路人甲 来买烧饼");
            try {
                //String shaobing = shaobingQueue.take();
                String shaobing = shaobingQueue.poll(2, TimeUnit.SECONDS);// 最多等2秒。
                // 注意这样是有可能取到null的。建议明确对返回值进行判断！参考：_03_BlockingQueue_poll_return
                T.printTimeAndThread("路人甲 买到了烧饼: " + shaobing);// 1650937195858		14		Thread-1		路人甲 买到了烧饼: null
            } catch (InterruptedException e) {
                T.printTimeAndThread("路人甲 被中断" + e.getMessage());
            }
        });

        xiaoBai.start();
        try {
            TimeUnit.SECONDS.sleep(2);// 先等小白收拾一下，再让路人甲出场。
        } catch (InterruptedException e) {
            T.printTimeAndThread("主线程 被中断" + e.getMessage());
        }
        roadPeopleA.start();
        // 叩问灵魂：不吃小白的烧饼会死么？......
    }
}
