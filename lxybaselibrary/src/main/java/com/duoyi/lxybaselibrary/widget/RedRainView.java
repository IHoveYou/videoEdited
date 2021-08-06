package com.duoyi.lxybaselibrary.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.duoyi.lxybaselibrary.utils.TimeUtils;

import java.util.ArrayList;

/**
 * 作者 lxy on Time 2020-10-2015:46.
 * 上有天，下有地，中间站着你自己，做一天人，尽一天人事儿
 * 人生是一个永不停息的工厂，那里没有懒人的位置。工作吧！创造吧！
 * <p>
 * 红包雨
 */
public class RedRainView extends RelativeLayout {
    int height;
    int wide;
    ArrayList<RedView> redViews = new ArrayList<>();

    public RedRainView(@NonNull Context context) {
        super(context);
    }

    public RedRainView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RedRainView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init() {
        post(new Runnable() {
            @Override
            public void run() {
                height = getMeasuredHeight();
                wide = getMeasuredWidth();
            }
        });
    }

    public void start() {
        TimeUtils.newInstance().setCallBack(onTimeCallListent);
        mHandler.postDelayed(r, 1000);

    }

    TimeUtils.OnTimeCallListent onTimeCallListent = new TimeUtils.OnTimeCallListent() {
        @Override
        public void onTime(long time) {
            int number = 10 + (int) (Math.random() * 5);
            for (int i = 0; i < number; i++) {
                RedView redView = new RedView(getContext());
                addView(redView);
                redView.init(RedRainView.this);
                redViews.add(redView);
            }

        }
    };


    final Handler mHandler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            ArrayList<RedView> redViews1 = new ArrayList<>();
            for (int i = 0; i < redViews.size(); i++) {
                RedView redView = redViews.get(i);
                redView.refresh();
                if (!redView.isOut)
                    redViews1.add(redView);
            }

            redViews.clear();
            redViews.addAll(redViews1);

            mHandler.postDelayed(this, 2);
        }
    };
}
