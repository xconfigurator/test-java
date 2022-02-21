package liuyang.concurrency2018.threadpoolframework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 00:40:45 左右
 */
public class T06Future {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// ////////////////////////////////////////////////////
		// 单个线程情况
		// FutureTask https://docs.oracle.com/javase/9/docs/api/java/util/concurrent/FutureTask.html
		// 装一个Callable类型的 https://docs.oracle.com/javase/9/docs/api/java/util/concurrent/Callable.html
		FutureTask<Integer> task = new FutureTask<>(()->{
			TimeUnit.MILLISECONDS.sleep(500);		// 模拟执行500毫秒
			return 1000;									// 未来的某一个时刻会返回一个结果
		});

		// 运行
		new Thread(task).start();

		// 阻塞，等着task运行完。
		// FutureTask.get() : Waits if necessary for the computation to complete, and then retrieves its result.
		// 注意这个方法：可以设置超时！！
		// V	get​(long timeout, TimeUnit unit)
		//			Waits if necessary for at most the given time for the computation to complete, and then retrieves its result, if available.
		System.out.println(task.get()); // get()是FutureTask的方法

		// /////////////////////////////////////////////////////
		// 使用线程池情况
		ExecutorService service = Executors.newFixedThreadPool(5);
		Future<Integer> f = service.submit(()->{
			TimeUnit.MILLISECONDS.sleep(500);		// 若想完成任务需要500毫秒
			return 1;										// 返回1
		});
		//System.out.println(f.get());
		System.out.println(f.isDone());
		System.out.println(f.get());
		System.out.println(f.isDone());
		
		service.shutdownNow();
	}

}
