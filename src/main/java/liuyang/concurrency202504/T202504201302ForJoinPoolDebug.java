package liuyang.concurrency202504;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author xconf
 * @since 2025/4/20
 */
@Slf4j(topic = "T202504201302ForJoinPoolDebug")
public class T202504201302ForJoinPoolDebug {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool(12);
        Integer invoke = fjp.invoke(new MyTaskDebug(100));
        log.info("result = {}", invoke);
    }
}

@Slf4j(topic = "MyTaskDebug")
class MyTaskDebug extends RecursiveTask<Integer> {

    private Integer n;

    public MyTaskDebug(Integer n) {
        this.n = n;
    }
    @Override
    protected Integer compute() {
        // debug begin
        //System.out.println(Thread.currentThread());
        // debug end

        // 终止条件
        if (1 == n) {
            return n;
        }

        MyTaskDebug subTask = new MyTaskDebug(n -1);
        log.debug("Thread [{}] fork() {}", Thread.currentThread(), n - 1);
        subTask.fork();// fork
        //return n + subTask.join();// join
        Integer result =  n + subTask.join();// join
        log.debug("Thread [{}] join() {} {}", Thread.currentThread(), n, n-1);
        return result;
    }
}
