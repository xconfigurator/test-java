package liuyang.concurrency2022.interrupt;

import liuyang.concurrency2022.computablefuture.T;

/**
 * 线程中处理中断的示例
 * 一般情况下，运行态的线程收到中断信号后会忽略，除非主动处理。
 *      检测：
 *          public boolean isInterrupted()
 *          public static boolean interrupted()
 *
 * 被中断一次就向左开一米
 *
 * @since 2022/04/25
 */
public class _03_interrupt {
    public static void main(String[] args) {
        Thread carOne = new Thread(() -> {
            long startMills = System.currentTimeMillis();
            while (System.currentTimeMillis() - startMills < 3) {
                //if (Thread.currentThread().isInterrupted()) {// 不会复位标记
                if (Thread.interrupted()) {// Thread.interrupted()会把标记位复位
                    T.printTimeAndThread("向左开1米######");
                } else {
                    T.printTimeAndThread("向前开1米");
                }
            }
        });

        carOne.start();

        T.sleepMillis(1);
        carOne.interrupt();
    }
}
