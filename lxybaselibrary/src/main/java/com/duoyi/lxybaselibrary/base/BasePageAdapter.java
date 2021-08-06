package com.duoyi.lxybaselibrary.base;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * 作者 lxy on Time 2020-08-1314:24.
 * 上有天，下有地，中间站着你自己，做一天人，尽一天人事儿
 * 人生是一个永不停息的工厂，那里没有懒人的位置。工作吧！创造吧！
 */
public class BasePageAdapter extends FragmentStatePagerAdapter {
    List<BaseFragment> fragments;
    List<String> titles;

    public BasePageAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public BasePageAdapter(FragmentManager fm, List<BaseFragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {//切换不销毁
//    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}