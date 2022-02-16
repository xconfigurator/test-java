package liuyang.concurrency2022.essential;

/**
 * 线程的优先级
 *
 * @author :liuyang(wx)
 * @description :
 * @date :2022/2/15 12:07
 */
public class ThreadPriority {
    public static void main(String[] args) {
        // 优先级越高得到的CPU时间片就会越多。
        //Thread.MIN_PRIORITY
        //Thread.MAX_PRIORITY
        //Thread.NORM_PRIORITY

        // getPriority
        // setPriority

        Thread t1 = new Thread(() -> fun());
        Thread t2 = new Thread(() -> fun());
        Thread t3 = new Thread(() -> fun());
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }

    static void fun() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
