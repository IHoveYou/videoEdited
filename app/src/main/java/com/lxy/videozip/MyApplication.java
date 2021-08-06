package com.lxy.videozip;

import android.app.Application;
import android.content.pm.ApplicationInfo;

import com.duoyi.chatmodle.UIUtils;

/**
 * author : 创建人lxy
 * date : 2021/8/6 16:18
 * version :
 * desc : 于此创建有问题请联系
 */
public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        UIUtils.setContext(this);
    }
}
