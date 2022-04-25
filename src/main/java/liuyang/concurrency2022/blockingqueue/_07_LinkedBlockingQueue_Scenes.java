package liuyang.concurrency2022.blockingqueue;

import liuyang.concurrency2022.computablefuture.T;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者-消费者
 */
public class _07_LinkedBlockingQueue_Scenes {
    public static void main(String[] args) {
        BlockingQueue<String> shaobingQueue = new LinkedBlockingQueue<>(4);

        List<String> xiaoBaiMsg = new LinkedList<>();
        List<String> chefAMsg = new LinkedList<>();
        List<String> roadPeopleAMsg = new LinkedList<>();
        List<String> roadPeopleBMsg = new LinkedList<>();

        // producer 1
        Thread xiaoBai = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String shaobing = String.format("小白的 第%d个烧饼", i + 1);
                try {
                    shaobingQueue.put(shaobing);
                } catch (InterruptedException e) {
                    T.printTimeAndThread("小白被中断" + e.getMessage());
                }
                xiaoBaiMsg.add(String.format("%d 小白只做了 [%s]", System.currentTimeMillis(), shaobing));
            }
        });

        // producer 2
        Thread chefA = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                // TODO
                String shaobing = String.format("厨师A的 第%d个烧饼", i + 1);
                try {
                    shaobingQueue.put(shaobing);
                } catch (InterruptedException e) {
                    T.printTimeAndThread("厨师A被中断" + e.getMessage());
                }
                chefAMsg.add(String.format("%d 厨师A制作了 [%s]", System.currentTimeMillis(), shaobing));
            }
        });

        // consumer 1
        // TODO

        // consumer 2


    }
}
