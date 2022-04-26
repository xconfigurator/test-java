package liuyang.concurrency2022.blockingqueue_start;

import liuyang.concurrency2022.computablefuture.T;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 * 生产者-消费者 (一个可用版本1)
 *
 * @since 2022/4/26
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
        Thread roadPeopleA = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String shaobing = null;
                try {
                    shaobing = shaobingQueue.take();
                } catch (InterruptedException e) {
                    T.printTimeAndThread("路人甲被中断" + e.getMessage());
                }
                roadPeopleAMsg.add(String.format("%d 路人甲 买到了[%s]", System.currentTimeMillis(), shaobing));
            }
        });

        // consumer 2
        Thread roadPeopleB = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String shaobing = null;
                try {
                    shaobing = shaobingQueue.take();
                } catch (InterruptedException e) {
                    T.printTimeAndThread("路人乙被中断" + e.getMessage());
                }
                roadPeopleBMsg.add(String.format("%d 路人乙 买到了[%s]", System.currentTimeMillis(), shaobing));
            }
        });

        xiaoBai.start();
        chefA.start();
        roadPeopleA.start();
        roadPeopleB.start();

        try {
            xiaoBai.join();
            chefA.join();
            roadPeopleA.join();
            roadPeopleB.join();
        } catch (InterruptedException e) {
            T.printTimeAndThread("join 产生中断" + e.getMessage());
        }

        showLog(xiaoBaiMsg);
        showLog(chefAMsg);
        showLog(roadPeopleAMsg);
        showLog(roadPeopleBMsg);
    }

    private static void showLog(List<String> msg) {
        System.out.println("------------------------------");
        System.out.println(msg.stream().collect(Collectors.joining("\n")));
    }
}
