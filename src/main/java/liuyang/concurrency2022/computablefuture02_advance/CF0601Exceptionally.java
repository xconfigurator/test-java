package liuyang.concurrency2022.computablefuture02_advance;

import liuyang.concurrency2022.computablefuture.T;

import java.util.concurrent.CompletableFuture;

/**
 * 处理异常
 * @author :liuyang(wx)
 * @date :2022/2/21 11:28
 */
public class CF0601Exceptionally {
    public static void main(String[] args) {
        T.printTimeAndThread("小白走出餐厅，来到公交站");
        T.printTimeAndThread("等待 310路 或者 325路 公交到来");

        CompletableFuture<String> bus = CompletableFuture.supplyAsync(() -> {
            T.printTimeAndThread("310路公交正在赶来");
            T.sleepMillis(100);
            //T.sleepMillis(3000);
            return "310路到了";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            T.printTimeAndThread("325路公交正在赶来");
            T.sleepMillis(1000);
            return "325路到了";
        }), firstComeBus -> {
                T.printTimeAndThread(firstComeBus);
                if (firstComeBus.startsWith("310")) {
                    throw new RuntimeException("没电了......");
                }
                return firstComeBus;
            }
        ).exceptionally(e -> {// exceptional的位置不一定在最后，根据业务需求不同可调整！
            T.printTimeAndThread(e.getMessage());
            T.printTimeAndThread("小白叫出租车");
            return "出租车 叫到了";
        });
        T.printTimeAndThread(String.format("%s, 小白坐车回家", bus.join()));
    }
}
