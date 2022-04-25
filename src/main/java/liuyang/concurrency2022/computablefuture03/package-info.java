/**
 * 【小结】
 * supplyAsync      开启启异步任务
 * thenCompose      连接异步任务
 * thenCombine      合并异步任务
 * thenApply        任务后置处理
 * applyToEither    获取最先完成的任务
 * exceptionally    处理异常
 *
 * 【扩展】
 * 维度1. *Async，如thenComposeAsync
 *              thenCompose会把本快代码当做同一个任务提交到线程池
 *              thenComposeAsync会把本快代码当做独立的一个任务提交到线程池
 *              具体是不是在不同的线程中运行，这与线程池的性质和行为有关。
 * 维度2. 在方法签名中执行Executor
 *
 *
 * 【比较1】
 * supplyAsync      有返回值
 * runAsync         无返回值
 *
 * 【比较2】
 * thenApply        以前面任务的返回值为参数，本块代码有返回值。
 * thenAccept       以前面任务的返回值为参数，本块代码无返回值。
 * thenRun          不接收前面任务的返回值，本块代码也无返回值。
 *
 * 【比较3】
 * thenCombine      得到前面两任务的返回值，本块代码有返回值。
 * thenAcceptBoth   得到前面两任务的返回值，本块代码无返回值。
 * runAfterBoth     不接收前面任务的返回值，本块代码无返回值。
 *
 * 【比较4】
 * applyToEither    得到最快执行完的任务的结果，本块代码有返回值。
 * acceptEither     得到最快执行完的任务的结果，本块代码无返回值。
 * runAfterEither   不接收最快执行完任务的结果，本块代码无返回值。
 *
 * 【比较5】
 * exceptionally    处理异常，并将异常修正为一个正常值。
 * handle           参数是BiFunction<? super T, Throwable ? extends U>
 *                  返回CompletionStage<T>
 * whenComplete     参数是BiFunction<? super T, Throwable ? extends U>
 *                  无返回值。
 *
 * 【提醒】
 * join()
 */
package liuyang.concurrency2022.computablefuture03;