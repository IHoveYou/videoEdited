package com.duoyi.lxybaselibrary.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.duoyi.lxybaselibrary.BaseApplication;
import com.duoyi.lxybaselibrary.R;


/**
 * 作者: louxiangyu
 * 时间: 2016/8/8 17:19
 * 描述:
 */
public class ToastUtils {

    private static Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (toast != null)
                toast.show();
        }
    };
    private static Toast toast;

    public static void showMessage(String toastContent, String... location) {//最后个参数 top顶部 bottom底部 默认中间
        if (toast != null)
            toast.cancel();
        toast = null;

        LayoutInflater inflater = LayoutInflater.from(BaseApplication.getInstance().getApplicationContext());
        // 根据指定的布局文件创建一个具有层级关系的View对象
        View layout = inflater.inflate(R.layout.layout_toast, null);
        LinearLayout root = (LinearLayout) layout
                .findViewById(R.id.toast_layout_root);
        root.getBackground().setAlpha(255);// 0~255透明度值
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(toastContent);
        toast = new Toast(BaseApplication.getInstance().getApplicationContext());
        // 设置Toast的位置
        if (location.length == 0) {
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        } else {
            if ("top".equals(location[0])) {
                toast.setGravity(Gravity.TOP, 0, 250);
            } else if ("bottom".equals(location[0])) {
                toast.setGravity(Gravity.BOTTOM, 0, 250);
            }
        }
        // 让Toast显示为我们自定义的样子
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);


        Message message = Message.obtain();
        message.setData(new Bundle());   //message.obj=bundle  传值也行
        message.what = 0x11;
        handler.sendMessage(message);
    }

}
