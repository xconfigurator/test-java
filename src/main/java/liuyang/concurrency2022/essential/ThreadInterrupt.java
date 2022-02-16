package liuyang.concurrency2022.essential;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * 演示打断其他线程执行
 *
 * @author :liuyang(wx)
 * @description :
 * @date :2022/2/15 10:59
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        // thread
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ":" + LocalTime.now());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    // 只能在这里捕捉。因为是Override了Rnnable接口的run方法，而run方法没有声明throws InterruptedException。
                    e.printStackTrace();
                    // 如果不退出，则仍然会永远执行下去。
                    // 注：虽然比stop好点，但这仍然不是停止运行线程的最好办法。
                    // interrupt方式至少还给了程序在catch中（为啥不是finally？看一下finally的测试块）执行资源回收的机会。stop则类似kill -9
                    //return; // ok 20220215
                    break;// ok 20220215
                } finally {
                    // 问题：执行时机，取消下面语句的注释查看结果。
                    // System.out.println("被打断或发生异常，执行资源回收。");
                }
            }
        });
        t.start();

        // main
        TimeUnit.SECONDS.sleep(5);

        // main打断thread执行
        t.interrupt();
    }
}
