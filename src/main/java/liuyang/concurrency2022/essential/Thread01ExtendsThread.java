package liuyang.concurrency2022.essential;

/**
 * @author :liuyang(wx)
 * @description :
 * @date :2022/2/15 10:10
 */
public class Thread01ExtendsThread {
    public static void main(String[] args) {
        // thread
        new Runner1().start();// 进入就绪态，等待处理机调度。（说明：CPU就像一个大厕所，凭什么你一start别人就得停……）

        // main
        fun();
    }

    static class Runner1 extends Thread {
        @Override
        public void run() {
            fun();
        }
    }

    static void fun() {
        System.out.println("foo: " + Thread.currentThread().getName());
    }
}
