package liuyang.concurrency2022.blockingqueue02_basic;

import liuyang.concurrency2022.completablefuture.T;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 场景：小白正准备开张，路人甲也准备买东西，此时小白接到电话“我方水晶正在被攻击”......
 *
 * https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/BlockingQueue.html
 * https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/BlockingQueue.html#take()
 *
 * 问题：
 * take 无限等待
 * 如何设置等待超时？ 答：poll。 见_02_BlockingQueue_poll
 * @since 2022/4/26
 */
public class _01_BlockingQueue_take {
    public static void main(String[] args) {
        BlockingQueue<String> shaobingQueue = new LinkedBlockingQueue<>();

        Thread xiaoBai = new Thread(() -> {
            T.printTimeAndThread("小白 收拾东西，准备开张");
            T.printTimeAndThread("小白 接到电话 往家里跑");
        });

        Thread roadPeopleA = new Thread(() -> {
            T.printTimeAndThread("路人甲 来买烧饼");
            try {
                String shaobing = shaobingQueue.take();
                T.printTimeAndThread("路人甲 买到了烧饼: " + shaobing);
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
