package liuyang.designpatterns.observer.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

/**
 * Observer版本
 * Observer是一个更复杂的Consumer版本
 *
 * @author liuyang
 * @date 2021/8/30
 */
@Slf4j
public class HelloRx02 {
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
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {

            }

            @Override
            public void onNext(@NonNull String s) {
                log.info(Thread.currentThread().getName() + " == consumer == " + s);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

        // 建立关系（异步 在不同的线程中执行）
        observable.observeOn(Schedulers.newThread()).subscribe(observer);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
