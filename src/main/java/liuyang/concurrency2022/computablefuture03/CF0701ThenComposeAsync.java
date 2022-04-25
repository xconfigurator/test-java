package liuyang.concurrency2022.computablefuture03;

import liuyang.concurrency2022.computablefuture.T;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示thenCompose和thenComposeAsync的区别
 */
public class CF0701ThenComposeAsync {
    public static void main(String[] args) {
        T.printTimeAndThread("小白进入餐厅");
        T.printTimeAndThread("小白点了  番茄炒蛋 + 一碗米饭");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 关键点在异步任务的连接。
        // 在使用supplyAsync, thenComposeAsync, return CompletableFuture.
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {// Supply
            // https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/CompletableFuture.html#supplyAsync(java.util.function.Supplier)
            // https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/function/Supplier.html
            T.printTimeAndThread("厨师炒菜");
            T.sleepMillis(2000);
            return "番茄炒蛋";
        //}).thenCompose(dish -> {
        }, executorService).thenComposeAsync(dish -> {
            T.printTimeAndThread("服务员A准备打饭，但是被领导叫走，打饭交接给服务员B");

            return CompletableFuture.supplyAsync(() -> {// Function
                // https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/CompletableFuture.html#thenCompose(java.util.function.Function)
                // https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/function/Function.html
                T.printTimeAndThread("服务员打饭");
                T.sleepMillis(2000);
                return dish + " + 米饭";
                //});// 注意这个使用默认ForkJoinPool
                }, executorService);// 这个使用定制的线程池，比较效果。观察到，只有在用newFixedThreadPool，且线程数为2的时候，才能看到与视频中相同的结论。调成4就略有不同。
        }, executorService);

        T.printTimeAndThread("小白在打王者");
        T.printTimeAndThread(String.format("%s 好了，小白开吃", cf1.join()));

        executorService.shutdown();
    }
}
