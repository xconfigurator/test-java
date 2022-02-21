package liuyang.concurrency2018.threadpoolframework;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * 01:24:40 - 1:43:00
 * 文档：https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ForkJoinPool.html
 * 注：ForkJoinPool启动的是后台线程（Daemon），而FixedThreadPool等使用的就是最普通的Thread。<br>
 *
 * 计算1000000个100以内随机整数的和
 * @author liuyang
 *
 */
public class T12ForkJoinPool {
	static int[] nums = new int[1000000];
	static final int MAX_NUM = 50000;		// 每个分片不超过50000
	static Random r = new Random();
	
	static {
		// 在数组中初始哈好100以内的随机数
		for (int i=0; i < nums.length; i++) {
			nums[i] = r.nextInt(100);
		}
	}
	
	// 分治	https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ForkJoinTask.html
	// ForkJoinTask
	// 1. RecursiveAction 无返回值	https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/RecursiveAction.html
	// 2. RecursiveTask 有返回值		https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/RecursiveTask.html
	// 3. CountedCompleter			https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/CountedCompleter.html

	// 1. RecursiveAction 无返回值	https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/RecursiveAction.html
	// 就是分任务 没有返回值 就不需要join
	// 演示1 继承RecursiveAction
	static class AddRecursiveAction extends RecursiveAction {
		int start, end;
		
		AddRecursiveAction(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		// 无返回值
		@Override
		protected void compute() {
			if (end - start <= MAX_NUM) {
				long sum = 0L;
				for (int i = start; i < end; i++) {
					sum += nums[i];
				}
				// 没返回值，就只能打印了
				System.out.println("from:" + start + " to: " + end + " = " + sum);
			} else {
				int middle = start + (end - start) / 2;
				AddRecursiveAction subTask1 = new AddRecursiveAction(start, middle);
				AddRecursiveAction subTask2 = new AddRecursiveAction(middle, end);
				subTask1.fork();// 子线程1启动
				subTask2.fork();// 子线程2启动
			}
		}
	}


	// 2. RecursiveTask 有返回值		https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/RecursiveTask.html
	// 演示2 继承RecursiveTask
	static class AddRecursiveTask extends RecursiveTask<Long> {
		
		int start, end;
		
		AddRecursiveTask(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		// 有返回值
		@Override
		protected Long compute() {
			if (end - start <= MAX_NUM) {
				long sum = 0L;
				for (int i = start; i < end; i++) {
					sum += nums[i];
				}
				return sum;
			} else {
				int middle = start + (end - start) / 2;
				AddRecursiveTask subTask1 = new AddRecursiveTask(start, middle);
				AddRecursiveTask subTask2 = new AddRecursiveTask(middle, end);
				subTask1.fork();// 子线程1启动
				subTask2.fork();// 子线程2启动	
				return subTask1.join() + subTask2.join();
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// /////////////////////////////////////////////////////////
		// 方法1 循环
		//System.out.println("" + Arrays.stream(nums).sum());// Java Stream API since JDK 8
		System.out.println("" + Arrays.stream(nums).parallel().sum());
		
		// 方法2 ForkJoinPool - RecursiveAction
		// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ForkJoinPool.html
		// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/RecursiveAction.html
		/*
		ForkJoinPool fjp = new ForkJoinPool(); // 整个递归过程由ForkJoinPool来维护。
		AddRecursiveAction task = new AddRecursiveAction(0, nums.length);
		fjp.execute(task);
		// 后台启动守护进程进行计算....
		// 想要看到输出就需要阻塞
		System.in.read();
		*/

		// /////////////////////////////////////////////////////////
		// 方法2 ForkJoinPool - RecursiveTask
		// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ForkJoinPool.html
		// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/RecursiveTask.html
		ForkJoinPool fjp = new ForkJoinPool(); // 整个递归过程由ForkJoinPool来维护。
		AddRecursiveTask task = new AddRecursiveTask(0, nums.length);
		fjp.execute(task);
		long result = fjp.invoke(task);
		System.out.println(result);
		fjp.shutdown();
		
		/*
		long result = task.join();
		System.out.println(result);// 49506146
		// 后台启动守护进程进行计算....
		// 想要看到输出就需要阻塞
		System.in.read();
		fjp.shutdown();
		*/
	}
}
