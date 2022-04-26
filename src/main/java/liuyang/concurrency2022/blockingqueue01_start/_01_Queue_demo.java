package liuyang.concurrency2022.blockingqueue01_start;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @since 2022/4/25
 */
public class _01_Queue_demo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("tow");
        queue.offer("three");

        System.out.println("--------开始打印--------");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        System.out.println("--------结束打印--------");
    }
}
