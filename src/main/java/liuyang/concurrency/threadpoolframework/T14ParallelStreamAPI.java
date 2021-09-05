package liuyang.concurrency.threadpoolframework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 01:53:19
 * 课程小结： 01:56:37 快速串讲
 */
public class T14ParallelStreamAPI {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();

		// 生成一万个一百万到两百万之间的随机数
		Random r = new Random();
		for (int i = 0; i < 10000; i++) {
			nums.add(1000000 + r.nextInt(1000000));
		}

		// System.out.println(nums);

		// /////////////////////////////////////////////////////
		// 使用普通
		long begin = System.currentTimeMillis();
		nums.forEach(v -> isPrime(v));
		long end = System.currentTimeMillis();
		System.out.println(end - begin + "ms");

		// /////////////////////////////////////////////////////
		// 使用Parallel stream API
		begin = System.currentTimeMillis();
		nums.parallelStream().forEach(T14ParallelStreamAPI::isPrime);
		end = System.currentTimeMillis();
		System.out.println(end - begin + "ms");

	}

	// 判断质数Core
	static boolean isPrime(int num) {
		boolean flag = true;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}

}
