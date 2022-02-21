package liuyang.concurrency2018.concurrentcontainer.ticketseller;

import java.util.ArrayList;
import java.util.List;

/**
 * 有N张火车票，每张火车票都有一个编号，同时有10个窗口对外售票。请写程序模拟。<br>
 * 
 * 问题引出<br>
 * 从问题暴露，逐步引入同步容器。<br>
 * 
 * Vector也折了，那就加个锁试试呗<br>
 * 注意需要将整个临界区锁定。<br>
 * 问题解决！<br>
 * 但同时因为锁粒度太大，引起效率下降。<br>
 *
 * @author liuyang
 *
 */
public class TicketSeller03Synchronized {

	static List<String> tickets = new ArrayList<>();

	static {
		for (int i = 0; i < 10000; i++) {// 10000张票
			tickets.add("票编号：" + i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {// 10个售票窗口
			new Thread(() -> {

				// 加锁的原则是判断和操作不可分离
				synchronized(tickets) {	// Critical Region begin
					while (tickets.size() > 0) {
						System.out.println("销售了 -- " + tickets.remove(0));
					}
				}						// Critical Region end
				
			}).start();
		}
	}

}
