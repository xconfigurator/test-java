package liuyang.concurrency2022.computablefuture04;

import liuyang.concurrency2022.computablefuture.Dish;
import liuyang.concurrency2022.computablefuture.T;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

/**
 * 使用Stream API
 */
public class _03_goodCode {
    public static void main(String[] args) {
        // 试着调整线程池线程数 begin
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");// 竟然管用！！
        // 试着调整线程池线程数 end

        T.printTimeAndThread("小白和小伙伴们 进餐厅点菜");
        long startTime = System.currentTimeMillis();

        /*
        ArrayList<Dish> dishes = new ArrayList<Dish>();
        // 点菜
        for (int i = 0; i < 10; i++) {
            Dish dish = new Dish("菜" + i, 1);
            dishes.add(dish);
        }
        // 做菜
        ArrayList<CompletableFuture> cfList = new ArrayList<>();
        for (Dish dish : dishes) {
            //CompletableFuture.runAsync(() -> dish.make()).join();// 这样写可不妙！
            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> dish.make(10));// 貌似竟然是5（hbfec），在家里20 core机器上试试看。
            cfList.add(voidCompletableFuture);
        }
        // 等待所有新城执行完
        CompletableFuture.allOf(cfList.toArray(new CompletableFuture[cfList.size()])).join();
        */

        // Stream API
        CompletableFuture[] dishes = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Dish("菜" + i, 1))
                .map(dish -> CompletableFuture.runAsync(dish::make))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(dishes).join();

        T.printTimeAndThread("菜都做好可，上菜" + (System.currentTimeMillis() - startTime));
    }
}
