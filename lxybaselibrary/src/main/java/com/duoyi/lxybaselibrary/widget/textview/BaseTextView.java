package com.duoyi.lxybaselibrary.widget.textview;


import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * 作者 lxy on Time 2020-08-1314:42.
 * 上有天，下有地，中间站着你自己，做一天人，尽一天人事儿
 * 人生是一个永不停息的工厂，那里没有懒人的位置。工作吧！创造吧！
 */
public abstract class BaseTextView extends AppCompatTextView {
    public BaseTextView(Context context) {
        super(context);
        init(context, null);
    }

    public BaseTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BaseTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    protected abstract void init(Context context, AttributeSet attrs);
}
