package com.duoyi.lxybaselibrary.base;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.duoyi.lxybaselibrary.AppManager;
import com.duoyi.lxybaselibrary.R;
import com.duoyi.lxybaselibrary.utils.AppUtils;
import com.duoyi.lxybaselibrary.utils.StatusBarUtil;
import com.duoyi.lxybaselibrary.utils.ToastUtils;
import com.duoyi.lxybaselibrary.widget.BaseTitleView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;


/**
 * 作者 lxy on Time 2020-08-1314:22.
 * 上有天，下有地，中间站着你自己，做一天人，尽一天人事儿
 * 人生是一个永不停息的工厂，那里没有懒人的位置。工作吧！创造吧！
 */
public abstract class BaseActivity<B extends ViewDataBinding, VM extends BaseVM> extends AppCompatActivity implements BaseView<VM>, View.OnClickListener {
    public View contentView;
    public B mBinding;
    public VM mVM;
    public Context mContext;

    public ViewGroup rootView;
    public ViewGroup flContext;
    public ViewGroup fltitle;
    public ViewGroup flErrLayout;

    public BaseTitleView titleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mContext = this;
        if (!EventBus.getDefault().isRegistered(this)
        ) {
            EventBus.getDefault().register(this);
        }
        AppManager.getManager().addActivity(this);
        setContentView(R.layout.base_activity);
        setStatusBar(R.color.white);
        rootView = findViewById(R.id.rootView);
        flContext = findViewById(R.id.fl_context);
        fltitle = findViewById(R.id.fl_title);
        flErrLayout = findViewById(R.id.fl_err);
        mVM = createVM();
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(this), getLayout(), null, false);
        contentView = mBinding.getRoot();
        flContext.addView(contentView);
        init();

    }

    private void init() {
        try {
            initView();
            initData();
        } catch (Exception e) {
            ToastUtils.showMessage("程序出现错误,请刷新重试");
        }
    }






    /**
     * 子类想改变其他颜色就重写这个方法
     */
    protected void setStatusBar(int color) {
        StatusBarUtil.setColor(this, getResources().getColor(color));
    }

    //沉浸式
    protected void hideStatusBar() {
        fltitle.setPadding(0, AppUtils.getStatusBarHeight(this), 0, 0);
        StatusBarUtil.setTranslucentForImageViewInFragment(this, null);
    }

    public void setTitle(String text) {
        initTitle();
        titleView.setTitleText(text);
    }

    public void setTitleLeftImage(int image) {
        titleView.setLeftImage(image);
    }

    public void setTitleLeft(int color, String leftText) {
        initTitle();
        titleView.setLeftTextColor(color);
        titleView.setLeftText(leftText);
    }

    public void setTitleLeft(String leftText) {
        initTitle();
        titleView.setLeftText(leftText);
    }

    public void setTitleRightText(int color, String leftText) {
        initTitle();
        titleView.setRightTextColor(color);
        titleView.setRightText(leftText);
    }

    public void setTitleRightText(String leftText) {
        initTitle();
        titleView.setRightText(leftText);
    }


    public void setRightImage(int image) {
        initTitle();
        titleView.setRightImg(image);
    }


    private void initTitle() {
        if (titleView == null) {
            titleView = new BaseTitleView(this);
            fltitle.addView(titleView, 0);
            titleView.setOnClickListener(this);
            fltitle.setVisibility(View.VISIBLE);
        }
        fltitle.setVisibility(View.VISIBLE);
        rootView.setOnClickListener(this);

    }

    public void hiddenTitle() {
        fltitle.setVisibility(View.GONE);
        if (titleView != null) {
            rootView.removeView(titleView);
        }
    }

    //刷新
    public void refresh() {

    }

    public static int dp2px(Context context, int value) {
        float v = context.getResources().getDisplayMetrics().density;
        return (int) (v * value + 0.5f);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mVM != null)
            refresh();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_leftText) {
            leftTextOnClick();
        } else if (id == R.id.iv_left) {
            leftImgOnClick();
        } else if (id == R.id.tv_rightText) {
            rightTextOnClick();
        } else if (id == R.id.iv_right) {
            rightImgOnClick();
        } else if (id == R.id.tv_title) {
            titleTextOnClick();
        } else if (id == R.id.ll_left) {
            leftOnClick();
        } else if (id == R.id.ll_right) {
            rightOnClick();
        }
    }


    public void leftOnClick() {
        finish();
    }

    public void rightOnClick() {
    }

    public void leftTextOnClick() {
        leftOnClick();
    }

    public void rightTextOnClick() {
        rightOnClick();
    }

    public void titleTextOnClick() {
    }

    public void leftImgOnClick() {
        leftOnClick();
    }

    public void rightImgOnClick() {
        rightOnClick();
    }


    public void setErrLayout(View errLayout) {
        flErrLayout.setVisibility(View.VISIBLE);
        flErrLayout.removeAllViews();
        flErrLayout.addView(errLayout);
    }


    public View showErr(@DrawableRes int icon, String err) {
        View errLayout = LayoutInflater.from(this).inflate(R.layout.layout_err, flErrLayout, false);
        errLayout.setOnClickListener(view -> {
        });
        flErrLayout.setVisibility(View.VISIBLE);
        flErrLayout.removeAllViews();
        flErrLayout.addView(errLayout);
        flErrLayout.setPadding(0, 0, 0, 0);
        ImageView iv = flErrLayout.findViewById(R.id.iv_err);
        TextView tv = flErrLayout.findViewById(R.id.tv_err);
        if (iv == null)
            return errLayout;
        iv.setImageResource(icon);
        tv.setText(err);
        return errLayout;
    }


    public View showErr(@DrawableRes int icon, String err, int marginTop,int marginBtn) {
        View errLayout = LayoutInflater.from(this).inflate(R.layout.layout_err, flErrLayout, false);
        errLayout.setOnClickListener(view -> {
        });
        flErrLayout.setVisibility(View.VISIBLE);
        flErrLayout.removeAllViews();
        flErrLayout.addView(errLayout);
        flErrLayout.setPadding(0, AppUtils.dp2px(this, marginTop), 0, AppUtils.dp2px(this, marginBtn));
        ImageView iv = flErrLayout.findViewById(R.id.iv_err);
        TextView tv = flErrLayout.findViewById(R.id.tv_err);
        if (iv == null)
            return errLayout;
        iv.setImageResource(icon);
        tv.setText(err);
        return errLayout;
    }

    public View showErr(@DrawableRes int icon, String err, int marginTop) {
        View errLayout = LayoutInflater.from(this).inflate(R.layout.layout_err, flErrLayout, false);
        errLayout.setOnClickListener(view -> {
        });
        flErrLayout.setVisibility(View.VISIBLE);
        flErrLayout.removeAllViews();
        flErrLayout.addView(errLayout);
        flErrLayout.setPadding(0, AppUtils.dp2px(this, marginTop), 0, 0);
        ImageView iv = flErrLayout.findViewById(R.id.iv_err);
        TextView tv = flErrLayout.findViewById(R.id.tv_err);
        if (iv == null)
            return errLayout;
        iv.setImageResource(icon);
        tv.setText(err);
        return errLayout;
    }

    public void hiddenErrLayout() {
        flErrLayout.setVisibility(View.GONE);
    }

    public void setBtnStyle(boolean isSelect, TextView view, int color) {
        view.setEnabled(isSelect);
        view.setClickable(isSelect);
        view.setTextColor(getResources().getColor(color));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        if (mVM!=null)mVM.onDestroy();
        mVM=null;
        mBinding=null;
    }

    public void hideKeyWork(View view) {
        InputMethodManager manager = ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE));
        if (manager != null)
            manager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

    }

    public String getString(String key) {
        if (getIntent() == null)
            return "";

        return getIntent().getStringExtra(key);
    }



    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onGetMessage(String message) {


    }




    @TargetApi(Build.VERSION_CODES.O)
    private void createNotificationChannel(String channelId, String channelName, int importance) {
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        channel.setShowBadge(true);
        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
    }


    public boolean areNotificationsEnabled() {
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= 24) {
            return mNotificationManager.areNotificationsEnabled();
        } else if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOps =
                    (AppOpsManager) mContext.getSystemService(Context.APP_OPS_SERVICE);
            ApplicationInfo appInfo = mContext.getApplicationInfo();
            String pkg = mContext.getApplicationContext().getPackageName();
            int uid = appInfo.uid;
            try {
                Class<?> appOpsClass = Class.forName(AppOpsManager.class.getName());
                Method checkOpNoThrowMethod = appOpsClass.getMethod("checkOpNoThrow", Integer.TYPE,
                        Integer.TYPE, String.class);
                Field opPostNotificationValue = appOpsClass.getDeclaredField("OP_POST_NOTIFICATION");
                int value = (int) opPostNotificationValue.get(Integer.class);
                return ((int) checkOpNoThrowMethod.invoke(appOps, value, uid, pkg)
                        == AppOpsManager.MODE_ALLOWED);
            } catch (ClassNotFoundException | NoSuchMethodException | NoSuchFieldException
                    | InvocationTargetException | IllegalAccessException | RuntimeException e) {
                return true;
            }
        } else {
            return true;
        }
    }



}
