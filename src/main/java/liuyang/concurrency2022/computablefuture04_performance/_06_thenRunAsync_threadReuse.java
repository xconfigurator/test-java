package liuyang.concurrency2022.computablefuture04_performance;

import liuyang.concurrency2022.computablefuture.T;

import java.util.concurrent.*;

/**
 * 演示线程复用
 * 注：演示线程池的选择对最终任务在哪个线程中执行产生的影响。
 *
 * @since 2022/4/25
 */
public class _06_thenRunAsync_threadReuse {
    public static void main(String[] args) {
        ExecutorService executorService;
        // 方法1：使用默认参数
        //executorService = Executors.newCachedThreadPool();// 执行线程号改变
        //executorService = new ForkJoinPool();// 执行线程号不变
        // 方法2：（这个方法仅用于自测）
        // 调整线程池的参数，把空闲线程的存活时间设置为0
        executorService = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        // 20220425 实测缺失是在不同线程中执行。不过keepAliveTime不设置0甚至设为100，貌似也会在不同的线程中执行。

        CompletableFuture
                .runAsync(() -> T.printTimeAndThread("A"), executorService)
                .thenRunAsync(()-> T.printTimeAndThread("B"), executorService)
                .join();

        executorService.shutdown();
    }
}
