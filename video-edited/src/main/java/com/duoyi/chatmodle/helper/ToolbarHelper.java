package com.duoyi.chatmodle.helper;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import com.duoyi.chatmodle.R;


/**
 * @author LLhon
 * @Project Android-Video-Editor
 * @Package com.marvhong.videoeditor.helper
 * @Date 2018/8/27 11:02
 * @description
 */
public class ToolbarHelper {

    private Toolbar mToolbar;
    private ActionBar mActionBar;

    public ToolbarHelper(Toolbar toolbar, ActionBar actionBar) {
        mToolbar = toolbar;
        mActionBar = actionBar;
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    public void setTitle(String title) {
        TextView tv = mToolbar.findViewById(R.id.toolbar_title);
        tv.setText(title);
    }

    public void setMenuTitle(String menuTitle, View.OnClickListener listener) {
        TextView tv = mToolbar.findViewById(R.id.toolbar_menu_title);
        tv.setText(menuTitle);
        tv.setOnClickListener(listener);
    }

    /**
     * 隐藏左边返回箭头
     */
    public void hideBackArrow() {
        mActionBar.setDisplayHomeAsUpEnabled(false);
    }
}
