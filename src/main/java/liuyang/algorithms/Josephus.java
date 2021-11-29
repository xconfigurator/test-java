package liuyang.algorithms;

import java.util.*;

/**
 * @author liuyang
 * @since 2021/11/29
 */
public class Josephus {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (true) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            if (n == 0) break;
            Deque<Integer> aLoop = new LinkedList<>();
            for (int i = 0; i < n; ++i) {
                aLoop.add(i + 1);
            }
            while (!aLoop.isEmpty()) {
                if (aLoop.size() == 1) {                // 大王
                    System.out.println(aLoop.peek());
                }
                for (int i = 0; i < m - 1; ++i) {       // 数m-1次
                    aLoop.addLast(aLoop.getFirst());    // 队头元素加入队尾
                    aLoop.removeFirst();
                }
                //System.out.println(aLoop.peek());       // 可以输出每次出队人
                aLoop.removeFirst();                    // 第m个人出列
            }
        }
    }
}
