package liuyang.concurrency2018.concurrentcontainer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 1:26:14
 * 容量为0的BlockingQueue
 * put() // 如果没有消费者则阻塞，等待消费者消费。
 * @author liuyang
 *
 */
public class T09SynchronusQueue {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> strs = new SynchronousQueue<>();

		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		strs.put("hello, SynchronousQueue put()");// 如果没有消费者则阻塞, 等待消费者消费。这个里面用的就是TransferQueue
		//strs.add("hello, SynchronousQueue add()");// 有没有消费者都会抛出异常：Exception in thread "main" java.lang.IllegalStateException: Queue full
		System.out.println(strs.size());// 0
	}

}
