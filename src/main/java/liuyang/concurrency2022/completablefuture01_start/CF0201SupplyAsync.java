package liuyang.concurrency2022.completablefuture01_start;

import liuyang.concurrency2022.completablefuture.T;

import java.util.concurrent.CompletableFuture;

/**
 * 厨师 服务员两个线程， supplyAsync的不太优雅的实现。
 * @author :liuyang(wx)
 * @date :2022/2/21 9:33
 */
public class CF0201SupplyAsync {
    public static void main(String[] args) {
        T.printTimeAndThread("小白进入餐厅");
        T.printTimeAndThread("小白点了  番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            T.printTimeAndThread("厨师炒菜");
            T.sleepMillis(200);
            CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
                T.printTimeAndThread("服务员打饭");
                T.sleepMillis(200);
                return " + 米饭";
            });
            return "番茄炒蛋" + cf2.join();// 演示异步任务的连接。 使用thenCompose更优雅，见CF0202ThenCompose.java
        });

        T.printTimeAndThread("小白在打王者");
        T.printTimeAndThread(String.format("%s 好了，小白开吃", cf1.join()));
    }
}
