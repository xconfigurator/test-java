package liuyang.concurrency2022.essential.question;

import java.util.concurrent.TimeUnit;

/**
 * 由TT01改编
 *
 * @author :liuyang(wx)
 * @description :
 * @date :2022/2/15 14:51
 */
public class TT02 implements Runnable{
    int b = 998;

    public synchronized void m1() throws InterruptedException {
        b = 1000;
        TimeUnit.SECONDS.sleep(5);
        System.out.println("m1 b = " + b);
    }

    // 观察一下下面两种写法在main调用场景下的区别。(执行顺序发生改变！)
    //public void m2() throws InterruptedException {
    public synchronized void m2() throws InterruptedException {// 改成这样之后，m2就只能在m1执行完之后执行。
        // 改变点
        TimeUnit.MILLISECONDS.sleep(2500);
        b = 2000;
        System.out.println("m2 b = " + b);
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 看一下结果
    // 被改掉了！
    // 所以，对临界区的访问是要结合逻辑考虑全面，锁只手段，但加锁位置不正确同样不能解决问题。
    public static void main(String[] args) throws InterruptedException {
        TT02 tt = new TT02();
        new Thread(tt).start();
        TimeUnit.SECONDS.sleep(1);// 确保tt线程已经启动。
        tt.m2();
    }
}
