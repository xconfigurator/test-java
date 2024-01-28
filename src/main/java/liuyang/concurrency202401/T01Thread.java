package liuyang.concurrency202401;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;


/**
 * 启动线程的用法小结
 * https://www.bilibili.com/video/BV1np4y1C7Yf/?p=193&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 编写线程内容形式：三种。
 *      1. Thread
 *      2. Runnable
 *      3. Callable
 * 调用线程执行任务：两种。
 *      1. 手动new Thread().start()。
 *      2. 提交给线程池执行。（工程上推荐）
 *
 *  关于线程池
 *      1. Executors            工具类
 *      2. ExecutorService      线程池
 *      3. ThreadPoolExecutor   制造线程池的类.
 *      详见concurrency2022.threadpool.ThreadPoolExecutor.md。七个参数。
 *      七个参数的讲解见https://www.bilibili.com/video/BV1np4y1C7Yf/?p=194&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *      19：16处有一道面试题
 *
 * @author xconf
 * @since 2024/1/27
 */
@Slf4j
public class T01Thread {

    // 方法1
    public static class MyThread extends Thread {
        @Override
        public void run() {
            log.info("MyThread run");
        }
    }

    // 方法2
    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log.info("MyRunnable run");
      }
    }

    // 方法3
    public static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            log.info("MyCallable run");
            return "MyCallable return value";
        }
    }

    // 方法4


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1
        new MyThread().start();// 写法1
        log.info("MyThread started 写法1");
        new Thread(new MyThread()).start();// 写法2
        log.info("MyThread started 写法2");

        // 2.
        new Thread(new MyRunnable()).start();
        log.info("MyRunnable started");

        // 3. 想要阻塞地得到线程执行结果
        FutureTask<String> myFutureTask = new FutureTask<>(new MyCallable());
        new Thread(myFutureTask).start();
        log.info("myFutureTask.get() = {}", myFutureTask.get());// .get() 阻塞等待
        log.info("MyFutureTask started 注意这个打印顺序， 会出现在get执行完之后！");

        // 4. 线程池方式
        log.info("=========================================================");
        log.info("使用线程池方式：");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<?> submit1 = executorService.submit(new MyThread());
        submit1.get();
        Future<?> submit2 = executorService.submit(new MyRunnable());
        submit2.get();
        Future<String> submit3 = executorService.submit(new MyCallable());
        String s = submit3.get();
        log.info("myCallable的返回值，通过线程池返回的Future接口得到 = {}", s);
        executorService.shutdown();
    }
}
