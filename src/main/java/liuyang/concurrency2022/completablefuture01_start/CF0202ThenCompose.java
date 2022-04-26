package liuyang.concurrency2022.completablefuture01_start;

import liuyang.concurrency2022.completablefuture.T;

import java.util.concurrent.CompletableFuture;

/**
 * 厨师 服务员两个线程， thenCompose的实现。
 *
 * @author :liuyang(wx)
 * @date :2022/2/21 9:39
 */
public class CF0202ThenCompose {
    public static void main(String[] args) {
        T.printTimeAndThread("小白进入餐厅");
        T.printTimeAndThread("小白点了  番茄炒蛋 + 一碗米饭");

        // 关键点在异步任务的连接。
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {// Supply
            // https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/CompletableFuture.html#supplyAsync(java.util.function.Supplier)
            // https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/function/Supplier.html
            T.printTimeAndThread("厨师炒菜");
            T.sleepMillis(200);
            return "番茄炒蛋";
        }).thenCompose(dish -> CompletableFuture.supplyAsync(() -> {// Function
            // https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/CompletableFuture.html#thenCompose(java.util.function.Function)
            // https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/function/Function.html
            T.printTimeAndThread("服务员打饭");
            T.sleepMillis(200);
            return dish + " + 米饭";
        }));

        T.printTimeAndThread("小白在打王者");
        T.printTimeAndThread(String.format("%s 好了，小白开吃", cf1.join()));
    }
}
