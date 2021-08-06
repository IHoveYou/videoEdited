package com.duoyi.chatmodle.bean;

import java.io.Serializable;

/**
 * author : 创建人lxy
 * date : 2021/5/20 11:25
 * version :
 * desc : 于此创建有问题请联系
 */
public class TXMsgBean implements Serializable {
    /**
     * Created by Sola on 2021-02-15.
     */
    private int CHAT_ID;
    private String MSG_ID;
    private long TIMESTAMP;
    private String SEND_TIME;
    private String FROM_USER;
    private String TO_USER;
    private String CHAT_TYPE;
    private String TYPE;
    private String MSG;
    private int FILE_LENGTH;
    private String FILE_NAME;
    private String HEIGHT;
    private String WIDTH;
    private String URL;
    private String SECRET;
    private String PIC;
    private int LENGTH;
    private String AUDIO;
    private String THUMB;
    private String THUMB_SECRET;
    private String VIDEO;
    private String FILE;
    private String CREATETIME;
    private String EVENT_TYPE;
    private String CUSTOM_EVENT;
    private String SEND_ROLE;

    public int getCHAT_ID() {
        return CHAT_ID;
    }

    public void setCHAT_ID(int CHAT_ID) {
        this.CHAT_ID = CHAT_ID;
    }

    public String getMSG_ID() {
        return MSG_ID;
    }

    public void setMSG_ID(String MSG_ID) {
        this.MSG_ID = MSG_ID;
    }

    public long getTIMESTAMP() {
        return TIMESTAMP;
    }

    public void setTIMESTAMP(long TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }

    public String getSEND_TIME() {
        return SEND_TIME;
    }

    public void setSEND_TIME(String SEND_TIME) {
        this.SEND_TIME = SEND_TIME;
    }

    public String getFROM_USER() {
        return FROM_USER;
    }

    public void setFROM_USER(String FROM_USER) {
        this.FROM_USER = FROM_USER;
    }

    public String getTO_USER() {
        return TO_USER;
    }

    public void setTO_USER(String TO_USER) {
        this.TO_USER = TO_USER;
    }

    public String getCHAT_TYPE() {
        return CHAT_TYPE;
    }

    public void setCHAT_TYPE(String CHAT_TYPE) {
        this.CHAT_TYPE = CHAT_TYPE;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getMSG() {
        return MSG;
    }

    public void setMSG(String MSG) {
        this.MSG = MSG;
    }

    public int getFILE_LENGTH() {
        return FILE_LENGTH;
    }

    public void setFILE_LENGTH(int FILE_LENGTH) {
        this.FILE_LENGTH = FILE_LENGTH;
    }

    public String getFILE_NAME() {
        return FILE_NAME;
    }

    public void setFILE_NAME(String FILE_NAME) {
        this.FILE_NAME = FILE_NAME;
    }

    public String getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(String HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public String getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(String WIDTH) {
        this.WIDTH = WIDTH;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getSECRET() {
        return SECRET;
    }

    public void setSECRET(String SECRET) {
        this.SECRET = SECRET;
    }

    public String getPIC() {
        return PIC;
    }

    public void setPIC(String PIC) {
        this.PIC = PIC;
    }

    public int getLENGTH() {
        return LENGTH;
    }

    public void setLENGTH(int LENGTH) {
        this.LENGTH = LENGTH;
    }

    public String getAUDIO() {
        return AUDIO;
    }

    public void setAUDIO(String AUDIO) {
        this.AUDIO = AUDIO;
    }

    public String getTHUMB() {
        return THUMB;
    }

    public void setTHUMB(String THUMB) {
        this.THUMB = THUMB;
    }

    public String getTHUMB_SECRET() {
        return THUMB_SECRET;
    }

    public void setTHUMB_SECRET(String THUMB_SECRET) {
        this.THUMB_SECRET = THUMB_SECRET;
    }

    public String getVIDEO() {
        return VIDEO;
    }

    public void setVIDEO(String VIDEO) {
        this.VIDEO = VIDEO;
    }

    public String getFILE() {
        return FILE;
    }

    public void setFILE(String FILE) {
        this.FILE = FILE;
    }

    public String getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(String CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public String getEVENT_TYPE() {
        return EVENT_TYPE;
    }

    public void setEVENT_TYPE(String EVENT_TYPE) {
        this.EVENT_TYPE = EVENT_TYPE;
    }

    public String getCUSTOM_EVENT() {
        return CUSTOM_EVENT;
    }

    public void setCUSTOM_EVENT(String CUSTOM_EVENT) {
        this.CUSTOM_EVENT = CUSTOM_EVENT;
    }

    public String getSEND_ROLE() {
        return SEND_ROLE;
    }

    public void setSEND_ROLE(String SEND_ROLE) {
        this.SEND_ROLE = SEND_ROLE;
    }

}
