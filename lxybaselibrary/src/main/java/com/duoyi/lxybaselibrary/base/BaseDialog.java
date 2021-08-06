package com.duoyi.lxybaselibrary.base;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;

/**
 * 作者 lxy on Time 2020-08-1314:23.
 * 上有天，下有地，中间站着你自己，做一天人，尽一天人事儿
 * 人生是一个永不停息的工厂，那里没有懒人的位置。工作吧！创造吧！
 */
public abstract class BaseDialog<B extends ViewDataBinding, VM extends BaseVM> extends DialogFragment implements BaseView<VM> {
    public BaseDialogCallback baseCallBack;
    public View contentView;
    public B mBinding;
    public VM mVM;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mVM = createVM();
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), getLayout(), null, false);
        contentView = mBinding.getRoot();
        init();

        return contentView;
    }

    private void init() {
        initView();
        initData();
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window win = getDialog().getWindow();
            // 一定要设置Background，如果不设置，window属性设置无效
            win.setBackgroundDrawable(new ColorDrawable(0x00000000));
            WindowManager.LayoutParams params = win.getAttributes();
            params.gravity = Gravity.CENTER;
            // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            params.height = ViewGroup.LayoutParams.MATCH_PARENT;
            win.setAttributes(params);
        }
    }

    //刷新
    public void refresh() {

    }

    public String getString(String key, String def) {
        return getArguments().getString(key, def);

    }

    public BaseDialog setCallback(BaseDialogCallback callback) {
        this.baseCallBack = callback;
        return this;
    }

    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        if (baseCallBack!=null)
            baseCallBack.onDismiss();
    }

    public interface BaseDialogCallback {
        void onDismiss();

        void onSuccess(Object object);
    }
}
