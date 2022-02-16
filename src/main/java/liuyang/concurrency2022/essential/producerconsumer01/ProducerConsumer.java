package liuyang.concurrency2022.essential.producerconsumer01;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * 并发容器
 *
 * 视频参考1: 11_线程同步_7_生产者消费者问题 5:18开始
 * 视频参考2: 看马士兵老师的四集系列之并发容器
 *
 * 注意：视频1的重点就是实现这个并发容器（看原理可以多看这段视频，但使用的时候还是使用JCF的比较好）
 *
 * @author :liuyang(wx)
 * @date :2022/2/15 13:50
 */
public class ProducerConsumer {

    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Queue.html
    private static Queue<WoTou> queue = new ConcurrentLinkedQueue<>();// LinkedBlockingQueue
    public static final int MAX_QUEUE_SIZE = 10;
    public static final int PRODUCER_SLEEP_SECONDS = 4;// 3, 1
    public static final int CONSUMER_SLEEP_SECONDS = 1;

    public static void main(String[] args) {
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}

@AllArgsConstructor
@ToString
class WoTou {
    String id;
}

class Producer implements Runnable {
    private Queue<WoTou> queue;
    private boolean flag = true;

    Producer(Queue<WoTou> q) {
        queue = q;
    }

    @Override
    public void run() {
        while (flag) {
            if (queue != null && queue.size() <= ProducerConsumer.MAX_QUEUE_SIZE) {
                queue.offer(new WoTou(UUID.randomUUID().toString()));
            }
            try {
                TimeUnit.SECONDS.sleep(ProducerConsumer.PRODUCER_SLEEP_SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown() {
        flag = false;
    }
}

class Consumer implements Runnable {
    private Queue<WoTou> queue;
    private boolean flag = true;

    Consumer(Queue<WoTou> q) {
        queue = q;
    }

    @Override
    public void run() {
        while (flag) {
            if (queue != null && !queue.isEmpty()) {
                System.out.println("消费:" + queue.poll() + " queue.size() = " + queue.size());// queue.remove()
            }
            try {
                TimeUnit.SECONDS.sleep(ProducerConsumer.CONSUMER_SLEEP_SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown() {
        flag = false;
    }
}