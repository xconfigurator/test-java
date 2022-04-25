package liuyang.concurrency2022.computablefuture04;

import java.util.concurrent.ForkJoinPool;

/**
 * @since 20220425
 */
public class _04_commonPoolSize {
    public static void main(String[] args) {
        // 试着调整线程池线程数 begin
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");
        // 试着调整线程池线程数 end

        // CPU线程数
        System.out.println(Runtime.getRuntime().availableProcessors());// 6 6
        // 查看当前线程数
        System.out.println(ForkJoinPool.commonPool().getPoolSize());// 0 0
        // 查看最大线程数
        System.out.println(ForkJoinPool.getCommonPoolParallelism());// 5 12
    }
}
