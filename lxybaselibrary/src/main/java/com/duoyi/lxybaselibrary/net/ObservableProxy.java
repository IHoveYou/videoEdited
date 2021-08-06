package com.duoyi.lxybaselibrary.net;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ObservableProxy<T> {

    /**
     * 接口返回的原始对象
     */
    private Observable<T> mObservable;

    public ObservableProxy(Observable<T> observable) {
        this.mObservable = observable;
    }

//    /**
//     * 用作接口绑定页面的生命周期，当然也可以对其他实现了{@link ILifeCycle}类的对象绑定
//     *
//     * @param key
//     * @return
//     */
//    public Observable<T> bind(ILifeCycle key) {
//        if (key == null) {
//            throw new RuntimeException("the key to bind lifecycle can not be null");
//        }
//        return mObservable.takeUntil(key.getLifeCycleObservable().get());
//    }

    /**
     * 返回原始的observable
     * 当我们需要对原始对象做一些复杂操作的时候可以调用此方法拿到原始observable
     * * @return
     */
    public Observable<T> origin() {
        return mObservable;
    }

    /**
     * 直接调用原始对象的方法，因为此方法是一定会调用的方法，所以对此方法做了代理
     * 因此大部分情况下我们可以省去调用{@link #origin()}方法
     *
     * @param subscriber
     * @return
     */
    public final Subscription subscribe(Subscriber<? super T> subscriber) {
        return mObservable.subscribe(subscriber);
    }

    public final Subscription subscribe() {
        return mObservable.subscribe(new Subscriber<T>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(T t) {

            }
        });
    }

    /**
     * 对接口返回的observable做简单的线程配置，封装成代理类返回
     *
     * @param observable 接口返回的observable对象
     * @param <T>
     * @return
     */
    public static <T> ObservableProxy<T> createProxy(Observable<T> observable) {

        Observable observable1 = observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());


        return new ObservableProxy(observable1);
    }
}
