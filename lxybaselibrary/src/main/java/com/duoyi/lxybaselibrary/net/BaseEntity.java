package com.duoyi.lxybaselibrary.net;


import com.google.gson.annotations.SerializedName;

public class BaseEntity<T> {
    @SerializedName("data")
    public T data;
    @SerializedName("response")
    private String respCode;
    @SerializedName("desc")
    private String respContent;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespContent() {
        return respContent;
    }

    public void setRespContent(String respContent) {
        this.respContent = respContent;
    }





    public String TO_BE_CHECK;
    public double SETTLE_AMOUNT;
    public int TOTAL_COUNT;
    public double PAY_AMOUNT;

    public String DOCTOR_NAME;
    public String DOCTOR_LOGO;
    public String USER_NAME;
    public String USER_LOGO;
    public NewSBean NEWS;

    public class NewSBean{
        public double CHECK_COUNT;
        public double ALL_COUNT;
        public double ORDER_COUNT;
        public double BALANCE_COUNT;
        public double SYSTEM_COUNT;
    }
}
