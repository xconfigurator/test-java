package liuyang.concurrency2022.completablefuture01_start;

import liuyang.concurrency2022.completablefuture.T;

import java.util.concurrent.CompletableFuture;

/**
 * 饭还没蒸，需要服务员蒸 supplyAsync的实现版本（有更好的实现版本，参见CF0302ThenCombine）
 *
 * @author :liuyang(wx)
 * @date :2022/2/21 9:49
 */
public class CF0301SupplyAsync {
    public static void main(String[] args) {
        T.printTimeAndThread("小白进入餐厅");
        T.printTimeAndThread("小白点了  番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            T.printTimeAndThread("厨师炒菜");
            T.sleepMillis(200);
            return "番茄炒蛋";
        });
        CompletableFuture<String> race = CompletableFuture.supplyAsync(() -> {
            T.printTimeAndThread("服务员蒸饭");
            T.sleepMillis(200);
            return "米饭";
        });
        T.printTimeAndThread("小白在打王者");

        String result = String.format("%s + %s 好了 ", cf1.join(), race.join());
        T.printTimeAndThread("服务员打饭");
        T.sleepMillis(100);

        T.printTimeAndThread(String.format("%s, 小白开吃", result));
    }
}
