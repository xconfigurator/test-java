/**
 * 视频时间线：（完整视频大概2小时）
 * 1. 00:00 从单例讲起，介绍一种不需要加锁也可以懒加载的方式。singleton/
 * 2. 12:40 从卖票的业务场景逐步引入并发容器。ticketseller
 *      synchronized 悲观锁
 *      cas （ConcurrentLinkedQueue ...） 乐观锁
 * 3. 31:40 并发容器
 *
 */
package liuyang.concurrency2018.concurrentcontainer;