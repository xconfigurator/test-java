package liuyang.jcf.stack;

import java.util.Stack;

/**
 * @author liuyang
 * @date 2021/10/12
 */
public class HelloStack {
    private static Stack<String> s = new Stack<>(); // extends java.util.Vector
    // 注：A more complete and consistent set of LIFT stack operations is provided by Deque interface and its implemnetations,
    // which should be used in preference to this class. For example.
    // Deque<Integer> stack = new ArrayDeque<Integer>();

    public static void main(String[] args) {
        s.push("hello");// Pushes an item onto the top of this stack.
        s.push("stack");
        System.out.println(s.peek());// Looks at the object at the top of this stack without removing it from stack.
        System.out.println(s.pop());// Removes the object at the top of this stack and returns that object as the value of this function.
        System.out.println(s.empty());// Tests if this stack is empty.
        System.out.println(s.search("stack"));// Returns the 1-baseed position where an objet is on this stack.
        System.out.println(s.isEmpty());// Methods declared in class java.util.Vector
        System.out.println(s.size());// Methods declared in class java.util.Vector
    }
}
