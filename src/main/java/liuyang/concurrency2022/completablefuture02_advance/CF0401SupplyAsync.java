package liuyang.concurrency2022.completablefuture02_advance;

import liuyang.concurrency2022.completablefuture.T;

import java.util.concurrent.CompletableFuture;

/**
 * thenApply        任务后置处理
 * applyToEither    获取最先完成的任务
 * exceptionally    处理异常
 *
 * @author :liuyang(wx)
 * @date :2022/2/21 10:38
 */
public class CF0401SupplyAsync {
    public static void main(String[] args) {
        T.printTimeAndThread("小白吃好了");
        T.printTimeAndThread("小白 结账、要求开发票");

        CompletableFuture<String> invoice = CompletableFuture.supplyAsync(() -> {
            // 问题：如果收款和开发票的服务员不是同一个人该怎么模拟？
            T.printTimeAndThread("服务员收款 500元");
            T.sleepMillis(100);
            T.printTimeAndThread("服务员开发票 面额 500元");
            T.sleepMillis(200);
            return "500元发票";
        });

        T.printTimeAndThread("小白 接到朋友的电话，想一起打游戏。");
        T.printTimeAndThread(String.format("小白拿到%s是， 准备回家", invoice.join()));
    }
}
