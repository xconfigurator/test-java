package liuyang.concurrency2018.concurrentcontainer;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * 35:00 左右开始
 * SkipList以及ConcurrentSkipListMap
 * http://blog.csdn.net/sunxianghuang/article/details/52221913
 */
public class T01ConcurrentMap {

	public static void main(String[] args) {
		// 一堆Map
		Map<String, String> map;
		map = new ConcurrentHashMap<>();// 96ms 58ms 41ms 60ms // 把大锁分成了小锁。分成了16份。
//		map = new ConcurrentSkipListMap<>();// 83ms 86ms // 高并发且排序
//		map = new Hashtable<>();// 50ms 45ms
//		map = new HashMap<>();// 190ms 104ms // 可以使用Collections.synchronizedXXXX加锁
		//map = new TreeMap<>();// 2018 抛异常，还死机 更新：20211125 i5 9400 正常

		// 测试用例
		test(map);
	}

	// 测试用例
	public static void test(Map<String, String> map) {
		Random r = new Random();
		Thread[] threads = new Thread[100];
		CountDownLatch latch = new CountDownLatch(threads.length);

		long begin = System.currentTimeMillis();

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> {
				for (int j = 0; j < 10000; j++) {
					map.put("a" + r.nextInt(100000), "a" + r.nextInt(100000));
					latch.countDown();
				}
			});
		}

		Arrays.asList(threads).forEach(t -> t.start());
		try {
			latch.await();// 主线程等待，直到所有的线程都算完了再继续进行。
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");
	}

}
