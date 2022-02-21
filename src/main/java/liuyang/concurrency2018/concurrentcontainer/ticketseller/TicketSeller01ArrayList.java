package liuyang.concurrency2018.concurrentcontainer.ticketseller;

import java.util.ArrayList;
import java.util.List;

/**
 * 有N张火车票，每张火车票都有一个编号，同时有10个窗口对外售票。请写程序模拟。<br>
 * 
 * 问题引出<br>
 * 从问题暴露，逐步引入同步容器。<br>
 * 
 * 问题点<br>
 * 1. 有可能卖重<br>
 * 2. remove不是原子性的<br>
 * 
 * @author liuyang
 *
 */
public class TicketSeller01ArrayList {

	static List<String> tickets = new ArrayList<>();

	// 库存10000张票
	static {
		for (int i = 0; i < 10000; i++) {// 10000张票
			tickets.add("票编号：" + i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {// 10个售票窗口
			new Thread(() -> {
				while (tickets.size() > 0) {
					System.out.println("销售了 -- " + tickets.remove(0));
				}
			}).start();
		}
	}

}
