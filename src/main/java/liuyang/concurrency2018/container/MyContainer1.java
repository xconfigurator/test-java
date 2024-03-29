package liuyang.concurrency2018.container;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 要求：<br>
 * 实现一个容器，提供两个方法，add和size<br>
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5时，线程2给出提示并结束。<br>
 * 
 * 最简单粗暴的实现：volatile和while(true)<br>
 * 
 * @author liuyang
 *
 */
public class MyContainer1 {

	//List lists = new ArrayList();// t2不能完成动作
	volatile List lists = new ArrayList();// t2可以完成动作。添加volatile使t2可以感知lists的变化
	
	public void add(Object o) {
		lists.add(o);
	}
	
	public int size() {
		return lists.size();
	}
	
	public static void main(String[] args) {
		MyContainer1 c = new MyContainer1();
		
		// 线程t1添加
		new Thread(()-> {
			for (int i = 0; i < 10; i++) {
				c.add(new Object());
				System.out.println("add " + i);
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
		}, "t1").start();
		
		// 线程t2监控
		new Thread(()-> {
			while (true) {
				if (c.size() == 5) {
					break;
				}
			}
			System.out.println("t2 结束");
		}, "t2") .start();
	}

}
