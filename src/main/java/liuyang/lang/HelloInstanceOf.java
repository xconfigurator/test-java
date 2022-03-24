package liuyang.lang;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author :liuyang(wx)
 * @date :2022/3/2 8:57
 */
public class HelloInstanceOf {
    static LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        queue.put(new A());
        queue.put(new B());
        queue.put(new B());
        queue.put(new A());

        for (Object o : queue) {
            if (o instanceof A) {
                System.out.println("A" + (A)o);
            }
            if (o instanceof B) {
                System.out.println("B" + (B)o);
            }

        }
    }
}

class A {
    @Override
    public String toString() {
        return "A";
    }
}

class B {
    @Override
    public String toString() {
        return "B";
    }
}