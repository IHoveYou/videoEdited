package com.duoyi.lxybaselibrary.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.bumptech.glide.Glide;
import com.duoyi.lxybaselibrary.R;
import com.duoyi.lxybaselibrary.utils.StringUtil;
import com.gcssloop.widget.RCImageView;

/**
 * 加载网络图片 圆角/圆形
 */

public class MyRCImageView extends RCImageView {
    public static String IMAGE_URL = "https://pic.csjc19.com";

    TypedArray array;
    Drawable err;

    public MyRCImageView(Context context) {
        super(context);
    }

    public MyRCImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyRCImageView, 0, 0);
        err = array.getDrawable(R.styleable.MyRCImageView_err);
    }

    public MyRCImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyRCImageView, 0, 0);
        err = array.getDrawable(R.styleable.MyRCImageView_err);
    }


    public void setUrl(String url) {
        if (StringUtil.isEmpty(url)) {
            Glide.with(getContext())
                    .load("")
                    .centerCrop()
                    .thumbnail(0.1f)
                    .placeholder(err)
                    .into(this);
            return;
        }
        String murl = "";
        if (url.contains("http")) {
            murl=url;
        } else {
            murl = IMAGE_URL + url;
        }

        //符合标准
        Glide.with(getContext())
                .load(murl)
                .centerCrop()
                .thumbnail(0.1f)
                .placeholder(err)
                .into(this);
    }

    public void setErr(Drawable err) {
        this.err = err;
    }

    public void setSrc(int icon) {
        setImageResource(icon);
    }

}
