package liuyang.concurrency2022.computablefuture01;

import liuyang.concurrency2022.computablefuture.T;

import java.util.concurrent.CompletableFuture;

/**
 * supplyAsync  开启一个异步任务
 * thenCompose  连接
 * thenCombine  合并(结果由BiFunctino返回)
 *
 * 总结（CF01, CF02, CF03）：在视频12:30处，可以多看。
 *
 * @author :liuyang(wx)
 * @date :2022/2/21 8:59
 */
public class CF01SupplyAsync {
    public static void main(String[] args) {
        T.printTimeAndThread("小白进入餐厅");
        T.printTimeAndThread("小白点了  番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {// 在另一个线程执行！
            T.printTimeAndThread("厨师炒菜");
            T.sleepMillis(200);
            T.printTimeAndThread("厨师打饭");
            T.sleepMillis(100);
            return "番茄炒蛋 + 米饭 做好了";
        });

        T.printTimeAndThread("小白在打王者");
        T.printTimeAndThread(String.format("%s, 小白开吃", cf1.join()));// join可以被视为Future的get方法的升级版。join的优势在于异常处理。
    }
}
