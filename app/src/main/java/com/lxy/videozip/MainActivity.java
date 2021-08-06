package com.lxy.videozip;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

import com.duoyi.chatmodle.utils.PhotoUtils;
import com.duoyi.chatmodle.utils.VideoEditedUtils;
import com.huantansheng.easyphotos.callback.SelectCallback;
import com.huantansheng.easyphotos.models.album.entity.Photo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    VideoEditedUtils utils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        utils=VideoEditedUtils.newInstance();
        utils.setCallBack(new VideoEditedUtils.CallBack() {
            @Override
            public void onSuccess(String path, String firstFrame, int VideoLength) {
                ( (TextView)findViewById(R.id.tv_selectVideo)).setText(path);
            }
        });


        findViewById(R.id.tv_selectVideo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhotoUtils.start(MainActivity.this, new ArrayList<Photo>(),
                        new SelectCallback() {
                            @Override
                            public void onResult(ArrayList<Photo> photos, boolean isOriginal) {
                                utils.edited(MainActivity.this,photos.get(0).path);
                            }

                            @Override
                            public void onCancel() {

                            }
                        });
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (utils!=null){
            utils.onActivityResult(requestCode, resultCode, data);
        }
    }
}
