package liuyang.concurrency2022.essential;

/**
 * 通过implements Runnable来定义线程。
 *
 * @author :liuyang(wx)
 * @description : 重新整理线程相关问题
 * @date :2022/2/15 9:53
 */
public class Thread01ImplementsRunnable {
    public static void main(String[] args) {
        // JDK 8 - 写法
        new Thread(new Runner1()).start();

        // JDK 8 + 写法
        new Thread(() ->
                //System.out.println("foo: " + Thread.currentThread().getName())
                fun()
        ).start();

        // main线程
        //System.out.println("foo: " + Thread.currentThread().getName());
        fun();
    }

    static class Runner1 implements Runnable {
        @Override
        public void run() {
            //System.out.println("foo: " + Thread.currentThread().getName());
            fun();
        }
    }

    static void fun() {
        System.out.println("foo: " + Thread.currentThread().getName());
    }
}