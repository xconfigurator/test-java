package liuyang.concurrency2022.essential.sync;

import java.util.concurrent.TimeUnit;

/**
 * 互相持有对方需要的部分资源且不释放
 *
 * @author :liuyang(wx)
 * @description :
 * @date :2022/2/15 13:23
 */
public class ThreadDeadLock {
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (LockA.class) {
                infoAndSleep("申请LockA成功");
                synchronized (LockB.class) {
                    infoAndSleep("申请LockB成功");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (LockB.class) {
                infoAndSleep("申请LockB成功");
                synchronized (LockA.class) {
                    infoAndSleep("申请LockA成功");
                }
            }
        }).start();
    }

    static class LockA {}
    static class LockB {}

    static void infoAndSleep(String info) {
        System.out.println(Thread.currentThread().getName() + ":" + info);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
