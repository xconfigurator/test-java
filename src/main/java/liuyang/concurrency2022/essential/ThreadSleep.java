package liuyang.concurrency2022.essential;

import java.util.concurrent.TimeUnit;

/**
 * sleep 和 InterruptedException
 *
 * @author :liuyang(wx)
 * @description :
 * @date :2022/2/15 10:31
 */
public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        // Thread.sleep(10) --> TimeUnit.MILLISECONDS.sleep(10);
        // Thread       https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Thread.html
        // TimeUnit     https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/TimeUnit.html
        // TimeUnit.sleep() 说明： Performs a Thread.sleep using this time unit.
        // TimeUnit     since JDK 1.5
        System.out.println("before sleep.");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("after sleep.");
    }
}
