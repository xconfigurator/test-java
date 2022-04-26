package liuyang.concurrency2022.interrupt;

import liuyang.concurrency2022.completablefuture.T;

/**
 *
 * @since 2022/4/25
 */
public class _04_beforehandInterrupt {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();

        try {
            T.printTimeAndThread("开始睡眠");// 省掉了睡眠
            Thread.sleep(1000);// 省掉了睡眠
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
            T.printTimeAndThread("发生中断");
        }
        T.printTimeAndThread("结束睡眠");
    }
}
