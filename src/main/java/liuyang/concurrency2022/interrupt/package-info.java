/**
 * 灰_灰
 * 08 线程中断（了解即可）
 * 线程中断是很久之前做线程间通信使用的，现在已经有了更好的手段。
 * 线程间通信 - 控制线程的运行状态：什么时候该运行，什么时候该暂停。
 * 线程状态：见Thread的内部枚举State
 * 线程抛出InterruptedException的理由：
 *  让你知道线程回到运行状态的原因。
 *
 * 问题:
 * 1. 线程在sleep的时候是什么状态？
 *      TIMED_WAITING
 * 2. 在哪些情况下会抛出InterruptedException？
 *      BLOCKED/WAITING/TIMED_WAITING 这三种状态
 *      或者从这三种状态转换到RUNNABLE状态的途中被中断
 *      状态的装换详细参见Thread类的State枚举。
 * 3. 如果线程没有睡眠，调用它的interrupt会怎样？
 *      运行态的线程默认会忽略，除非线程内部编码处理中断。
 *      检测：
 *          public boolean isInterrupted()
 *          public static boolean interrupted()
 *
 */
package liuyang.concurrency2022.interrupt;