package com.duoyi.lxybaselibrary.utils;

/**
 * @Description: 系统日志工具  统一用这个类来控制日志输出
 * @Author: tyy
 * @Date:2014-6-25 上午11:19:03
 */

import android.util.Log;

import com.duoyi.lxybaselibrary.BuildConfig;

public class LogUtil {
    public static boolean sIsLogEnable = BuildConfig.DEBUG;// 开发阶段设置为true 发布后设置为false避免日志输出

    public static void enableLog() {
        sIsLogEnable = true;
    }

    public static void disableLog() {
        sIsLogEnable = false;
    }

    public static void d(String tag, String msg) {
        if (sIsLogEnable) {
            StackTraceElement stackTrace = Thread.currentThread()
                    .getStackTrace()[3];
            String fileInfo = stackTrace.getFileName() + "("
                    + stackTrace.getLineNumber() + ") "
                    + stackTrace.getMethodName();
            Log.d(tag, fileInfo + ": " + msg);
        }
    }

    public static void i(String tag, String msg) {
        if (sIsLogEnable) {
            StackTraceElement stackTrace = Thread.currentThread()
                    .getStackTrace()[3];
            String fileInfo = stackTrace.getFileName() + "("
                    + stackTrace.getLineNumber() + ") "
                    + stackTrace.getMethodName();
            Log.i(tag, fileInfo + ": " + msg);
        }
    }

    /**
     * 个人喜好,tag写死
     *
     * @param msg
     */
    public static void i(String msg) {
        if (sIsLogEnable) {
            StackTraceElement stackTrace = Thread.currentThread()
                    .getStackTrace()[3];
            String fileInfo = stackTrace.getFileName() + "("
                    + stackTrace.getLineNumber() + ") "
                    + stackTrace.getMethodName();
            Log.i("lxy", fileInfo + ": " + msg);
        }
    }
    public static void e( String msg) {
        if (sIsLogEnable) {
            StackTraceElement stackTrace = Thread.currentThread()
                    .getStackTrace()[3];
            String fileInfo = stackTrace.getFileName() + "("
                    + stackTrace.getLineNumber() + ") "
                    + stackTrace.getMethodName();
            Log.e("lxy", fileInfo + ": " + msg);
        }
    }
    public static void e(String tag, String msg) {
        if (sIsLogEnable) {
            StackTraceElement stackTrace = Thread.currentThread()
                    .getStackTrace()[3];
            String fileInfo = stackTrace.getFileName() + "("
                    + stackTrace.getLineNumber() + ") "
                    + stackTrace.getMethodName();
            Log.e(tag, fileInfo + ": " + msg);
        }
    }

    public static void w(String tag, String msg) {
        if (sIsLogEnable) {
            StackTraceElement stackTrace = Thread.currentThread()
                    .getStackTrace()[3];
            String fileInfo = stackTrace.getFileName() + "("
                    + stackTrace.getLineNumber() + ") "
                    + stackTrace.getMethodName();
            Log.w(tag, fileInfo + ": " + msg);
        }
    }

    public static void v(String tag, String msg) {
        if (sIsLogEnable) {
            StackTraceElement stackTrace = Thread.currentThread()
                    .getStackTrace()[3];
            String fileInfo = stackTrace.getFileName() + "("
                    + stackTrace.getLineNumber() + ") "
                    + stackTrace.getMethodName();
            Log.v(tag, fileInfo + ": " + msg);
        }
    }

    public static String getStackTraceMsg() {
        StackTraceElement stackTrace = Thread.currentThread()
                .getStackTrace()[3];
        String fileInfo = stackTrace.getFileName() + "("
                + stackTrace.getLineNumber() + ") "
                + stackTrace.getMethodName();
        return fileInfo;
    }
}
