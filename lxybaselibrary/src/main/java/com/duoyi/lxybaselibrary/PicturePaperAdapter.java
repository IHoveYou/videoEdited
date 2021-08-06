package com.duoyi.lxybaselibrary;

/**
 * author : 创建人lxy
 * date : 2021/6/16 14:28
 * version :
 * desc : 于此创建有问题请联系
 */

import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * 图片预览viewpager
 */

public class PicturePaperAdapter extends PagerAdapter {
    private List<View> views;

    public PicturePaperAdapter(List<View> views) {
        super();
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // super.destroyItem(container, position, object);
        container.removeView(views.get(position));
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

}