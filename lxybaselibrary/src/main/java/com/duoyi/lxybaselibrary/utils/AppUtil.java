/*
 * Copyright (C) 2012 www.amsoft.cn
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.duoyi.lxybaselibrary.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 描述：应用工具类.
 */
public class AppUtil {

    /**
     * 读取application 节点  meta-data 信息
     */
    public static String readMetaDataFromApplication(Context context, String key) {
        try {
            ApplicationInfo appInfo = context.getPackageManager()
                    .getApplicationInfo(context.getPackageName(),
                            PackageManager.GET_META_DATA);
            return appInfo.metaData.getString(key);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 描述：打开并安装文件.
     *
     * @param context the context
     * @param file    apk文件路径
     */
    public static void installApk(Context context, File file) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /**
     * 描述：卸载程序.
     *
     * @param context     the context
     * @param packageName 包名
     */
    public static void uninstallApk(Context context, String packageName) {
        Intent intent = new Intent(Intent.ACTION_DELETE);
        Uri packageURI = Uri.parse("package:" + packageName);
        intent.setData(packageURI);
        context.startActivity(intent);
    }


    /**
     * 用来判断服务是否运行.
     *
     * @param ctx       the ctx
     * @param className 判断的服务名字 "com.xxx.xx..XXXService"
     * @return true 在运行 false 不在运行
     */
    public static boolean isServiceRunning(Context ctx, String className) {
        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningServiceInfo> servicesList = activityManager.getRunningServices(Integer.MAX_VALUE);
        Iterator<RunningServiceInfo> l = servicesList.iterator();
        while (l.hasNext()) {
            RunningServiceInfo si = (RunningServiceInfo) l.next();
            if (className.equals(si.service.getClassName())) {
                isRunning = true;
            }
        }
        return isRunning;
    }

    /**
     * 停止服务.
     *
     * @param ctx       the ctx
     * @param className the class name
     * @return true, if successful
     */
    public static boolean stopRunningService(Context ctx, String className) {
        Intent intent_service = null;
        boolean ret = false;
        try {
            intent_service = new Intent(ctx, Class.forName(className));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (intent_service != null) {
            ret = ctx.stopService(intent_service);
        }
        return ret;
    }


    /**
     * Gets the number of cores available in this device, across all processors.
     * Requires: Ability to peruse the filesystem at "/sys/devices/system/cpu"
     *
     * @return The number of cores, or 1 if failed to get result
     */
    public static int getNumCores() {
        try {
            //Get directory containing CPU info
            File dir = new File("/sys/devices/system/cpu/");
            //Filter to only list the devices we care about
            File[] files = dir.listFiles(new FileFilter() {

                @Override
                public boolean accept(File pathname) {
                    //Check if filename is "cpu", followed by a single digit number
                    if (Pattern.matches("cpu[0-9]", pathname.getName())) {
                        return true;
                    }
                    return false;
                }

            });
            //Return the number of cores (virtual CPU devices)
            return files.length;
        } catch (Exception e) {
            //Default to return 1 core
            return 1;
        }
    }


    /**
     * 描述：判断网络是否有效.
     *
     * @param context the context
     * @return true, if is network available
     */
    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (info != null && info.isConnected()) {
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     * Gps是否打开
     * 需要<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />权限
     *
     * @param context the context
     * @return true, if is gps enabled
     */
    public static boolean isGpsEnabled(Context context) {
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }


    /**
     * 判断当前网络是否是移动数据网络.
     *
     * @param context the context
     * @return boolean
     */
    public static boolean isMobile(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null
                && activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            return true;
        }
        return false;
    }

    /**
     * 导入数据库.
     *
     * @param context the context
     * @param dbName  the db name
     * @param rawRes  the raw res
     * @return true, if successful
     */
    public static boolean importDatabase(Context context, String dbName, int rawRes) {
        int buffer_size = 1024;
        InputStream is = null;
        FileOutputStream fos = null;
        boolean flag = false;

        try {
            String dbPath = "/data/data/" + context.getPackageName() + "/databases/" + dbName;
            File dbfile = new File(dbPath);
            //判断数据库文件是否存在，若不存在则执行导入，否则直接打开数据库
            if (!dbfile.exists()) {
                //欲导入的数据库
                if (!dbfile.getParentFile().exists()) {
                    dbfile.getParentFile().mkdirs();
                }
                dbfile.createNewFile();
                is = context.getResources().openRawResource(rawRes);
                fos = new FileOutputStream(dbfile);
                byte[] buffer = new byte[buffer_size];
                int count = 0;
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }
                fos.flush();
            }
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                }
            }
        }
        return flag;
    }

    /**
     * 获取屏幕尺寸与密度.
     *
     * @param context the context
     * @return mDisplayMetrics
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        Resources mResources;
        if (context == null) {
            mResources = Resources.getSystem();

        } else {
            mResources = context.getResources();
        }
        //DisplayMetrics{density=1.5, width=480, height=854, scaledDensity=1.5, xdpi=160.421, ydpi=159.497}
        //DisplayMetrics{density=2.0, width=720, height=1280, scaledDensity=2.0, xdpi=160.42105, ydpi=160.15764}
        DisplayMetrics mDisplayMetrics = mResources.getDisplayMetrics();
        return mDisplayMetrics;
    }

    /**
     * 打开键盘.
     *
     * @param context the context
     */
    public static void showSoftInput(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 关闭键盘事件.
     *
     * @param context the context
     */
    public static void closeSoftInput(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null && ((Activity) context).getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(((Activity) context).getCurrentFocus()
                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 获取包信息.
     *
     * @param context the context
     */
    public static PackageInfo getPackageInfo(Context context) {
        PackageInfo info = null;
        try {
            String packageName = context.getPackageName();
            info = context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }

    /**
     * 获取当前版本号
     *
     * @return
     * @throws Exception
     */
    public static String getVersionName(Context context) {
        StringBuilder builder = new StringBuilder("v");
        try {
            PackageInfo packInfo = getPackageInfo(context);
            builder.append(packInfo.versionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    /**
     * 获取开发版本号
     *
     * @param context
     * @return
     */
    public static String getVersionCode(Context context) {
        StringBuilder builder = new StringBuilder();
        try {
            PackageInfo packInfo = getPackageInfo(context);
            builder.append(packInfo.versionCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }


    /**
     * 是否存在该包名的应用
     *
     * @param context
     * @return
     */
    public static boolean exitAppBy(Context context, String packageName) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void setTabWidth(final TabLayout tabLayout, final int padding){
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);



                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);

                        //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
                        Field mTextViewField = tabView.getClass().getDeclaredField("textView");
                        mTextViewField.setAccessible(true);

                        TextView mTextView = (TextView) mTextViewField.get(tabView);

                        tabView.setPadding(0, 0, 0, 0);

                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
                        int width = 0;
                        width = mTextView.getWidth();
                        if (width == 0) {
                            mTextView.measure(0, 0);
                            width = mTextView.getMeasuredWidth();
                        }

                        //设置tab左右间距 注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width ;
                        params.leftMargin = padding;
                        params.rightMargin = padding;
                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
