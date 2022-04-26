package liuyang.concurrency2022.interrupt;

import liuyang.concurrency2022.completablefuture.T;

import java.util.Random;

/**
 * 模拟两辆车过“独木桥”
 * @since 20220425
 *
 */
public class _02_TowCarCrossBridge {
    public static void main(String[] args) {
        Thread carTwo = new Thread(() -> {
            T.printTimeAndThread("卡丁2号 准备过桥");
            T.printTimeAndThread("发现1号在过，开始等待");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
                T.printTimeAndThread("卡丁2号 开始过桥");
            }
            T.printTimeAndThread("卡丁2号 过桥完毕");
        });

        Thread carOne = new Thread(() -> {
            T.printTimeAndThread("卡丁1号 开始过桥");
            int timeSpend = new Random().nextInt(500) + 1000;
            T.sleepMillis(timeSpend);
            T.printTimeAndThread("卡丁1号 过桥完毕 耗时：" + timeSpend);

            // 重点：
            System.out.println(carTwo.getState());// TIMED_WAITING 线程在sleep时的状态
            carTwo.interrupt();
        });

        carOne.start();
        System.out.println(carOne.getState());// RUNNABLE
        carTwo.start();
        System.out.println(carTwo.getState());// RUNNABLE 以为可以看到线程在sleep时的状态，但实际上这里看不到sleep时的状态
        carTwo.interrupt();// 没有sleep，调用interrupt会怎样。答：会被忽略。当然如果想要处理中断也是可以的。需要编码。
        System.out.println(carTwo.getState());// RUNNABLE 以为可以看到线程在sleep时的状态，但实际上这里看不到sleep时的状态
    }
}
