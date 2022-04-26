package liuyang.concurrency2022.completablefuture04_performance;

import liuyang.concurrency2022.completablefuture.Dish;
import liuyang.concurrency2022.completablefuture.T;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

/**
 * 这样写比上一个版本一个一个join速度明显加快
 *
 * 问题：如何看默认线程池一共有多大？
 * 答：把make方法的时间加大，看第一批打出的菜有几个就知道了。
 */
public class _02_Improve {
    public static void main(String[] args) {
        T.printTimeAndThread("小白和小伙伴们 进餐厅点菜");
        long startTime = System.currentTimeMillis();

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
            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> dish.make(10));// 貌似竟然是5（hbfec），在家里20 core机器上试试看。答案是：CPU可运行线程数 - 1。
            cfList.add(voidCompletableFuture);
        }
        // 等待所有新城执行完
        CompletableFuture.allOf(cfList.toArray(new CompletableFuture[cfList.size()])).join();

        T.printTimeAndThread("菜都做好可，上菜" + (System.currentTimeMillis() - startTime));
    }
}
