package liuyang.concurrency2018.threadpoolframework;

import java.util.concurrent.Executors;

/**
 * 01:44:49
 * 线程池背后的原理: 所有的线程池(除了ForkJoinPool之外)都是用ThreadPoolExecutor
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ThreadPoolExecutor.html
 */
public class T13ThreadPoolExecutor {
	/*
	 * Executors.newFixedThreadPool(CPU_CORE_NUM); 看一下实现代码就OK
	 * 背后都是ThreadPoolExecutor
	 */

	// 以下来自源码：
	/**
	 * Creates a new {@code ThreadPoolExecutor} with the given initial
	 * parameters, the default thread factory and the default rejected
	 * execution handler.
	 *
	 * <p>It may be more convenient to use one of the {@link Executors}
	 * factory methods instead of this general purpose constructor.
	 *
	 * @param corePoolSize the number of threads to keep in the pool, even
	 *        if they are idle, unless {@code allowCoreThreadTimeOut} is set
	 * @param maximumPoolSize the maximum number of threads to allow in the
	 *        pool
	 * @param keepAliveTime when the number of threads is greater than
	 *        the core, this is the maximum time that excess idle threads
	 *        will wait for new tasks before terminating.
	 * @param unit the time unit for the {@code keepAliveTime} argument
	 * @param workQueue the queue to use for holding tasks before they are
	 *        executed.  This queue will hold only the {@code Runnable}
	 *        tasks submitted by the {@code execute} method.
	 * @throws IllegalArgumentException if one of the following holds:<br>
	 *         {@code corePoolSize < 0}<br>
	 *         {@code keepAliveTime < 0}<br>
	 *         {@code maximumPoolSize <= 0}<br>
	 *         {@code maximumPoolSize < corePoolSize}
	 * @throws NullPointerException if {@code workQueue} is null
	 */
	/*
	public ThreadPoolExecutor(int corePoolSize,
							  int maximumPoolSize,
							  long keepAliveTime,
							  TimeUnit unit,
							  BlockingQueue<Runnable> workQueue) {
		this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
				Executors.defaultThreadFactory(), defaultHandler);
	}
	 */
}
