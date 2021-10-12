package liuyang.jcf.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuyang
 * @date 2021/10/12
 */
public class HelloQueue {

    private static Queue<String> q = new LinkedList<>();

    public static void main(String[] args) {
        // 增
        q.add("hello");
        q.add("queue");

        // 查
        System.out.println("queue size() = " + q.size());
        System.out.println("queue.peek() = " + q.peek());
        System.out.println("queue size() = " + q.size());

        // 出队
        System.out.println("queue size() = " + q.size());
        System.out.println("queue.pool() = " + q.poll());
        System.out.println("queue size() = " + q.size());

        // 判空
        System.out.println(q.isEmpty());

        q.add("foo");
        q.add("bar");
        // 遍历 (连续出队)
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
