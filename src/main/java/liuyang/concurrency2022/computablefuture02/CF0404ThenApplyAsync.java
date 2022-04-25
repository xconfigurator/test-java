package liuyang.concurrency2022.computablefuture02;

import liuyang.concurrency2022.computablefuture.T;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * @author :liuyang(wx)
 * @date :2022/2/21 11:14
 *        2022/4/25 目前并没有实现在另一个线程中进行处理。
 */
public class CF0404ThenApplyAsync {
    public static void main(String[] args) {
        T.printTimeAndThread("小白吃好了");
        T.printTimeAndThread("小白 结账、要求开发票");

        //ExecutorService executorService = Executors.newWorkStealingPool();

        // 两个服务员（貌似在JDK11上有问题。 20220425 后续可以尝试配置Executor试一下）
        CompletableFuture<String> invoice = CompletableFuture.supplyAsync(() -> {
            T.printTimeAndThread("服务员收款 500元");
            T.sleepMillis(1000);
            return "500";
        //}).thenApply(money -> {// Function
        //}, executorService).thenApplyAsync(money -> {// Function // 20220425 指定线程池后未见预期结果
        }).thenApplyAsync(money -> {// Function
            T.printTimeAndThread(String.format("服务员开发票 面额 %s元", money));
            T.sleepMillis(200);
            return String.format("%s元发票", money);
        //}, executorService);// 20220425 指定线程池后未见预期结果
        });

        T.printTimeAndThread("小白 接到朋友的电话，想一起打游戏。");
        T.printTimeAndThread(String.format("小白拿到%s是， 准备回家", invoice.join()));
    }
}
