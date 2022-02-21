package liuyang.concurrency2018.threadpoolframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 01:08:40
 *
 * 保证任务前后一定是顺序执行。
 * @author liuyang
 *
 */
public class T09SingleThreadPool {

	public static void main(String[] args) {
		// newSingleThreadExecutor			https://docs.oracle.com/javase/9/docs/api/java/util/concurrent/Executors.html#newSingleThreadExecutor--
		// newSingleThreadScheduledExecutor	https://docs.oracle.com/javase/9/docs/api/java/util/concurrent/Executors.html#newSingleThreadScheduledExecutor--
		ExecutorService service = Executors.newSingleThreadExecutor();

		// 指派五个任务
		for (int i = 0; i< 5; i++) {
			final int j = i;
			service.execute(()->{
				System.out.println(j + " " + Thread.currentThread().getName());
			});
		}

		service.shutdown();
	}
}
