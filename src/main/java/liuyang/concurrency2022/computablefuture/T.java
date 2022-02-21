package liuyang.concurrency2022.computablefuture;

import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

/**
 * @author :liuyang(wx)
 * @date :2022/2/21 8:55
 */
public class T {
    public static void sleepMillis(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printTimeAndThread(String tag) {
        String result = new StringJoiner("\t\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(tag)
                .toString();
        System.out.println(result);
    }
}
