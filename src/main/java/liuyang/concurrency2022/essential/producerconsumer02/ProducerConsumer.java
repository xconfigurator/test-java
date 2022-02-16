package liuyang.concurrency2022.essential.producerconsumer02;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * 并发容器 wait notify
 * 注意：JUC容器是锁不住的！
 *
 * 视频参考1: 11_线程同步_7_生产者消费者问题 5:18开始
 * 视频参考2: 看马士兵老师的四集系列之并发容器
 *
 * 注意：视频1的重点就是实现这个并发容器（看原理可以多看这段视频，但使用的时候还是使用JCF的比较好）
 *
 * @author :liuyang(wx)
 * @date :2022/2/15 16:19
 */
public class ProducerConsumer {
    // wait notify是需要在临界区容器上面使用的

    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html
    // wait         Causes the current thread to wait until it is awakened, typically by being notified or interrupted.
    // notify       Wakes up a single thread that is waiting on this object's monitor.
    // notifyAll    Wakes up all threads that are waiting on this object's monitor.

    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Queue.html
    private static Queue<WoTou> queue = new ConcurrentLinkedQueue<>();// LinkedBlockingQueue
    public static final int MAX_QUEUE_SIZE = 10;
    public static final int PRODUCER_SLEEP_SECONDS = 1;// 3, 1
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

            /*if (queue != null && queue.size() >= ProducerConsumer.MAX_QUEUE_SIZE) {
                try {
                    queue.wait();// JUC容器是锁不住的，里面都不是synchronized方法
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
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

            /*
            if (queue != null && queue.isEmpty()) {
                queue.notifyAll();// JUC容器是锁不住的，里面都不是synchronized方法
            }
             */
            /*if (queue != null && queue.size() <= ProducerConsumer.MAX_QUEUE_SIZE) {
                queue.notifyAll();// JUC容器是锁不住的，里面都不是synchronized方法
            }*/

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
