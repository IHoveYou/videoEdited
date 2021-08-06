package com.ziyi.netlibrary.bean;

/**
 * author : 创建人lxy
 * date : 2021/6/7 13:54
 * version :
 * desc : 于此创建有问题请联系
 */
public class RefundBean {


    /**
     * serialVersionUID : -2996191752359233500
     * REFUND_ID : 15
     * ORDER_ID : 3
     * REFUND_NO : 1610715317310
     * ORDER_NO : 1609231492600
     * USER_ID : 1
     * KIND : 2
     * PAYWAY : 1
     * MONEY : 20
     * REASON : 未获得有效医学建议,科室分配错误
     * CONTENT : 和医生聊了半小时，没问出一句有用的，怀疑是不是专业医生，赶紧退钱。
     * PICS : /upload/default/logo.png;/upload/default/logo.png;/upload/default/logo.png
     * CREATETIME : 2021-01-15 20:55:17
     * CANCLE_TIME : 
     * CHECK_INFO : 
     * CHECKTIME : 
     * STATUS : 1
     * TRADE_NO : 
     * DOCTOR_ID : 5
     * DOCTOR_ROLE : 5
     * HOSPITAL_ID : 1
     */

    public long serialVersionUID;
    public double REFUND_ID;
    public double ORDER_ID;
    public String REFUND_NO;
    public String ORDER_NO;
    public double USER_ID;
    public String USER_IM_ID;
    public double KIND;
    public double PAYWAY;
    public double MONEY;
    public String REASON;
    public String CONTENT;
    public String PICS;
    public String CREATETIME;
    public String CANCLE_TIME;
    public String CHECK_INFO;
    public String CHECKTIME;
    public int  STATUS;
    public String TRADE_NO;
    public double DOCTOR_ID;
    public double DOCTOR_ROLE;
    public double HOSPITAL_ID;

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public double getREFUND_ID() {
        return REFUND_ID;
    }

    public void setREFUND_ID(double REFUND_ID) {
        this.REFUND_ID = REFUND_ID;
    }

    public double getORDER_ID() {
        return ORDER_ID;
    }

    public void setORDER_ID(double ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

    public String getREFUND_NO() {
        return REFUND_NO;
    }

    public void setREFUND_NO(String REFUND_NO) {
        this.REFUND_NO = REFUND_NO;
    }

    public String getORDER_NO() {
        return ORDER_NO;
    }

    public void setORDER_NO(String ORDER_NO) {
        this.ORDER_NO = ORDER_NO;
    }

    public double getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(double USER_ID) {
        this.USER_ID = USER_ID;
    }

    public double getKIND() {
        return KIND;
    }

    public void setKIND(double KIND) {
        this.KIND = KIND;
    }

    public double getPAYWAY() {
        return PAYWAY;
    }

    public void setPAYWAY(double PAYWAY) {
        this.PAYWAY = PAYWAY;
    }

    public double getMONEY() {
        return MONEY;
    }

    public void setMONEY(double MONEY) {
        this.MONEY = MONEY;
    }

    public String getREASON() {
        return REASON;
    }

    public void setREASON(String REASON) {
        this.REASON = REASON;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    public String getPICS() {
        return PICS;
    }

    public void setPICS(String PICS) {
        this.PICS = PICS;
    }

    public String getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(String CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public String getCANCLE_TIME() {
        return CANCLE_TIME;
    }

    public void setCANCLE_TIME(String CANCLE_TIME) {
        this.CANCLE_TIME = CANCLE_TIME;
    }

    public String getCHECK_INFO() {
        return CHECK_INFO;
    }

    public void setCHECK_INFO(String CHECK_INFO) {
        this.CHECK_INFO = CHECK_INFO;
    }

    public String getCHECKTIME() {
        return CHECKTIME;
    }

    public void setCHECKTIME(String CHECKTIME) {
        this.CHECKTIME = CHECKTIME;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    public String getTRADE_NO() {
        return TRADE_NO;
    }

    public void setTRADE_NO(String TRADE_NO) {
        this.TRADE_NO = TRADE_NO;
    }

    public double getDOCTOR_ID() {
        return DOCTOR_ID;
    }

    public void setDOCTOR_ID(double DOCTOR_ID) {
        this.DOCTOR_ID = DOCTOR_ID;
    }

    public double getDOCTOR_ROLE() {
        return DOCTOR_ROLE;
    }

    public void setDOCTOR_ROLE(double DOCTOR_ROLE) {
        this.DOCTOR_ROLE = DOCTOR_ROLE;
    }

    public double getHOSPITAL_ID() {
        return HOSPITAL_ID;
    }

    public void setHOSPITAL_ID(double HOSPITAL_ID) {
        this.HOSPITAL_ID = HOSPITAL_ID;
    }
}
