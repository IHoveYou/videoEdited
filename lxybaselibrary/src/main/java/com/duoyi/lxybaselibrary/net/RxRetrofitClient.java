package com.duoyi.lxybaselibrary.net;

import android.content.Context;

import com.duoyi.lxybaselibrary.net.cookie.NovateCookieManger;
import com.duoyi.lxybaselibrary.net.dialog.HttpDialogManager;
import com.duoyi.lxybaselibrary.net.dialog.HttpToastManager;
import com.duoyi.lxybaselibrary.net.interceptor.CapInterceptor;
import com.duoyi.lxybaselibrary.utils.UIUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RxRetrofitClient {



    private OkHttpClient mOkHttpClient;
    private OkHttpClient.Builder mOkHttpClientBuilder;
    private Retrofit.Builder mBuilder;


    private CapInterceptor mCapInterceptor;

    public CapInterceptor getCapInterceptor() {
        return mCapInterceptor;
    }

    public void setCapInterceptor(CapInterceptor mCapInterceptor) {
        this.mCapInterceptor = mCapInterceptor;
    }

    /**
     * 网络层的单例对象，用于公司自己业务接口的请求，通常会加上各种配置
     */
    private static RxRetrofitClient sInstance;

    private RxRetrofitClient() {
    }


    public static RxRetrofitClient getInstance() {
        if (sInstance == null) {
            throw new RuntimeException("ExRetrofitClient has not been initialized,call init(Builder builder) firse");
        }
        return sInstance;
    }

    /**
     * 根据原来的httpclient配置重新生成一个拥有新超时时间的httpClient
     * 注意：http接口需要从这个返回的client的{@link #getHttpInterface(String, Class)}重新获取！！！
     *
     * @return
     */
    public RxRetrofitClient setTimeout(int second) {
        RxRetrofitClient client = new RxRetrofitClient();
        client.mOkHttpClientBuilder = mOkHttpClientBuilder.connectTimeout(second, TimeUnit.SECONDS)
                .readTimeout(second, TimeUnit.SECONDS)
                .writeTimeout(second, TimeUnit.SECONDS);
        client.mOkHttpClient = client.mOkHttpClientBuilder.build();
        client.mBuilder = mBuilder.client(client.mOkHttpClient);
        return client;
    }

    /**
     * 对网络层单例对象初始化
     *
     * @param builder
     */
    public static void init(Builder builder) {
        sInstance = createNewClient(builder);
    }

    /**
     * 对非公司的接口或者其他不需要使用公共的配置的retrofitClient，使用默认配置重新创建一个
     * 可以保存这个对象重复使用，也可以在需要的时候调用这个方法获取
     *
     * @return
     */
    public static RxRetrofitClient createNewClient() {
        return createNewClient(new Builder());
    }


    /**
     * 对非公司的接口或者其他不需要使用公共的配置的retrofitClient，根据builder重新创建一个
     * 可以保存这个对象重复使用，也可以在需要的时候调用这个方法获取
     *
     * @return
     */
    public static RxRetrofitClient createNewClient(Builder builder) {
        RxRetrofitClient client = new RxRetrofitClient();

        CapInterceptor capInterceptor = findCapInterceptor(builder);
        client.setCapInterceptor(capInterceptor);

        client.mOkHttpClientBuilder = createOKHttpBuilder(builder);
        client.mOkHttpClient = client.mOkHttpClientBuilder.build();
        client.mBuilder = new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).client(client.mOkHttpClient);
//        .addConverterFactory(GsonConverterFactory.create())
        return client;
    }

    private static CapInterceptor findCapInterceptor(Builder builder) {
        for (Interceptor interceptor : builder.mInterceptors) {
            if (interceptor instanceof CapInterceptor) {
                return (CapInterceptor) interceptor;
            }
        }
        return null;
    }

    /**
     * 返回http接口的动态代理对象，使用该对象请求接口
     *
     * @param baseUrl
     * @param interfaze 定义每个request的接口类
     * @param <T>
     * @return
     */
    public <T> T getHttpInterface(String baseUrl, Class<T> interfaze) {
        return mBuilder.baseUrl(baseUrl).build().create(interfaze);
    }

    private static OkHttpClient.Builder createOKHttpBuilder(Builder builder) {

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .connectTimeout(builder.mConnectTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(builder.mReadTimeout, TimeUnit.MILLISECONDS)
                .writeTimeout(builder.mWriteTimeout, TimeUnit.MILLISECONDS)
                .connectionPool(new ConnectionPool(8, 15, TimeUnit.SECONDS));

        //add cookie
        if (builder.mContext != null) {
            okHttpClientBuilder.cookieJar(new NovateCookieManger(builder.mContext.getApplicationContext()));
        }

        for (Interceptor interceptor : builder.mInterceptors) {
            okHttpClientBuilder.addInterceptor(interceptor);
        }

        for (Interceptor interceptor : builder.mNetInterceptors) {
            okHttpClientBuilder.addNetworkInterceptor(interceptor);
        }

        UIUtil.setDialogManager(builder.mHttpDialog);
        UIUtil.setToastManager(builder.mHttpToast);
        return okHttpClientBuilder;
    }


    public static class Builder {
        private List<Interceptor> mInterceptors;
        private List<Interceptor> mNetInterceptors;
        private long mConnectTimeout;
        private long mReadTimeout;
        private long mWriteTimeout;
        private HttpToastManager mHttpToast;
        private HttpDialogManager mHttpDialog;
        private Context mContext;

        public Builder() {
            mInterceptors = new ArrayList<>();
            mNetInterceptors = new ArrayList<>();
            mConnectTimeout = 10_000;
            mReadTimeout = 10_000;
            mWriteTimeout = 10_000;
        }


        public Builder timeout(int timeout) {
            this.mConnectTimeout = timeout;
            this.mReadTimeout = timeout;
            this.mWriteTimeout = timeout;
            return this;
        }

        public Builder connectTimeout(int connectTimeout) {
            this.mConnectTimeout = connectTimeout;
            return this;
        }

        public Builder readTimeout(int readTimeout) {
            this.mReadTimeout = readTimeout;
            return this;
        }

        public Builder writeTimeout(int writeTimeout) {
            this.mConnectTimeout = writeTimeout;
            return this;
        }

        public Builder interceptor(Interceptor interceptor) {
            mInterceptors.add(interceptor);
            return this;
        }

        public Builder netInterceptor(Interceptor interceptor) {
            mNetInterceptors.add(interceptor);
            return this;
        }

        public Builder httpDialog(HttpDialogManager dialog) {
            mHttpDialog = dialog;
            return this;
        }


        public Builder httpToast(HttpToastManager toast) {
            mHttpToast = toast;
            return this;
        }


        public Builder cookiesContext(Context context) {
            mContext = context.getApplicationContext();
            return this;
        }
    }
}
