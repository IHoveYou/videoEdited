package com.ziyi.netlibrary.bean;

import com.google.gson.annotations.SerializedName;

/**
 * author : 创建人lxy
 * date : 2021/6/9 12:59
 * version :
 * desc : 于此创建有问题请联系
 */
public class HomeUserBean {


    @SerializedName("SETTLEMENT_AMOUNT")
    public double SETTLEMENTAMOUNT;
    @SerializedName("SYSTEM_NEWS_COUNT")
    public int SYSTEMNEWSCOUNT;
    @SerializedName("BANNER_COUNT")
    public int BANNERCOUNT;
    @SerializedName("BALANCE_NEWS_COUNT")
    public int BALANCENEWSCOUNT;
    @SerializedName("BANNER_AMOUNT")
    public double BANNERAMOUNT;
    @SerializedName("ACCESS_COUNT")
    public int ACCESSCOUNT;
    @SerializedName("TOTAL_AMOUNT")
    public double TOTALAMOUNT;
    @SerializedName("ORDER_NEWS_COUNT")
    public int ORDERNEWSCOUNT;
    @SerializedName("BALANCE")
    public double BALANCE;
}
