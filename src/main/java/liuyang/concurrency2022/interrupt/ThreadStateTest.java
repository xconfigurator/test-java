package liuyang.concurrency2022.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @since 20220425
 */
public class ThreadStateTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        System.out.println("1 - " + thread.getState());// NEW
        thread.start();
        System.out.println("2 - " + thread.getState());// RUNNABLE
        TimeUnit.SECONDS.sleep(1);
        System.out.println("3 - " + thread.getState());// TERMINATED

        // 注：直接抛InterruptedException是不好的，因为如果不处理，则这个线程就直接挂了，除非那就是你的目的。
    }
}
