package liuyang.concurrency2022.essential;

import java.time.LocalTime;

/**
 * yield让出CPU
 *
 * @author :liuyang(wx)
 * @description :
 * @date :2022/2/15 10:34
 */
public class ThreadYield {
    public static void main(String[] args) throws InterruptedException {
        // thread
        for (int i = 0; i < 2; i ++) {
            Thread t = new Runner1();
            t.start();
            //t.join();// 加上join就又成顺序执行了
        }

        // main
        System.out.println(Thread.currentThread().getName() + " : " + LocalTime.now());

    }

    static class Runner1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                // 202310312038 JDK 11正常，但切换为JDK 17报错，暂时注释掉。
                //yield();// yield是thread的方法。貌似拿Runnable接口不好整
            }
        }
    }
}
