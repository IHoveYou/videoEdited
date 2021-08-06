package com.duoyi.lxybaselibrary.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.huantansheng.easyphotos.engine.ImageEngine;

/**
 * author : 创建人lxy
 * date : 2021/5/29 9:46
 * version :
 * desc : 于此创建有问题请联系
 */
public class MyImageEngine implements ImageEngine {
    private static MyImageEngine myImageEngine;

    public static MyImageEngine getInstance() {
        if (myImageEngine == null)
            myImageEngine = new MyImageEngine();
        return myImageEngine;

    }

    @Override
    public void loadPhoto(@NonNull Context context, @NonNull Uri uri, @NonNull ImageView imageView) {
        Glide.with(context).load(uri).thumbnail(0.1f).into(imageView);
    }

    @Override
    public void loadGifAsBitmap(@NonNull Context context, @NonNull Uri gifUri, @NonNull ImageView imageView) {
        Glide.with(context).asBitmap().load(gifUri).thumbnail(0.1f).into(imageView);
    }

    @Override
    public void loadGif(@NonNull Context context, @NonNull Uri gifUri, @NonNull ImageView imageView) {
        Glide.with(context).asGif().load(gifUri).thumbnail(0.1f).into(imageView);
    }

    @Override
    public Bitmap getCacheBitmap(@NonNull Context context, @NonNull Uri uri, int width, int height) throws Exception {
        return Glide.with(context).asBitmap().load(uri).centerCrop()
                .into(500, 500).get();
    }
}
