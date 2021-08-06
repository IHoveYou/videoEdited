package com.duoyi.lxybaselibrary.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.duoyi.lxybaselibrary.R;
import com.duoyi.lxybaselibrary.base.BaseDialog;
import com.duoyi.lxybaselibrary.base.BaseVM;
import com.duoyi.lxybaselibrary.databinding.BaseDialogBinding;
import com.duoyi.lxybaselibrary.minterface.BaseDialogCallBack;
import com.duoyi.lxybaselibrary.minterface.SingleClickListener;

import static android.R.style.Theme_Material_Dialog_Alert;
import static android.view.animation.Animation.RELATIVE_TO_SELF;


/**
 * 作者 lxy on Time 2020-11-1315:11.
 * 上有天，下有地，中间站着你自己，做一天人，尽一天人事儿
 * 人生是一个永不停息的工厂，那里没有懒人的位置。工作吧！创造吧！
 * 公用dialog
 */
public class DialogUtils extends BaseDialog<BaseDialogBinding, BaseVM> {
    BaseDialogCallBack callBack;
    SingleClickListener singleClickListener;
    String title;
    String content;
    String leftText;
    String rightText;
    String buttonText;
    String tost;


    @Override
    public int getLayout() {
        return R.layout.base_dialog;
    }

    @Override
    public BaseVM createVM() {
        return null;
    }

    @Override
    public void initView() {
        title = getString("title", "");
        leftText = getString("leftText", "");
        rightText = getString("rightText", "");
        buttonText = getString("buttonText", "");
        content = getString("content", "");
        tost = getString("tost", "");
    }

    @Override
    public void initData() {
        mBinding.tvTost.setVisibility(StringUtil.isEmpty(tost) ? View.GONE : View.VISIBLE);
        mBinding.tvTitle.setVisibility(StringUtil.isEmpty(title) ? View.GONE : View.VISIBLE);
        mBinding.tvConent.setVisibility(StringUtil.isEmpty(content) ? View.GONE : View.VISIBLE);
        mBinding.tvTitle.setText(title);



        mBinding.tvConent.setText(Html.fromHtml(content));

        if (!StringUtil.isEmpty(buttonText)) {
            mBinding.tvLeftText.setVisibility(View.GONE);
            mBinding.v.setVisibility(View.GONE);
            mBinding.tvRightText.setText(buttonText);
            mBinding.tvRightText.setOnClickListener(view -> {
                dismiss();
                if (singleClickListener != null) {
                    singleClickListener.onClick(view);
                }
            });
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        return true;
                    }
                    return false;
                }
            });
        } else {
            mBinding.tvLeftText.setText(leftText);
            mBinding.tvRightText.setText(rightText);
            mBinding.tvLeftText.setOnClickListener(view -> {
                dismiss();
                if (callBack != null) {
                    callBack.onLeftClick(view);
                }
            });
            mBinding.tvRightText.setOnClickListener(view -> {
                dismiss();
                if (callBack != null) {
                    callBack.onRightText(view);
                }
            });
        }


    }


    public static DialogUtils newInstance(String title, String content, String leftText, String rightText, String button) {
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("content", content);
        args.putString("leftText", leftText);
        args.putString("rightText", rightText);
        args.putString("buttonText", button);

        DialogUtils fragment = new DialogUtils();
        fragment.setArguments(args);
        return fragment;
    }

    public static DialogUtils newInstance(String title, String content, String leftText, String rightText, String button, String tost) {
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("tost", tost);
        args.putString("content", content);
        args.putString("leftText", leftText);
        args.putString("rightText", rightText);
        args.putString("buttonText", button);

        DialogUtils fragment = new DialogUtils();
        fragment.setArguments(args);
        return fragment;
    }

    public static void show(@NonNull FragmentManager manager, String title, String tost, String content, String leftText, String rightText, BaseDialogCallBack callBack) {
        DialogUtils utils = newInstance(title, content, leftText, rightText, "", tost);
        utils.setCallBack(callBack);
        utils.show(manager, title);
    }

    public static void show(@NonNull FragmentManager manager, String title, String content, String leftText, String rightText, BaseDialogCallBack callBack) {
        DialogUtils utils = newInstance(title, content, leftText, rightText, "");
        utils.setCallBack(callBack);
        utils.show(manager, title);
    }

    public static void show(@NonNull FragmentManager manager, String title, String leftText, BaseDialogCallBack callBack) {
        DialogUtils utils = newInstance(title, "", leftText, "取消", "");
        utils.setCallBack(callBack);
        utils.show(manager, title);
    }

    public static void show(@NonNull FragmentManager manager, String title, String leftText, String rightTetx, BaseDialogCallBack callBack) {
        DialogUtils utils = newInstance(title, "", leftText, rightTetx, "");
        utils.setCallBack(callBack);
        utils.show(manager, title);
    }


    public static void showSingle(@NonNull FragmentManager manager, String title, String button, SingleClickListener singleClickListener) {
        DialogUtils utils = newInstance(title, "", "", "", button);
        utils.setSingleClickListener(singleClickListener);
        utils.show(manager, title);
    }

    public static DialogUtils showSingle(@NonNull FragmentManager manager, String title, String content, String button, SingleClickListener singleClickListener) {
        DialogUtils utils = newInstance(title, content, "", "", button);
        utils.setSingleClickListener(singleClickListener);
        utils.show(manager, title);
        return utils;
    }


    public static Dialog loding(Activity activity) {
        return loding(activity, "正在加载...");
    }

    public static Dialog loding(Activity activity, String message) {
        return loding(activity, message, true);
    }

    /**
     * 加载中对话框，ui类似toast
     *
     * @param activity
     * @param message
     * @param cancelable
     * @return
     */
    public static Dialog loding(Activity activity, String message, boolean cancelable) {
        if (activity == null) {
            return null;
        }
        Dialog dialog = new Dialog(activity, Theme_Material_Dialog_Alert);
        dialog.setCancelable(cancelable);
        dialog.setCanceledOnTouchOutside(cancelable);

        View rootView = LayoutInflater.from(activity).inflate(R.layout.common_popupview, null);
        ImageView ivIcon = (ImageView) rootView.findViewById(R.id.popupview_loading_iv);
        TextView tvMessage = (TextView) rootView.findViewById(R.id.popupview_loading_tv);
        tvMessage.setText(message);

        RotateAnimation animation = new RotateAnimation(0, 359, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(2000);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        ivIcon.startAnimation(animation);
        dialog.getWindow().setDimAmount(0);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(rootView);
        return dialog;
    }

    public void setSingleClickListener(SingleClickListener singleClickListener) {
        this.singleClickListener = singleClickListener;
    }

    public void setCallBack(BaseDialogCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void show(@NonNull FragmentManager manager, @Nullable String tag) {
        super.show(manager, tag);
    }
    public DialogUtils setBaseCallBack(BaseDialog.BaseDialogCallback baseCallBack){
        super.setCallback(baseCallBack);
        return this;
    }
}
