package liuyang.concurrency2022.completablefuture01_start;

import liuyang.concurrency2022.completablefuture.T;

import java.util.concurrent.CompletableFuture;

/**
 * @author :liuyang(wx)
 * @date :2022/2/21 9:59
 */
public class CF0302ThenCombine {
    public static void main(String[] args) {
        T.printTimeAndThread("小白进入餐厅");
        T.printTimeAndThread("小白点了  番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            T.printTimeAndThread("厨师炒菜");
            T.sleepMillis(200);
            return "番茄炒蛋";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {// thenCombine把上个任务和这个任务一起执行
            T.printTimeAndThread("服务员蒸饭");
            T.sleepMillis(200);
            return "米饭";
        }), (dish, rice) -> {// BiFunction // 关键点：在于异步任务的合并。
            T.printTimeAndThread("服务员打饭");
            T.sleepMillis(100);
            return String.format("%s + %s 好了", dish, rice);
        });

        T.printTimeAndThread("小白在打王者");
        T.printTimeAndThread(String.format("%s, 小白开吃", cf1.join()));
    }
}
