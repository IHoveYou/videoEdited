package com.duoyi.lxybaselibrary.widget.textview;

import android.content.Context;
import android.util.AttributeSet;

import com.duoyi.lxybaselibrary.R;


/**
 * 作者 lxy on Time 2020-08-1314:41.
 * 上有天，下有地，中间站着你自己，做一天人，尽一天人事儿
 * 人生是一个永不停息的工厂，那里没有懒人的位置。工作吧！创造吧！
 */
public class TwoTextView extends BaseTextView {
    private static int size = 14;
    private static int color = R.color.black;

    public TwoTextView(Context context) {
        super(context);
    }

    public TwoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TwoTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init(Context context, AttributeSet attrs) {
        setTextSize(size);
        setTextColor(getResources().getColor(color));
    }


    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        TwoTextView.size = size;
    }

    public static int getColor() {
        return color;
    }

    public static void setColor(int color) {
        TwoTextView.color = color;
    }
}
