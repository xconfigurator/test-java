package liuyang.concurrency2022.essential;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * join
 * 相当于顺序执行了
 *
 * @author :liuyang(wx)
 * @description :
 * @date :2022/2/15 10:34
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        // threads
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName() + " : " + j);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
            t.join();
        }

        // main
        System.out.println(Thread.currentThread().getName() + " : "+ LocalTime.now());
    }
}
