package com.duoyi.lxybaselibrary;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.duoyi.lxybaselibrary.net.RxRetrofitClient;
import com.duoyi.lxybaselibrary.net.dialog.HttpDialogManager;
import com.duoyi.lxybaselibrary.net.dialog.HttpToastManager;
import com.duoyi.lxybaselibrary.net.interceptor.CapInterceptor;
import com.duoyi.lxybaselibrary.receiver.ConnectionChangeReceiver;
import com.duoyi.lxybaselibrary.utils.CrashHandlerUtil;
import com.duoyi.lxybaselibrary.utils.DialogUtils;
import com.duoyi.lxybaselibrary.utils.ToastUtils;
import com.duoyi.lxybaselibrary.widget.textview.OneTextView;
import com.duoyi.lxybaselibrary.widget.textview.ThreeTextView;
import com.duoyi.lxybaselibrary.widget.textview.TwoTextView;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;

import de.greenrobot.event.EventBus;


/**
 * Created by Tany on 2018/6/4.
 * Desc:
 */


public abstract class BaseApplication extends Application {
    private static BaseApplication application;
    public static final String TOKEN_FAILURE="token_failure";//登录失效
    public static synchronized BaseApplication getInstance() {
        return application;
    }

    public abstract String getToken();

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;

//        initTextView();

//        new ANRWatchDog().start();

    }


    public void initSdk(){
        /**
         *解决未捕获异常引起的崩溃
         */
        CrashHandlerUtil crashHandlerUtil = CrashHandlerUtil.getInstance();
        crashHandlerUtil.init(getApplicationContext());

        /**
         * 动态注册网络监听广播
         */
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");  //添加要收到的广播
        ConnectionChangeReceiver networkChangeReceiver = new ConnectionChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);

        initHttp();
    }

    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.white, R.color.gray1);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }


    public void initTextView(int[] size, int[] color) {
        OneTextView.setSize(size[0]);
        TwoTextView.setSize(size[1]);
        ThreeTextView.setSize(size[2]);

        OneTextView.setColor(color[0]);
        TwoTextView.setColor(color[1]);
        ThreeTextView.setColor(color[2]);


    }

    /**
     * 返回当前程序版本号
     */
    public double getAppVersionCode() {
        double versioncode = 0;
        try {
            PackageManager pm = getPackageManager();
            PackageInfo pi = pm.getPackageInfo(getPackageName(), 0);
            // versionName = pi.versionName;
            versioncode = pi.versionCode;
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versioncode;
    }

    /**
     * 返回当前程序版本名
     */
    public String getAppVersionName() {
        String versionName = null;
        try {
            PackageManager pm = getPackageManager();
            PackageInfo pi = pm.getPackageInfo(getPackageName(), 0);
            versionName = pi.versionName;
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc(); // 垃圾回收
    }


    private void initHttp() {
//        SignVerification.CapParams params = new SignVerification.CapParams(getApplicationContext());
        CapInterceptor capInterceptor = new CapInterceptor();
        RxRetrofitClient.Builder builder = new RxRetrofitClient.Builder()
                .cookiesContext(getApplicationContext())//cookie本地持久化
                .connectTimeout(10000)
                .interceptor(capInterceptor)//拦截器 加公共参数 验签 需要
                .httpToast(new HttpToastManager() {
                    @Override
                    public void showToast(String message) {
                        ToastUtils.showMessage(message);
                    }
                })
                .httpDialog(new HttpDialogManager() {
                    @Override
                    public Dialog showLoadingDialog(Activity activity) {
                        try {
                            if (activity != null && !activity.isFinishing()) {
                                Dialog dialog = DialogUtils.loding(activity);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.show();
                                return dialog;
                            }
                            return null;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                });


        RxRetrofitClient.init(builder);
    }


    public void outLogIn() {
        AppManager.getManager().finishAll();
        Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }


    public void outTLogIn() {

    }

    /**
     * 用户掉线
     */
    public void lost(){
        registerServer();
        EventBus.getDefault().post(BaseApplication.TOKEN_FAILURE);
    }

    /**
     * 判断并注册服务
     */
    public void registerServer(){

    }

    public abstract void setChat();
}
