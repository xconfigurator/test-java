package liuyang.concurrency2022.essential.question;

import java.util.concurrent.TimeUnit;

/**
 * 一道面试题
 *
 * @author :liuyang(wx)
 * @description :
 * @date :2022/2/15 14:36
 */
public class TT01 implements Runnable{
    int b = 998;

    public synchronized void m1() throws InterruptedException {
        b = 1000;
        TimeUnit.SECONDS.sleep(5);
        System.out.println("m1 b = " + b);
    }

    public void m2(){
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

    // 问题： m1在执行的时候。m2可以执行么？
    // 答：能。且m2()运行结果是1000，不是998。
    public static void main(String[] args) throws InterruptedException {
        TT01 tt = new TT01();
        new Thread(tt).start();// m1()
        TimeUnit.SECONDS.sleep(1);// 确保tt线程已经启动。
        tt.m2();// m2()
    }
}
