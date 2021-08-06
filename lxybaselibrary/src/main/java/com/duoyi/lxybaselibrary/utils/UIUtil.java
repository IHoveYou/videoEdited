package com.duoyi.lxybaselibrary.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.duoyi.lxybaselibrary.net.dialog.HttpDialogManager;
import com.duoyi.lxybaselibrary.net.dialog.HttpToastManager;


/**
 * Created by yao.dang on 2018/5/9.
 */

public class UIUtil {


    private static final String TAG = "UIUtil";
    private static HttpDialogManager sHttpDialogManager;
    private static HttpToastManager sHttpToastManager;
    private static Dialog sDialog;

    public static void setDialogManager(HttpDialogManager dialog) {
        if (dialog == null) {
            return;
        }
        sHttpDialogManager = dialog;
    }

    public static void removeDialogManager() {
        sHttpDialogManager = null;
    }

    public static void setToastManager(HttpToastManager toast) {
        if (toast == null) {
            return;
        }
        sHttpToastManager = toast;
    }

    public static void removeToastManager() {
        sHttpToastManager = null;
    }

    public static void showToast(String message) {
        if (sHttpToastManager == null) {
            Log.w(TAG, "showLoadingDialog-->you should give the HttpToastManager instance to showToast");
            return;
        }
        sHttpToastManager.showToast(message);
    }

    public static void showLoadingDialog(Activity activity) {
        if (sHttpDialogManager == null) {
            Log.w(TAG, "showLoadingDialog-->you should give the HttpDialogManager instance to showLoadingDialog");
            return;
        }
        if (sDialog != null) {
            sDialog.dismiss();
        }
        sDialog = sHttpDialogManager.showLoadingDialog(activity);
    }

    public static void cancelLoadingDiaoog() {
        if (sDialog == null) {
            return;
        }
        sDialog.dismiss();
        sDialog = null;
    }

    public static void showDownloadDialog(Activity activity) {
//        if (sHttpDialogManager == null) {
//            Log.w(TAG, "showLoadingDialog-->you should give the HttpDialogManager instance to showLoadingDialog");
//            return;
//        }
//        sHttpDialogManager.showDownloadDialog(activity);
    }

    public static void cancelDownloadDiaoog() {
//        if (sHttpDialogManager == null) {
//            Log.w(TAG, "showLoadingDialog-->you should give the HttpDialogManager instance to cancelLoadingDiaoog");
//            return;
//        }
//        sHttpDialogManager.cancelDownloadDialog();
    }

    public static void setProgress(int progress) {
//        if (sHttpDialogManager == null) {
//            Log.w(TAG, "showLoadingDialog-->you should give the HttpDialogManager instance to cancelLoadingDiaoog");
//            return;
//        }
//        sHttpDialogManager.onProgress(progress);
    }

    /**
     * 解决NestedScrollView中嵌套RecyclerView滑动不流畅以及头部被顶出的bug
     */
    public static void setSmooth(RecyclerView recyclerView, Context context) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
//        android:descendantFocusability="blocksDescendants"
    }

    public static void setGridLayoutSmooth(RecyclerView recyclerView, Context context, int count) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, count);
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
//        android:descendantFocusability="blocksDescendants"
    }


    //屏幕分辨率
    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    //屏幕宽度
    public static int getScreenWidth(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    //屏幕高度
    public static int getScreenHeight(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static void setView(View v, float wide, float height) {
        Context context = v.getContext();
        int screenWidth = getScreenWidth(context);

        double key = screenWidth * 1.00 / dip2px(context, 375);

        int mWide = (int) (key * dip2px(context, wide));
        int mHeight = (int) (key * dip2px(context, height));

        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        layoutParams.width = mWide;
        layoutParams.height = mHeight;
        v.setLayoutParams(layoutParams);
    }

}
