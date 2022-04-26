package liuyang.concurrency2022.blockingqueue02_basic;

import liuyang.concurrency2022.computablefuture.T;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 一刻都不想等
 * https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Queue.html#poll()
 *      效果与BlockingQueue的带参数的poll传0效果类似，并且不会抛出InterruptedException
 *      适用场景：一刻都不想等，并且又不一定要求必须拿到的情况下。（路人甲去买烧饼，看见有现成的就买，没有现成的转头就走。）
 *
 */
public class _04_BlockingQueue_poll_0 {
    public static void main(String[] args) {
        BlockingQueue<String> shaobingQueue = new LinkedBlockingQueue<>();

        Thread xiaoBai = new Thread(() -> {
            T.printTimeAndThread("小白 收拾东西，准备开张");
            T.printTimeAndThread("小白 接到电话 往家里跑");
        });

        Thread roadPeopleA = new Thread(() -> {
            T.printTimeAndThread("路人甲 来买烧饼");
            String shaobing = shaobingQueue.poll();// 一刻也不等，并且不会抛出InterruptException
            if (null == shaobing) {
                T.printTimeAndThread("路人甲 没买到烧饼 不等了");
            } else {
                T.printTimeAndThread("路人甲 买到了烧饼: " + shaobing);
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
