package liuyang.concurrency2022.completablefuture04_performance;

import liuyang.concurrency2022.completablefuture.Dish;
import liuyang.concurrency2022.completablefuture.T;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

/**
 * @since 20220425
 */
public class _01_terribleCode {
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
        for (Dish dish : dishes) {
            CompletableFuture.runAsync(() -> dish.make()).join();// 这样写可不妙！
        }

        T.printTimeAndThread("菜都做好可，上菜" + (System.currentTimeMillis() - startTime));
    }
}
