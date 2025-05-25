package liuyang.concurrency202504;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 使用ForkJoinPool递归计算 1到n的和
 * 视频：https://www.bilibili.com/video/BV16J411h7Rd/?spm_id_from=333.788.player.switch&vd_source=8bd7b24b38e3e12c558d839b352b32f4&p=233
 *
 *
 * @author xconf
 * @since 2025/4/20
 */
@Slf4j(topic = "T202504201236ForkJoinPool")
public class T202504201236ForkJoinPool {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool(12);
        Integer invoke = fjp.invoke(new MyTask(100));
        log.info("result = {}", invoke);
    }
}

//@Slf4j(topic = "MyTask")
class MyTask extends RecursiveTask<Integer> {

    private Integer n;

    public MyTask(Integer n) {
        this.n = n;
    }
    @Override
    protected Integer compute() {
        // 终止条件
        if (1 == n) {
            return n;
        }

        MyTask subTask = new MyTask(n -1);
        subTask.fork();// fork
        return n + subTask.join();// join
    }
}
