package com.duoyi.lxybaselibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.duoyi.lxybaselibrary.R;
import com.duoyi.lxybaselibrary.utils.AppUtils;
import com.duoyi.lxybaselibrary.utils.ToastUtils;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;


/**
 * 作者 lxy on Time 2020-08-1314:22.
 * 上有天，下有地，中间站着你自己，做一天人，尽一天人事儿
 * 人生是一个永不停息的工厂，那里没有懒人的位置。工作吧！创造吧！
 */
public abstract class BaseFragment<B extends ViewDataBinding, VM extends BaseVM> extends Fragment implements BaseView<VM> {
    public View contentView;
    public B mBinding;
    public VM mVM;
    public ViewGroup flContext;
    public ViewGroup flErr;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (!EventBus.getDefault().isRegistered(this)
        ) {
            EventBus.getDefault().register(this);
        }
        mVM = createVM();
        super.onCreate(savedInstanceState);
        contentView = (ViewGroup) LayoutInflater.from(getActivity()).inflate(R.layout.base_fragment, null, false);

        flContext = contentView.findViewById(R.id.fl_context);
        flErr = contentView.findViewById(R.id.fl_err);

        mBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), getLayout(), null, false);
        flContext.addView(mBinding.getRoot());

        init();
        return contentView;
    }

    private void init() {
        try {
            initView();
            initData();
        } catch (Exception e) {
            ToastUtils.showMessage("程序出现错误,请刷新重试");

        }

    }

    public void setErrLayout(View errLayout) {
        flErr.setVisibility(View.VISIBLE);
        flErr.removeAllViews();
        flErr.addView(errLayout);
    }

    public View showErr(@DrawableRes int icon, String err) {

        View errLayout = LayoutInflater.from(getActivity()).inflate(R.layout.layout_err, flErr, false);
        errLayout.setOnClickListener(view -> {});

        if (flErr==null)
            return errLayout;

        flErr.setVisibility(View.VISIBLE);
        flErr.removeAllViews();
        flErr.addView(errLayout);
        flErr.setPadding(0, 0,0,0);
        ImageView iv = flErr.findViewById(R.id.iv_err);
        TextView tv = flErr.findViewById(R.id.tv_err);

        if (iv == null)
            return errLayout;
        iv.setImageResource(icon);
        tv.setText(err);
        return errLayout;
    }

    public View showErr(@DrawableRes int icon, String err,int marginTop) {
        View errLayout = LayoutInflater.from(getActivity()).inflate(R.layout.layout_err, flErr, false);
        errLayout.setOnClickListener(view -> {});

        if (flErr==null)
            return errLayout;

        flErr.setVisibility(View.VISIBLE);
        flErr.removeAllViews();
        flErr.addView(errLayout);
        flErr.setPadding(0, AppUtils.dp2px(getActivity(),marginTop),0,0);
        ImageView iv = flErr.findViewById(R.id.iv_err);
        TextView tv = flErr.findViewById(R.id.tv_err);
        if (iv == null)
            return errLayout;
        iv.setImageResource(icon);
        tv.setText(err);
        return errLayout;
    }
    public View showErr(@DrawableRes int icon, String err,int marginTop,int marginBtn) {
        View errLayout = LayoutInflater.from(getActivity()).inflate(R.layout.layout_err, flErr, false);
        errLayout.setOnClickListener(view -> {});

        if (flErr==null)
            return errLayout;

        flErr.setVisibility(View.VISIBLE);
        flErr.removeAllViews();
        flErr.addView(errLayout);
        flErr.setPadding(0, AppUtils.dp2px(getActivity(),marginTop),0,AppUtils.dp2px(getActivity(),marginBtn));
        ImageView iv = flErr.findViewById(R.id.iv_err);
        TextView tv = flErr.findViewById(R.id.tv_err);
        if (iv == null)
            return errLayout;
        iv.setImageResource(icon);
        tv.setText(err);
        return errLayout;
    }
    public View showErrpx(@DrawableRes int icon, String err,int marginTop) {
        View errLayout = LayoutInflater.from(getActivity()).inflate(R.layout.layout_err, flErr, false);
        errLayout.setOnClickListener(view -> {});

        if (flErr==null)
            return errLayout;

        flErr.setVisibility(View.VISIBLE);
        flErr.removeAllViews();
        flErr.addView(errLayout);
        flErr.setPadding(0, marginTop,0,0);
        ImageView iv = flErr.findViewById(R.id.iv_err);
        TextView tv = flErr.findViewById(R.id.tv_err);
        if (iv == null)
            return errLayout;
        iv.setImageResource(icon);
        tv.setText(err);
        return errLayout;
    }

    public void hiddenErrLayout() {
        flErr.setVisibility(View.GONE);
    }


    @Override
    public void onResume() {
        super.onResume();
        if (mVM != null)
        refresh();
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            if (mVM != null)
            refresh();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (mVM != null)
            refresh();
        }
    }

    //刷新
    public void refresh() {

    }
    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onGetMessage(String message) {

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
        if (mVM!=null)mVM.onDestroy();
        mVM=null;
        mBinding=null;
    }


    public int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
