package liuyang.concurrency2022.completablefuture02_advance;

import liuyang.concurrency2022.completablefuture.T;

import java.util.concurrent.CompletableFuture;

/**
 * @author :liuyang(wx)
 * @date :2022/2/21 11:08
 */
public class CF0403ThenApply {
    public static void main(String[] args) {
        T.printTimeAndThread("小白吃好了");
        T.printTimeAndThread("小白 结账、要求开发票");

        // 一个服务员
        CompletableFuture<String> invoice = CompletableFuture.supplyAsync(() -> {
            T.printTimeAndThread("服务员收款 500元");
            T.sleepMillis(100);
            return "500";
        }).thenApply(money -> {// Function
           T.printTimeAndThread(String.format("服务员开发票 面额 %s元", money));
           T.sleepMillis(200);
           return String.format("%s元发票", money);
        });

        T.printTimeAndThread("小白 接到朋友的电话，想一起打游戏。");
        T.printTimeAndThread(String.format("小白拿到%s是， 准备回家", invoice.join()));
    }
}
