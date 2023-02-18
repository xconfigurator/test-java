package liuyang.concurrency202302.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 老齐提供的代码里没有这个
 *
 * @author xconf
 * @since 2023/2/18
 */
public class ConditionSample {
    public static void main(String[] args) {
        // 使用Condition控制线程顺序
        ReentrantLock lock = new ReentrantLock();// Condition是通过ReentrantLock来实现的
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                c1.await();
                TimeUnit.SECONDS.sleep(1);
                System.out.println("粒粒皆辛苦");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                c2.await();
                TimeUnit.SECONDS.sleep(1);
                System.out.println("谁知盘中餐");
                c1.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                c3.await();
                TimeUnit.SECONDS.sleep(1);
                System.out.println("汗滴禾下土");
                c2.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("锄禾日当午");
                c3.signal();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
