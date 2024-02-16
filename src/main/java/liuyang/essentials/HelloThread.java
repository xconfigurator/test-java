package liuyang.essentials;

/**
 * 详见liuyang.concurrency*包示例
 */
public class HelloThread {

	public static void main(String[] args) {

		// 定义线程动作 JDK 8之前
        Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("使用Lambda之前的方法");
			}
        	
        };
        
        // 定义线程动作 JDK 8 Lambda E
	}

}
