package liuyang.concurrency2022.blockingqueue02_basic;

import liuyang.concurrency2022.completablefuture.T;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 判断poll超时的返回值null
 *
 * @since 2022/4/26
 */
public class _03_BlockingQueue_poll_return {
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
                //T.printTimeAndThread("路人甲 买到了烧饼: " + shaobing);// 1650937195858		14		Thread-1		路人甲 买到了烧饼: null
                // 注：利用返回值null
                // 查看https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/BlockingQueue.html#put(E)
                // 可知，BlockingQueue的put方法是不允许容器中被放入null的，故可以使用这个null作为返回值，明确判断行为
                if (null == shaobing) {
                    T.printTimeAndThread("路人甲 没买到烧饼 不等了");
                } else {
                    T.printTimeAndThread("路人甲 买到了烧饼: " + shaobing);
                }
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
