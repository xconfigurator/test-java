package liuyang.concurrency2021.juc20210902;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步回调（有返回值情况）
 * 参考视频：https://www.bilibili.com/video/BV1Kw411Z7dF?p=43
 *
 * @author liuyang
 * @date 2021/9/2
 */
@Slf4j
public class CompletableFutureSupplyAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.<Integer>supplyAsync(() -> {
            return 1024;
        });

        integerCompletableFuture.whenComplete((t, throwable) -> {
            log.info("t = {}", t);
            log.info("throwable = {}", throwable);
        });

        integerCompletableFuture.get();
    }
}
