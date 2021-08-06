package com.duoyi.lxybaselibrary.net.exception;

import android.net.ParseException;

import com.duoyi.lxybaselibrary.net.BaseEntity;
import com.duoyi.lxybaselibrary.utils.LogUtil;
import com.google.gson.stream.MalformedJsonException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import java.net.ConnectException;

import retrofit2.adapter.rxjava.HttpException;


public class ExceptionHandler {
    /**
     * 处理协议层的错误信息
     *
     * @param e
     * @return
     */
    public static CCHttpException handleHttpException(Throwable e) {
        LogUtil.e("HTTP--ExceptionHandler", "handleHttpException error:" + e.getMessage());
        String code;
        String message;

        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            code = httpException.code() + "";
            message = httpException.message();
        } else if (e instanceof JSONException
                || e instanceof ParseException
                || e instanceof MalformedJsonException
                || e instanceof ClassCastException) {
            code = ERROR.PARSE_ERROR + "";
            message = "json解析错误" + "";
        } else if (e instanceof ConnectException) {
            code = ERROR.NETWORD_ERROR + "";
            message = "连接失败";
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            code = ERROR.SSL_ERROR + "";
            message = "证书验证失败";
        } else if (e instanceof ConnectTimeoutException) {
            code = ERROR.TIMEOUT_ERROR + "";
            message = "连接超时";
        } else if (e instanceof java.net.SocketTimeoutException) {
            code = ERROR.TIMEOUT_ERROR + "";
            message = "连接超时";
        } else if (e instanceof IllegalStateException) {
            code = ERROR.ILLEGAL_STATE_ERROR + "";
            message = "状态不合法";
        } else {
            code = ERROR.UNKNOWN + "";
            message = "网络开小差啦";
        }
        return new CCHttpException(code, message);
    }

    /**
     * 处理业务相关的错误信息
     *
     * @param baseEntity 业务接口返回的json对象
     * @return
     */
    public static CCHttpException handleBizException(BaseEntity baseEntity) {
        return new CCHttpException(baseEntity.getRespCode(), baseEntity.getRespContent());
    }


    /**
     * 约定异常
     */
    public class ERROR {
        /**
         * 未知错误
         */
        public static final int UNKNOWN = -1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = -1001;
        /**
         * 网络错误
         */
        public static final int NETWORD_ERROR = -1002;

        /**
         * 证书出错
         */
        public static final int SSL_ERROR = -1005;

        /**
         * 连接超时
         */
        public static final int TIMEOUT_ERROR = -1006;
        /**
         * 状态不合法
         */
        public static final int ILLEGAL_STATE_ERROR = -1007;

    }
}
