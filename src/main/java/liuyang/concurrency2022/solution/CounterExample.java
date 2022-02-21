package liuyang.concurrency2022.solution;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *
 * @author :liuyang(wx)
 * @date :2022/2/17 11:22
 */
@Slf4j
public class CounterExample {
    private static int threadTotal = 10;
    private static int clientTotal = 5000;
    private static long count =  0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0;i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    log.error(e.getMessage(), e);
                }
            });
        }
        executorService.shutdown();
        log.info("count = {}", count);
    }

    private static void add() {
        count ++;
    }
}
