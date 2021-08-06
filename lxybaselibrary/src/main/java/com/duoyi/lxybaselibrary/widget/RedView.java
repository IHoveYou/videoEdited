package com.duoyi.lxybaselibrary.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatImageView;

import com.duoyi.lxybaselibrary.R;
import com.duoyi.lxybaselibrary.base.BaseActivity;


/**
 * 作者 lxy on Time 2020-10-2015:54.
 * 上有天，下有地，中间站着你自己，做一天人，尽一天人事儿
 * 人生是一个永不停息的工厂，那里没有懒人的位置。工作吧！创造吧！
 */
public class RedView extends AppCompatImageView {
    int wide;
    int height;
    int v = 1;
    int margTop = 0;
    boolean isOut = false;
    ViewGroup group;
    int maxHeight = 0;

    public RedView(Context context) {
        super(context);
    }

    public RedView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RedView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void init(ViewGroup group) {
        this.group = group;
        isOut = false;
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        int width3 = dm.widthPixels;
        maxHeight = dm.heightPixels;


        v = (int) (8 + Math.random() * 8);
        wide = (int) (BaseActivity.dp2px(getContext(), 40) + BaseActivity.dp2px(getContext(), (int) (Math.random() * 40)));
        height = wide;
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) getLayoutParams();
        params.height = height;
        params.width = wide;
        params.leftMargin = (int) (Math.random() * (width3 - BaseActivity.dp2px(getContext(), 120))
                + BaseActivity.dp2px(getContext(), 40));
        setLayoutParams(params);
        setBackgroundResource(R.mipmap.fenye);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setVisibility(GONE);
                isOut = true;
                RedView.this.group.removeView(RedView.this);
            }
        });
    }


    public void refresh() {
        margTop = v + margTop;
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) getLayoutParams();
        params.topMargin = margTop;
        setLayoutParams(params);
        if (margTop >= maxHeight) {
            isOut = true;
            group.removeView(this);
        }
    }

}
