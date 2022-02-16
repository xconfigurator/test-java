package liuyang.concurrency2022.essential;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * 停止线程的方法演示
 * 注：不要使用stop方法。
 *
 * @author :liuyang(wx)
 * @description :
 * @date :2022/2/15 11:20
 */
public class ThreadStopGracefully {
    public static void main(String[] args) throws InterruptedException {
        // thread
        // Thread t = new Runner1();
        Runner1 t = new Runner1();
        t.start();
        Runner2 r2 = new Runner2();
        new Thread(r2).start();

        //  main
        TimeUnit.SECONDS.sleep(6);
        // 停止执行
        t.flag = false;// 也可以提供一个shutDown方法，来改变这个值。这里为了强调使用这个标记。
        r2.flag = false;

        // main
        System.out.println(Thread.currentThread().getName() + " isAlive = " + Thread.currentThread().isAlive());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("main exit");
    }

    static class Runner1 extends Thread {

        public boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                fun();
            }
        }
    }

    static class Runner2 implements Runnable {
        public boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                fun();
            }
        }
    }

    static void fun() {
        System.out.println(Thread.currentThread().getName() + " : " + LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
