package com.ziyi.netlibrary.bean;

import java.io.Serializable;

/**
 * author : 创建人lxy
 * date : 2021/5/20 15:57
 * version :
 * desc : 于此创建有问题请联系
 */
public class UserBean implements Serializable {
    int IS_UPDATE_PWD;
    String USER_ID;
    String IM_PAS;
    String TOKEN;
    String IM_ID;

    public int getIS_UPDATE_PWD() {
        return IS_UPDATE_PWD;
    }

    public void setIS_UPDATE_PWD(int IS_UPDATE_PWD) {
        this.IS_UPDATE_PWD = IS_UPDATE_PWD;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getIM_PAS() {
        return IM_PAS;
    }

    public void setIM_PAS(String IM_PAS) {
        this.IM_PAS = IM_PAS;
    }

    public String getTOKEN() {
        return TOKEN;
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
    }

    public String getIM_ID() {
        return IM_ID;
    }

    public void setIM_ID(String IM_ID) {
        this.IM_ID = IM_ID;
    }
}
