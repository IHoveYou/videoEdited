package com.duoyi.lxybaselibrary.net.interceptor;


import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.duoyi.lxybaselibrary.BaseApplication;
import com.duoyi.lxybaselibrary.utils.LogUtil;
import com.duoyi.lxybaselibrary.utils.MD5;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TreeMap;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

//拦截器
public abstract class ParamsInterceptor implements Interceptor {
    String TAG="HTTP";
    @Override
    public Response intercept(Chain chain) throws IOException {//拦截器 统一加头部
        Request request = chain.request();
//        Request.Builder builder = request.newBuilder();
//        builder.addHeader("identity", BaseApplication.getInstance().getIdentity() );
//        builder.addHeader("vid",  BaseApplication.getInstance().getVid());
//        builder.addHeader("token", BaseApplication.getInstance().getToken());
        BaseApplication  application= BaseApplication.getInstance();

        JsonObject requestJsonObj = new JsonObject();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = sdf.format(System.currentTimeMillis());
        requestJsonObj.addProperty("createTime", timeStr);
        requestJsonObj.addProperty("os", "Android");//区别其他客户端
        requestJsonObj.addProperty("version", application.getAppVersionName());
        requestJsonObj.addProperty("token", application.getToken());
        requestJsonObj.addProperty("channel", getCHANNEL());
        JsonObject dataJsonObj = getDataJsonObject(request.body());
        String dataString = dataJsonObj.toString();
        requestJsonObj.add("data", dataJsonObj);

        requestJsonObj.addProperty("sign", MD5.getMessageDigest((timeStr + dataString).getBytes()));



        LogUtil.i(TAG, "---response---\r\nurl:" + request.url() );
        LogUtil.i(TAG,"---response---:body{"+requestJsonObj.toString()+"}");

//        Response response;
//        try {
//            response = chain.proceed(request);
//            MediaType mediaType = response.body().contentType();
//            String content = response.body().string();
//            LogUtil.i(TAG, "---response---\r\nurl:" + request.url() + "\r\nresponse:" + content);
//
//        } catch (Exception e) {
//            LogUtil.i(TAG, "---response---\r\nurl:" + request.url() + "\r\nerrpr:" + e.getMessage());
//        }



        RequestBody newRequestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), requestJsonObj.toString());
        Request.Builder builder = request.newBuilder();
        builder.post(newRequestBody);
        return chain.proceed(builder.build());
    }

    /**
     * 渠道号
     * @return
     */
    private String getCHANNEL() {
        try {
            Application ctx = BaseApplication.getInstance();
            PackageManager packageManager = ctx.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        String channel = applicationInfo.metaData.get("UMENG_CHANNEL") + "";
                        return channel;
//                        AppConfig.CHANNEL = channel;
//                        LogService.i("Channel", "当前的渠道为:" + channel);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }


    private JsonObject getDataJsonObject(RequestBody requestBody) {
        TreeMap<String, String> sortedMap = new TreeMap<>();
        JsonObject jsonObject = new JsonObject();
        if (requestBody instanceof FormBody) {
            FormBody formBody = (FormBody) requestBody;
            for (int i = 0; i < formBody.size(); i++) {
                sortedMap.put(formBody.name(i), formBody.value(i));
            }

            for (String key : sortedMap.keySet()) {
                jsonObject.addProperty(key, sortedMap.get(key));
            }
        }
        return jsonObject;
    }
}
