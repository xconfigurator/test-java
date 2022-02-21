package liuyang.concurrency2018.threadpoolframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 00:26:56 左右
 */
public class T05ThreadPool {

	private static final int THREAD_NUM = 5; // 可以执行任务的线程数（线程池中的线程数）
	private static final int JOB_NUM = 7; // 任务数 注意这个时候：queued tasks = 2 （任务队列一般使用的容器都是BlockingQueue）

	public static void main(String[] args) throws InterruptedException {

		ExecutorService service = Executors.newFixedThreadPool(THREAD_NUM);// 每个线程池维护两个队列：queue tasks, completed tasks。

		// 布置任务：5个人干6份工作
		for (int i = 0; i < JOB_NUM; i++) {
			// 可以放Runnable，也可以放Callable
			// 这里是Runnable
			service.execute(() ->{
				// 工作内容
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			}); 
		}
		
		System.out.println(service);
		
		service.shutdown();// shutdown transactional
		//service.shutdownNow(); // shutdown abort

		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);// 观察已经调用了shutdown或shutdownNow后的不同状态。

		TimeUnit.SECONDS.sleep(5);
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
	}

}
