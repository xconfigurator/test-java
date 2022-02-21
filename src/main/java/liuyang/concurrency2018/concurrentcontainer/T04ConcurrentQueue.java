package liuyang.concurrency2018.concurrentcontainer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 59:00 左右开始
 */
public class T04ConcurrentQueue {

	public static void main(String[] args) {
		Queue<String> strs = new ConcurrentLinkedQueue<>();
		
		// Queue
		// https://docs.oracle.com/javase/9/docs/api/java/util/Queue.html
		// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html
		for (int i = 0; i < 10; i++) {
			strs.offer("a" + i); // 类似add。 详细区别参考Java doc
		}
		
		System.out.println(strs);
		System.out.println(strs.size());
		System.out.println(strs.poll());
		System.out.println(strs.size());
		System.out.println(strs.peek());
		System.out.println(strs.size());
		
		// Deque
		// https://docs.oracle.com/javase/9/docs/api/java/util/Deque.html
	}

}
