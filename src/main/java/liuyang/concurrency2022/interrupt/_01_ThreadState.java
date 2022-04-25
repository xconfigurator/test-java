package liuyang.concurrency2022.interrupt;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 处理InterruptedException的正确方式
 *
 */
@Slf4j
public class _01_ThreadState {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("1 - " + thread.getState());// NEW
        thread.start();
        System.out.println("2 - " + thread.getState());// RUNNABLE
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
            // 自定义处理逻辑
            log.error("线程被中断");
            log.error(e.getMessage(), e);
        }
        System.out.println("3 - " + thread.getState());// TERMINATED
    }
}
