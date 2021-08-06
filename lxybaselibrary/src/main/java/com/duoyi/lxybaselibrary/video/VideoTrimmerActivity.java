//package com.duoyi.lxybaselibrary.video;
//
//import android.app.Activity;
//import android.content.Intent;
//
//import com.duoyi.lxybaselibrary.base.BaseActivity;
//import com.duoyi.lxybaselibrary.base.BaseVM;
//
///**
// * author : 创建人lxy
// * date : 2021/5/29 17:25
// * version :
// * desc : 于此创建有问题请联系
// */
//public class VideoTrimmerActivity extends BaseActivity {
//    private String videoPath;
//
//    @Override
//    public int getLayout() {
//        return 0;
//    }
//
//    @Override
//    public BaseVM createVM() {
//        return null;
//    }
//
//    @Override
//    public void initView() {
//        videoPath = getIntent().getStringExtra("videoPath");
//    }
//
//    @Override
//    public void initData() {
//
//    }
//
//    public static void start(Activity content, String videoPath) {
//        Intent intent = new Intent(content, VideoTrimmerActivity.class);
//        intent.putExtra("videoPath", videoPath);
//        content.startActivity(intent);
//    }
//
//}
