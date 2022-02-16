package liuyang.concurrency2022.essential.sync;

import java.util.concurrent.TimeUnit;

/**
 * 线程同步
 * 解法：锁
 * synchronized
 * 参考视频： 05_线程同步 06_线程同步_2
 *
 * @author :liuyang(wx)
 * @description :
 * @date :2022/2/15 13:17
 */
public class ThreadSync {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Incrementor()).start();
        }
    }

    static class Lock {}

    static class CriticalRegion {
        // 临界区
        public static int num = 0;

        //public static synchronized void inc() {// 仅在这个位置加锁不能满足要求
        public static void inc() {
            num++;
        }
    }

    static class Incrementor implements Runnable {
        // 访问临界区
        @Override
        public void run() {
            // 在访问临界区的整个过程要加锁
            // 这个操作行为类似select for update
            synchronized (Lock.class) {
                System.out.println(Thread.currentThread().getName() + " : 访问临界区的num = " + CriticalRegion.num);// 第一个访问临界区的位置
                try {
                    TimeUnit.SECONDS.sleep(1);// “睡觉的时候关上门（Lock）”
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                CriticalRegion.inc();// 第二个访问临界区的位置
            }
        }
    }
}
