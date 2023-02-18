/**
 *  it老齐(齐毅)
 *  https://www.itlaoqi.com/chapter.html?sid=98&cid=1425
 *
 * 粘贴自购买的齐毅的课程
 * 0. 课程导学（不用再听了）
 * 1. 并发背后的故事 liuyang.concurrency202302.concurrency.DownloadsSample
 * 2. 概念（听听就好，相关概念以王道408题目为准）
 *      进程、线程、并发、并行、同步、异步、
 *      临界区、死锁、饥饿、活锁（互相让）、
 *      线程安全：在拥有共享数据的多条线程并行执行的程序中，线程安全的代码会通过同步机制保证各个线程都可以正常而且正确的执行，不会出现数据污染等意外情况。
 *
 * 3. JMM
 * liuyang/concurrency202302/jmm/Employee.java
 *  与马士兵讲得一致，就当做复习。
 *
 * 4. Thread
 * liuyang/concurrency202302/thread/Match1.java
 * 5. Runnable
 * liuyang/concurrency202302/thread/Match2.java
 * 6. Callable
 * liuyang/concurrency202302/thread/Match3.java
 *
 * 7. 线程同步
 * liuyang/concurrency202302/thread/SyncSample.java
 * synchronize可以使用在以下三种场景，对应不同锁对象：
 * synchronized代码块 - 任意对象即可
 * synchronized方法 - this当前对象
 * synchronized静态方法 - 该类的字节码对象
 *
 * 8. 线程的五种状态
 *  1. 新建(new), --start()--> 2. 就绪（ready），--CPU时间片 run() --> 3. 运行（running）, --I/O, sleep(), lock, yield() --> 4. 阻塞（blocked）
 *  5. 死亡（dead）
 *
 * 9. 死锁
 * liuyang.concurrency202302.thread.DeadLock
 * 对策：
 *  1. 多副本
 *  2. 用完马上释放（一次申请所有所需资源（申请不到就失败））
 *
 * 10. 线程安全
 * 加锁
 * 线程安全（不安全）类举例：
 *  Vector（ArrayList/LinkedList）、
 *  Properties(HashSet/TreeSet)
 *  StringBuffer(StringBuilder)
 *  HashTable(HashMap)
 *
 * 11. JUC与线程池
 * Executors
 * liuyang.concurrency202302.juc.ThreadPoolSample1
 * liuyang.concurrency202302.juc.ThreadPoolSample2
 * liuyang.concurrency202302.juc.ThreadPoolSample3
 * liuyang.concurrency202302.juc.ThreadPoolSample4
 *
 * 12. CountDownLatch
 * liuyang.concurrency202302.juc.CountDownSample
 *
 * 13. Semaphore
 * liuyang.concurrency202302.juc.SemaphoreSample1
 * liuyang.concurrency202302.juc.SemaphoreSample2
 *
 * 14. CyclicBarrier
 * liuyang.concurrency202302.juc.CyclicBarrierSample
 *
 * 15. ReentrantLock
 * liuyang.concurrency202302.juc.ReentrantLockSample
 *
 * 16. Condition
 * 需要配合ReentrantLock使用
 *
 * 17. Callable & Future
 * 获取线程返回值
 * liuyang/concurrency202302/juc/FutureSample.java
 *
 * 18. 同步容器（副本）
 * ArrayList    CopyOnWriteArrayList    写时复制列表（看add方法，就是一个可重入锁的使用实例！）
 * HashSet      CopyOnWriteArraySet     写时复制集合
 * HashMap      ConcurrentHashMap       分段所映射
 *
 * 19. Atomic
 * liuyang.concurrency202302.juc.AtomicIntegerSample
 *
 * @author xconf
 * @since 2023/2/17
 */
package liuyang.concurrency202302;