package liuyang.jcf.stack;

import java.util.Stack;

/**
 * @author liuyang
 * @date 2021/10/12
 */
public class HelloStack {
    private static Stack<String> s = new Stack<>();

    public static void main(String[] args) {
        s.push("hello");
        s.push("stack");
        System.out.println(s.peek());
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.isEmpty());
    }
}
