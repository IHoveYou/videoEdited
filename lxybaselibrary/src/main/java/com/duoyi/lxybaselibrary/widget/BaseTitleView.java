package com.duoyi.lxybaselibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.duoyi.lxybaselibrary.R;
import com.duoyi.lxybaselibrary.databinding.BaseTitleBinding;

/**
 * 作者 lxy on Time 2020-08-1314:25.
 * 上有天，下有地，中间站着你自己，做一天人，尽一天人事儿
 * 人生是一个永不停息的工厂，那里没有懒人的位置。工作吧！创造吧！
 */
public class BaseTitleView extends FrameLayout implements View.OnClickListener {
    BaseTitleBinding mBinding;

    public BaseTitleView(@NonNull Context context) {
        super(context);
        init();
    }

    public BaseTitleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseTitleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    protected void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.base_title, this, false);
        mBinding = DataBindingUtil.bind(view);
        addView(view);

        mBinding.llLeft.setOnClickListener(this);
        mBinding.tvLeftText.setOnClickListener(this);
        mBinding.tvRightText.setOnClickListener(this);
        mBinding.tvTitle.setOnClickListener(this);
        mBinding.ivLeft.setOnClickListener(this);
        mBinding.ivRight.setOnClickListener(this);

    }


    public void initTitle(int leftImage, String leftText, String title, String rightText, int rightImage) {
        mBinding.ivLeft.setImageResource(leftImage);
        mBinding.tvLeftText.setText(leftText);
        mBinding.tvTitle.setText(title);
        mBinding.tvRightText.setText(rightText);
        mBinding.ivRight.setImageResource(rightImage);
    }


    public void setTitleText(String text) {
        mBinding.tvTitle.setText(text);
    }

    public void setLeftTextColor(@ColorRes int color) {
        mBinding.tvLeftText.setTextColor(getResources().getColor(color));
    }

    public void setTitleTextColor(@ColorRes int color) {
        mBinding.tvTitle.setTextColor(getResources().getColor(color));
    }

    public void setRightTextColor(@ColorRes int color) {
        mBinding.tvRightText.setTextColor(getResources().getColor(color));
    }

    public void setLeftText(String text) {
        mBinding.tvLeftText.setText(text);
    }

    public void setRightText(String text) {
        mBinding.tvRightText.setText(text);
    }

    public void setLeftImage(int res) {
        mBinding.ivLeft.setImageResource(res);
    }

    public void setRightImg(int res) {
        mBinding.ivLeft.setImageResource(res);
    }


    OnClickListener onClickListener;

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        onClickListener = l;
    }

    @Override
    public void onClick(View view) {
        if (onClickListener != null)
            onClickListener.onClick(view);
    }
}
