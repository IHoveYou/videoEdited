package com.duoyi.chatmodle.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import com.huantansheng.easyphotos.EasyPhotos;
import com.huantansheng.easyphotos.callback.SelectCallback;
import com.huantansheng.easyphotos.models.album.entity.Photo;

import java.io.File;
import java.util.ArrayList;



/**
 * author : 创建人lxy
 * date : 2021/5/29 9:46
 * version :
 * desc : 于此创建有问题请联系
 * 相册
 */
public class PhotoUtils {
    public static final String NAME = "GSYVideo";
    private static final String SD_PATH = Environment.getExternalStorageDirectory().getPath();

    public static void start(Activity context, ArrayList<Photo> photos, SelectCallback callBack) {

        EasyPhotos.createAlbum((Activity) context, true, false, MyImageEngine.getInstance())
                .setFileProviderAuthority("com.duoyi.txpetdoctor.fileProvider")
                .complexSelector(true, 1, 9)
                .setCount(9)
                .setPuzzleMenu(false)
                .start(new SelectCallback() {
                    @Override
                    public void onResult(ArrayList<Photo> mPhotos, boolean isOriginal) {
                        photos.clear();
                        photos.addAll(mPhotos);
                        callBack.onResult(mPhotos, isOriginal);
                    }

                    @Override
                    public void onCancel() {
                        if (callBack != null)
                            callBack.onCancel();
                    }
                });
    }






    public static String getPath() {
        String path = getAppPath(NAME);
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }

    public static String getAppPath(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(SD_PATH);
        sb.append(File.separator);
        sb.append(name);
        sb.append(File.separator);
        return sb.toString();
    }
}
