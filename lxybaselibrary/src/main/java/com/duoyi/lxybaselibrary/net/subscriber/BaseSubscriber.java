package com.duoyi.lxybaselibrary.net.subscriber;


import com.duoyi.lxybaselibrary.net.exception.CCHttpException;
import com.duoyi.lxybaselibrary.net.exception.ExceptionHandler;
import com.duoyi.lxybaselibrary.utils.ToastUtils;

import rx.Subscriber;

/**
 * 封装的HTTP网络协议 通用处理
 * 不包含数据层错误码处理
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    private boolean mShowErrorToast = false;

    public BaseSubscriber() {
        super();
    }

    /**
     * 请求失败  或解析失败是否弹出 message
     * <p>
     * message 包括 后台的message字段 或 本地定义的错误message
     *
     * @param mShowErrorToast 是否显示
     */
    public BaseSubscriber(boolean mShowErrorToast) {
        this();
        this.mShowErrorToast = mShowErrorToast;
    }

    /**
     * http请求成功 && 数据协议转成功  回调
     *
     * @param t
     */
    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    /**
     * http请求失败 || 数据协议转失败  或其他请求导致抛出异常
     * 跟 onCompleted 是冲突方法
     *
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        CCHttpException exception = ExceptionHandler.handleHttpException(e);
        onFailed(exception.mCode, exception.mMessage);
        onFinish();
    }

    /**
     * 执行顺利 没有抛异常
     * 跟 onError 是冲突方法
     */
    @Override
    public void onCompleted() {
        onFinish();
    }

    protected abstract void onSuccess(T data);


    protected void onFailed(String code, String message) {
        if (mShowErrorToast) {
            ToastUtils.showMessage(message);
        }
    }


    /**
     * 不管是成功还是不成功都会回调
     */
    protected abstract void onFinish();
}
