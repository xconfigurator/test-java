package liuyang.concurrency202302.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 线程安全：在拥有共享数据的多条线程并行执行的程序中，线程安全的代码会通过同步机制保证各个线程都可以正常而且正确的执行，不会出现数据污染等意外情况。
 */
public class DownloadsSample {
    public static int users = 100;//同时模拟的并发访问用户数量
    public static int downTotal = 50000; //用户下载的真实总数
    public static int count = 0 ;//计数器

    public static void main(String[] args) {
        //调度器，JDK1.5后提供的concurrent包对于并发的支持
        ExecutorService executorService  = Executors.newCachedThreadPool();
        //信号量，用于模拟并发的人数
        final Semaphore semaphore = new Semaphore(users);
        for(int i = 0 ; i < downTotal ; i++){
            executorService.execute(()->{
                //通过多线程模拟N个用户并发访问并下载
                try {
                    semaphore.acquire();// liuyang 20230218 个人感觉信号量在这里没什么用。
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();//关闭调度服务
        System.out.println("下载总数：" + count);
    }
    //线程不安全
    public static void add(){
        count++;
    }
    //线程安全
    //线程安全：在拥有共享数据的多条线程并行执行的程序中，线程安全的代码会通过同步机制保证各个线程都可以正常而且正确的执行，不会出现数据污染等意外情况。
    /*public synchronized static void add(){
        count++;
    }*/
}
