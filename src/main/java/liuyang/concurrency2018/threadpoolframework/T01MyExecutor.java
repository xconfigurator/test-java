package liuyang.concurrency2018.threadpoolframework;

import java.util.concurrent.Executor;

/**
 * https://docs.oracle.com/javase/9/docs/api/java/util/concurrent/Executor.html
 */
public class T01MyExecutor implements Executor {

	public static void main(String[] args) {
		new T01MyExecutor().execute(() -> System.out.print("hello, executor"));
	}

	@Override
	public void execute(Runnable command) {
		//new Thread(command).run();
		command.run();
	}
	
}
