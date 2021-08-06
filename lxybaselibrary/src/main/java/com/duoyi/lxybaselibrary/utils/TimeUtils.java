package com.duoyi.lxybaselibrary.utils;

import android.os.Handler;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;

//全局唯一计时器 节省资源
public class TimeUtils {

    private static TimeUtils timeUtils;
    ArrayList<WeakReference<OnTimeCallListent>> listents = new ArrayList<>();


    private TimeUtils() {
        mHandler.postDelayed(r, 1000);//延时1000毫秒
    }

    public static synchronized TimeUtils newInstance() {
        if (timeUtils == null) {
            timeUtils = new TimeUtils();
        }
        return timeUtils;
    }

    //向计时器注册回调 无需手动释放 当回调被销毁自动释放 需要注意回调生命周期 匿名回调会被系统直接回收
    public void setCallBack(OnTimeCallListent onTimeCallListent) {
        WeakReference<OnTimeCallListent> weakReference = new WeakReference<>(onTimeCallListent);
        listents.add(weakReference);
    }

    public interface OnTimeCallListent {
        public void onTime(long time);
    }


    final Handler mHandler = new Handler();
    Runnable r = new Runnable() {

        @Override
        public void run() {
            ArrayList<WeakReference<OnTimeCallListent>> mList = new ArrayList<>();
            for (int i = 0; i < listents.size(); i++) {
                OnTimeCallListent listent = listents.get(i).get();
                if (listent != null) {
                    mList.add(listents.get(i));
                    try {
                        listent.onTime(getLongTime() / 1000);

                    }catch (Exception err){
                        LogUtil.e("倒计时出现错误");
                    }
                }
            }
            listents.clear();
            listents = mList;
            mHandler.postDelayed(this, 1000);
        }
    };

    public static Date getDate() {
        Date date = new Date(System.currentTimeMillis());
        return date;
    }

    public static long getLongTime() {
        long dateTime = getDate().getTime();
        return dateTime;
    }
}
