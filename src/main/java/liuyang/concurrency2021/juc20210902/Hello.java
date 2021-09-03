package liuyang.concurrency2021.juc20210902;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuyang
 * @date 2021/9/2
 */
public class Hello {
    public static void main(String[] args) {
        // 三种线程池。
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService1 = Executors.newFixedThreadPool(1);
        ExecutorService executorService2 = Executors.newCachedThreadPool();

        // 后面如何使用

    }
}
