package liuyang.designpatterns.observer.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 参考视频（马士兵老师）：https://ke.qq.com/course/429389?taid=3506376941145421
 * RxJava对事件源对象和事件的订阅做了很好的封装。
 * 注：可以看到，被观察者和观察者可以分别独立定义，这样就完成了解耦合。
 * Consumer版本
 *
 * @author liuyang
 * @date   2021/7/31
 */
@Slf4j
public class HelloRx01 {
    public static void main(String[] args) {
        // 事件源对象（被观察者）
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("hello, RxJava");
                observableEmitter.onNext("learn from mashibing");
            }
        });

        // 消费者（观察者）
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                log.info(Thread.currentThread().getName() + " == consumer == " + s);
            }
        };

        // 建立关系（同步 在同一个线程中执行）
        //observable.subscribe(consumer);

        // 建立关系（异步 在不同的线程中执行）
        observable.observeOn(Schedulers.newThread()).subscribe(consumer); // Scheduler
        try {
            // 等一会让那个线程执行完。
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
