package liuyang.concurrency.threadpoolframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * @author liuyang
 * @date 2018/3/16
 */
public class T04Executors {
	// https://docs.oracle.com/javase/9/docs/api/java/util/concurrent/Executors.html
    // 5种线程池。
    // 1. 保证任务执行顺序
    ExecutorService es1 = Executors.newSingleThreadExecutor();               // 见T09SingleThreadPool
    // 2.
    ExecutorService es2 = Executors.newFixedThreadPool(1);          // 见T07ParallelComputing 固定个数的线程池
    // 3. 很像数据源连接池的行为
    ExecutorService es3 = Executors.newCachedThreadPool();                   // 见T08CachedPool 中注释里的描述
    // 4. 可以替代Timer
    ExecutorService es4 = Executors.newScheduledThreadPool(1);   //  见T10SchedulePool
    // 5. 抢着干。底层是：ForkJoinPool
    ExecutorService es5 = Executors.newWorkStealingPool();                   //  见T11WorkStealingPool

    // 联想：还有一种ForkJoinPool(比较底层。并不是通过Executors来创建。但WorkStealingPool就是通过ForkJoinPool封装来的)
    // ForkJoinPool启动的是后台线程（Daemon），而FixedThreadPool等使用的就是最普通的Thread。
    ForkJoinPool forkJoinPool = new ForkJoinPool();                          //  见T12ForkJoinPool
}
