/**
 * 灰_灰
 * 06 线程池
 * 05:15 左右开始讲解，前面的故事可以不用再看了。
 * 核心：ThreadPoolExecutor
 * 工具：Executors
 *      // 一下都是JDK 8之前的使用方式
 *      ExecutorService.execute(Runnable runnable)
 *                     .summit(Runnable runnable)
 *                     .summit(Callable<T> task)
 *                     .summit(Runnable task, T result)
 *      // JDK8 + 如何使用？ 答：参考completablefuture04_performance
 */
package liuyang.concurrency2022.threadpool;