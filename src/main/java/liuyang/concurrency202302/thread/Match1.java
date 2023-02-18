package liuyang.concurrency202302.thread;

import java.util.Random;

/**
 * 使用集成Thread的方式实现多线程
 * 该程序运行起来至少涉及五个线程（包括gc）
 */
public class Match1 {
    public static void main(String[] args) {
        Runner liuxiang = new Runner();//创建一个新的线程
        liuxiang.setName("刘翔");//设置线程名称
        Runner laoqi = new Runner();
        laoqi.setName("老齐");
        Runner op = new Runner();
        op.setName("路飞");

        liuxiang.start();//启动线程
        laoqi.start();
        op.start();

    }
}
class Runner extends Thread{
    @Override
    public void run() {
        Integer speed = new Random().nextInt(100);
        for(int i = 1 ; i <= 100 ; i++){
            try {
                Thread.sleep(1000); //当前线程休眠1秒
            }catch (Exception e){
                e.printStackTrace();
            }
            //this.getName()打印当前线程的名字
            System.out.println(this.getName() + "已前进" + (i * speed) + "米（" + speed + "米/秒)");
        }
    }
}
