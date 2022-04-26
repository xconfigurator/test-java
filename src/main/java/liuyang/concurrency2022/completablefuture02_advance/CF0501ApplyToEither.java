package liuyang.concurrency2022.completablefuture02_advance;

import liuyang.concurrency2022.completablefuture.T;

import java.util.concurrent.CompletableFuture;

/**
 * 谁先到就选谁
 *
 * @author :liuyang(wx)
 * @date :2022/2/21 11:17
 */
public class CF0501ApplyToEither {
    public static void main(String[] args) {
        T.printTimeAndThread("小白走出餐厅，来到公交站");
        T.printTimeAndThread("等待 310路 或者 325路 公交到来");

        CompletableFuture<String> bus = CompletableFuture.supplyAsync(() -> {
            T.printTimeAndThread("310路公交正在赶来");
            T.sleepMillis(30000);
            return "310路到了";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            // https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/CompletableFuture.html#applyToEither(java.util.concurrent.CompletionStage,java.util.function.Function)
            T.printTimeAndThread("325路公交正在赶来");
            T.sleepMillis(10000);
            return "325路到了";
        }), firstComeBus -> firstComeBus);

        T.printTimeAndThread(String.format("%s, 小白坐车回家", bus.join()));
    }
}
