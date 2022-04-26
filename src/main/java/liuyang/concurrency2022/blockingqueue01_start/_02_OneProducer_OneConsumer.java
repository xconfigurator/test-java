package liuyang.concurrency2022.blockingqueue01_start;

import liuyang.concurrency2022.completablefuture.T;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 有问题的版本
 *
 * @since 2022/4/25
 */
public class _02_OneProducer_OneConsumer {
    public static void main(String[] args) {
        Queue<String> shaobingQueue = new LinkedList<>();

        // 当日志用（避免System.out.println的同步操作）
        List<String> xiaoBaiMsg = new LinkedList<>();
        List<String> roadPeopleAMsg = new LinkedList<>();// 路人甲 <-- 这翻译，够了！

        Thread xiaoBai = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String tmp = String.format("第%d个烧饼", i + 1);
                shaobingQueue.add(tmp);
                xiaoBaiMsg.add(String.format("%d 小白只做了[%s]", System.currentTimeMillis(), tmp));
            }
        });

        Thread roadPeopleA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                roadPeopleAMsg.add(String.format("%d 路人甲 买到了 [%s]", System.currentTimeMillis(), shaobingQueue.poll()));
            }
        });

        xiaoBai.start();
        roadPeopleA.start();

        try {
            xiaoBai.join();
            roadPeopleA.join();
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
            T.printTimeAndThread("join产生中断" + e.getMessage());
        }

        System.out.println("##### 操作记录：小白");
        System.out.println(xiaoBaiMsg.stream().collect(Collectors.joining("\n")));
        System.out.println("##### 操作记录：路人甲");
        System.out.println(roadPeopleAMsg.stream().collect(Collectors.joining("\n")));
    }
}
