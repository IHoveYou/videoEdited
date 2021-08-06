package com.duoyi.lxybaselibrary.utils;


import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;
import com.huantansheng.easyphotos.models.album.entity.Photo;
import com.huantansheng.easyphotos.ui.dialog.LoadingDialog;
import com.upyun.library.common.Params;
import com.upyun.library.common.UploadEngine;
import com.upyun.library.listener.UpCompleteListener;
import com.upyun.library.utils.UpYunUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Response;

/**
 * Created by jumpbox on 2017/8/15.
 *
 * 文件上传
 */

public class UpdateImageUtils {
    private static String OPERATER = "uploadvideoclient";
    private static String PASSWORD = "TVtLlYcG5sRa1daRHGkszTG9m9D98NeA";
    private static String SPACE = "video-hycw2018";
    private static String savePath = "/upload/video/{year}{mon}{day}/{random32}{.suffix}";
    private static String imageOPERATER = "uploadpicclient";
    private static String imagePASSWORD = "9ghWOTRQCFltzJCY342gAEIYazQ8VjjE";
    private static String saveImagePath = "/upload/image/{year}{mon}{day}/{random32}{.suffix}";
    private static String imageSpace = "pic-hycw2018";



    public static void luBanAndUpdate(Activity activity,ArrayList<Photo> photos,ImageCallBack callBack){
        PhotoUtils.zip(activity, photos, new PhotoUtils.PhotoCallBack() {
            @Override
            public void onSuccess(ArrayList<String> photos) {
                LogUtil.e("PhotoUtils",new Gson().toJson(photos));
                UpdateImageUtils.updataImage(photos, callBack);
            }
            @Override
            public void onCancel() {

            }
        });
    }


    public static void updataImage(ArrayList<String> list, ImageCallBack callBack) {
        ArrayList<String> url = new ArrayList<>();
        ArrayList<File> files=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            files.add(new File(list.get(i)));
        }
        updataImage(files, url, 0, callBack);
    }

    private static void updataImage(ArrayList<File> list, ArrayList<String> url, int postion, ImageCallBack callBack) {
        LogUtil.e("PhotoUtils",new Gson().toJson(list));
        if (callBack == null) return;
        File file = list.get(postion);
        final Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put(Params.BUCKET, imageSpace);
        paramsMap.put(Params.SAVE_KEY, saveImagePath);
        paramsMap.put(Params.CONTENT_LENGTH, file.length());
        LogUtil.e("upyun", saveImagePath);
        LogUtil.e("upyun", UpYunUtils.md5(imagePASSWORD));
        UploadEngine.getInstance().formUpload(file, paramsMap, imageOPERATER, UpYunUtils.md5(imagePASSWORD), new UpCompleteListener() {
            @Override
            public void onComplete(boolean isSuccess, Response response, Exception error) {
                if (response != null && response.body() != null) {
                    try {
                        JSONObject jsonObject = null;
                        jsonObject = new JSONObject(response.body().string());
                        String mServicePath = jsonObject.getString("url");
                        url.add(mServicePath);

                        int p2 = postion + 1;
                        if (p2 < list.size())
                            updataImage(list, url, p2, callBack);
                        else {
                            callBack.onSuccess(url);
                        }
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                        callBack.onErr();
                    }
                } else {
                    callBack.onErr();
                }
                if(error!=null){
                    LogUtil.e("upyun",error.getMessage());
                }

            }
        }, null);

    }




    public static void updataVideo(Context context, File file, VideoCallBack callBack) {
        if (callBack == null) return;
        LoadingDialog dialog = LoadingDialog.get(context);
        dialog.show();
        HashMap<String, Object> paramsMap = new HashMap();
        paramsMap.put(Params.BUCKET, SPACE);
        paramsMap.put(Params.SAVE_KEY, savePath);
        paramsMap.put(Params.CONTENT_LENGTH, file.length());
        UploadEngine.getInstance().formUpload(file, paramsMap, OPERATER, UpYunUtils.md5(PASSWORD), new UpCompleteListener() {
            @Override
            public void onComplete(boolean isSuccess, Response response, Exception error) {
                dialog.dismiss();
                if (response != null && response.body() != null) {
                    try {
                        String mServicePath = "";
                        String result = response.body().toString();
                        JSONObject jsonObject = null;
                        jsonObject = new JSONObject(result);
                        mServicePath = jsonObject.getString("url");
                        if (!StringUtil.isEmpty(mServicePath))
                            callBack.onSuccess(mServicePath);
                        else
                            callBack.onErr();

                    } catch (JSONException e) {
                        e.printStackTrace();
                        callBack.onErr();
                    }

                }

            }
        }, null);

    }


    public interface VideoCallBack {
        void onSuccess(String url);

        void onErr();
    }

    public interface ImageCallBack {
        void onSuccess(ArrayList<String> url);

        void onErr();
    }
}
