package com.duoyi.lxybaselibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import com.duoyi.lxybaselibrary.base.BaseActivity;
import com.huantansheng.easyphotos.EasyPhotos;
import com.huantansheng.easyphotos.callback.SelectCallback;
import com.huantansheng.easyphotos.models.album.entity.Photo;

import java.io.File;
import java.util.ArrayList;

import top.zibin.luban.CompressionPredicate;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

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

    public static void start(BaseActivity context, ArrayList<Photo> photos, SelectCallback callBack) {

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



    public static void startOne(BaseActivity context, ArrayList<Photo> photos, SelectCallback callBack) {

        EasyPhotos.createAlbum((Activity) context, true, false, MyImageEngine.getInstance())
                .setFileProviderAuthority("com.duoyi.txpetdoctor.fileProvider")
                .complexSelector(true, 0, 1)
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


    public static void zip(Context context, ArrayList<Photo> photos, PhotoCallBack callBack) {
        ArrayList<String> zips = new ArrayList<>();
        for (int i = 0; i < photos.size(); i++) {
            zips.add(photos.get(i).path);
        }
        ArrayList<String> mlist = new ArrayList<>();
        Luban.with(context)
                .load(zips)
                .ignoreBy(200)
                .setTargetDir(getPath())
                .filter(new CompressionPredicate() {
                    @Override
                    public boolean apply(String path) {
                        return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
                    }
                })
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(File file) {
                        mlist.add(file.getPath());
                        if (mlist.size() == zips.size())
                            callBack.onSuccess(mlist);
                    }


                    @Override
                    public void onError(Throwable e) {
                        callBack.onCancel();
                    }
                })
                .launch();
    }


    public interface PhotoCallBack {
        void onSuccess(ArrayList<String> photos);

        void onCancel();
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
