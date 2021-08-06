package com.duoyi.chatmodle.utils;

import android.app.Activity;
import android.content.Intent;

import com.cjt2325.cameralibrary.util.LogUtil;
import com.duoyi.chatmodle.ExtractVideoInfoUtil;
import com.duoyi.chatmodle.TrimVideoActivity;

/**
 * author : 创建人lxy
 * date : 2021/8/6 9:45
 * version :
 * desc : 于此创建有问题请联系
 */
public class VideoEditedUtils {
    public static VideoEditedUtils newInstance() {
        VideoEditedUtils fragment = new VideoEditedUtils();
        return fragment;
    }

    public  void edited(Activity mContext, String path) {
        Intent intent = new Intent(mContext, TrimVideoActivity.class);
        intent.putExtra("videoPath", path);
        mContext.startActivityForResult(intent, 100);
    }




    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 0 && requestCode == 100 && data != null) {
            //处理回调相关操作 视频裁剪压缩后回调
            String path = data.getStringExtra("path");
            String firstFrame = data.getStringExtra("firstFrame");
            ExtractVideoInfoUtil mExtractVideoInfoUtil = new ExtractVideoInfoUtil(path);

            LogUtil.e("firstFramePath=", path);
            LogUtil.e("firstFrame=", firstFrame);
            LogUtil.e("firstFrameTime=", mExtractVideoInfoUtil.getVideoLength());

            if(callBack!=null){
                callBack.onSuccess(path, firstFrame, Integer.parseInt(mExtractVideoInfoUtil.getVideoLength()));
            }

        }
    }


    public interface CallBack {
        public void onSuccess(String path, String firstFrame, int VideoLength);
    }
    CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
}
