package liuyang.concurrency2022.completablefuture04_performance;

import liuyang.concurrency2022.completablefuture.Dish;
import liuyang.concurrency2022.completablefuture.T;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * 使用自定义线程池
 */
public class _05_customThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();// 它只是帮我们尽量压榨CPU，而实CPU自身能力，永远是上界（是上确界吧？）

        T.printTimeAndThread("小白和小伙伴们 进餐厅点菜");
        long startTime = System.currentTimeMillis();

        // Stream API
        CompletableFuture[] dishes = IntStream.rangeClosed(1, 100)// 试试100 为啥可以一瞬间搞定，因为make中的sleep。但如果换做其他的任务，看到的效果大概率就不是这样了！
                .mapToObj(i -> new Dish("菜" + i, 1))
                //.map(dish -> CompletableFuture.runAsync(dish::make))
                .map(dish -> CompletableFuture.runAsync(dish::make, executorService))// 这个线程池就是本应用私有的，并且可以放心定制！但要记着关闭！
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(dishes).join();

        T.printTimeAndThread("菜都做好可，上菜" + (System.currentTimeMillis() - startTime));

        executorService.shutdown();// 线程池中的线程都是前台线程，用完必须手动关闭！
    }
}
