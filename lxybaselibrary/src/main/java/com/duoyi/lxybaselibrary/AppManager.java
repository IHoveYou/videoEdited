package com.duoyi.lxybaselibrary;

import android.app.Activity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * author : 创建人lxy
 * date : 2021/5/12 11:16
 * version :
 * desc : 于此创建有问题请联系
 */
public class AppManager {
    private static AppManager manager;
    private ArrayList<WeakReference<Activity>> list = new ArrayList<>();

    public static AppManager getManager() {
        if (manager == null)
            manager = new AppManager();
        return manager;
    }


    public void addActivity(Activity activity) {
        list.add(new WeakReference<Activity>(activity));
    }


    public Activity getTopActivity() {
        initActivityList();
        Activity activity = null;
        if (list.size() != 0)
            for (int i = list.size() - 1; i >= 0; i--) {
                Activity mActivity = list.get(i).get();
                if (mActivity != null && !mActivity.isFinishing() && !mActivity.isDestroyed()) {
                    return list.get(i).get();
                }
            }
        return activity;
    }


    private void initActivityList() {
        ArrayList<WeakReference<Activity>> mlist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Activity mActivity = list.get(i).get();
            if (mActivity != null && !mActivity.isFinishing() && !mActivity.isDestroyed()) {
                mlist.add(list.get(i));
            }
        }
        list.clear();
        list.addAll(mlist);
    }

    public void onFinish() {
        initActivityList();
    }


    public void finishActivity(Class clas) {
        String className = clas.getName();
        for (int i = 0; i < list.size(); i++) {
            Activity mActivity = list.get(i).get();
            if (mActivity != null && !mActivity.isFinishing() && !mActivity.isDestroyed() && mActivity.getClass().getName().equals(className)) {
                list.get(i).get().finish();
            }
        }
    }


    public void finishAll() {
        for (int i = 0; i < list.size(); i++) {
            Activity mActivity = list.get(i).get();
            if (mActivity != null && !mActivity.isFinishing() && !mActivity.isDestroyed()) {
                list.get(i).get().finish();
            }
        }
    }

    public Activity getActivity(Class clas) {
        String className = clas.getName();
        for (int i = list.size() - 1; i >= 0; i--) {
            Activity mActivity = list.get(i).get();
            if (mActivity != null && !mActivity.isFinishing() && !mActivity.isDestroyed() && mActivity.getClass().getName().equals(className)) {
                return list.get(i).get();
            }
        }
        return null;
    }

}
