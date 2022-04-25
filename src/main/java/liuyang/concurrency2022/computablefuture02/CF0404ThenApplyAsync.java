package liuyang.concurrency2022.computablefuture02;

import liuyang.concurrency2022.computablefuture.T;

import java.awt.event.TextEvent;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * @author :liuyang(wx)
 * @date :2022/2/21 11:14
 *        2022/4/25 实测，任务是否在独立的线程中运行，除了与使用的CompletableFuture方法有关，还与选择的线程池有关。
 */
public class CF0404ThenApplyAsync {
    public static void main(String[] args) {
        T.printTimeAndThread("小白吃好了");
        T.printTimeAndThread("小白 结账、要求开发票");

        //ExecutorService executorService = Executors.newWorkStealingPool();// 使用这个或者默认都只会在一个线程中执行。
        ExecutorService executorService = Executors.newFixedThreadPool(2);// 使用这个可以看到是在不同线程中进行。

        // 两个服务员（貌似在JDK11上有"问题", 日志显示任务都是在ForkJoinPool中的同一个线程中执行)。
        // 20220425 后续可以尝试配置Executor试一下：
        // 1. 使用newFixedThreadPool可以看到预期在不同线程执行的效果。
        // 2. 使用newWorkStealingPool或者直接给ForkJoinPool示例，则会看到两个任务都还是在同一个线程中执行。
        CompletableFuture<String> invoice = CompletableFuture.supplyAsync(() -> {
            T.printTimeAndThread("服务员收款 500元");
            T.sleepMillis(1000);
            return "500";
        //}).thenApply(money -> {// Function
        }, executorService).thenApplyAsync(money -> {// Function // 20220425 最终是否在同一线程中执行与线程池的选择有关。
        //}).thenApplyAsync(money -> {// Function
            // 1. thenApplyAsync会把两块代码独立地看做是两个任务。
            // 2. 必须在第一个执行完之后再执行第二个。
            // 3. 实际运行是否在同一个线程，则与默认或者明确指定的Executor相关！
            T.printTimeAndThread(String.format("服务员开发票 面额 %s元", money));
            T.sleepMillis(200);
            return String.format("%s元发票", money);
        }, executorService);// 20220425 最终
        //});

        T.printTimeAndThread("小白 接到朋友的电话，想一起打游戏。");
        T.printTimeAndThread(String.format("小白拿到%s是， 准备回家", invoice.join()));

        executorService.shutdown();
    }
}
