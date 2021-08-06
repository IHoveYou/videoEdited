package com.ziyi.netlibrary.bean;

import java.io.Serializable;

/**
 * author : 创建人lxy
 * date : 2021/6/8 8:42
 * version :
 * desc : 于此创建有问题请联系
 */
public class ChatBean implements Serializable {


    /**
     * REPORT_TOTAL_NUM : 2
     * REPORT_NUM : 1
     * response : 0
     * REPORT_STATUS : 2
     * ORDER_STATUS : 6
     * CHAT_STATUS : 4
     */

    public int REPORT_TOTAL_NUM;
    public int REPORT_NUM;
    public int REPORT_STATUS;
    public int ORDER_STATUS;
    public int CHAT_STATUS;
    public int CATEGORY;
    public String ORDER_ID;

    public String NICKNAME;
    public String USER_LOG;

    public int LEFT_SECONDS;
}
