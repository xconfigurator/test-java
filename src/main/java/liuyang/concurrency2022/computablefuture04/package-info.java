/**
 * 灰_灰
 * 07 CompletableFuture性能 （这里）
 *
 * 1. 如何在大量任务的情况下获得较好的性能。
 *      1.1 什么算是“大量”： 超过CPU可运行线程数 - 1后。这个数是这台机器可以并行执行的任务数量。
 *      1.2 一个管用但不推荐的调整点，设置commonPool的参数。
 *          设置一个合适的并发数。这个值需要靠线上运行调整得出。实测竟然管用！
 *          System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");// 竟然管用！！
 *          但是：一般不要修改！！！不要修改！不要！不！
 *      1.3 单独创建一个自有的线程池，不要使用commonPool，并调整参数。
 *          见_05_customThreadPool.java
 *          使用线程池尽量压榨CPU。
 *      1.4 单台机器达到资源上限后，应考虑增加配置，或者分布式处理。
 *
 * 2. 线程复用问题。
 */
package liuyang.concurrency2022.computablefuture04;