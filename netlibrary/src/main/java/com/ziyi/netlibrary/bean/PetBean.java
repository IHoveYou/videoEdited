package com.ziyi.netlibrary.bean;

import com.duoyi.lxybaselibrary.utils.StringUtil;

/**
 * author : 创建人lxy
 * date : 2021/6/7 8:59
 * version :
 * desc : 于此创建有问题请联系
 */
public class PetBean {
    /**
     * PET_ID : 6826
     * USER_ID : 1
     * PET_TYPE_ID : 70
     * NICKNAME : aa
     * LOGO : //upload/image/20201219/ms5d5p2dkehh7tllsyqr957hd5du69n7.jpg
     * GENDER : 2
     * BIRTHDAY : 2020.12.19
     * SORT : 0
     * CATEGORY : 0
     * STATUS : 0
     * SHOW_HEALTH : 1
     * CREATETIME : 2020-12-20 15:35:30
     * PET_TYPE_NAME :
     * KIND : 2
     * AGE : 出生日
     * VACCINE : 1
     * NEUTER : 1
     * ACTIVE : 较活跃
     * ACTIVE_TIME : 5h
     * APPETITE : 正常
     * EAT : 100g
     * FLATUS : 敏感
     * SYMPTOM : 经常腹泻, 营养不吸收
     * TEETH : 无
     * WEIGHT :
     * BODY_LENTH :
     * HIGH :
     * PROGRESS :
     * ONLINE_INQUIRY_NUM : 0
     * OFFLINE_INQUIRY_NUM : 0
     */

    public double PET_ID;
    public double USER_ID;
    public double PET_TYPE_ID;
    public String NICKNAME;
    public String LOGO;
    public double GENDER;
    public String BIRTHDAY;
    public double SORT;
    public double CATEGORY;
    public double STATUS;
    public double SHOW_HEALTH;
    public String CREATETIME;
    public String PET_TYPE_NAME;
    public double KIND;
    public String AGE;
    public double VACCINE;
    public double NEUTER;
    public String ACTIVE;
    public String ACTIVE_TIME;
    public String APPETITE;
    public String EAT;
    public String FLATUS;
    public String SYMPTOM;
    public String TEETH;
    public String WEIGHT;
    public String BODY_LENTH;
    public String HIGH;
    public String PROGRESS;
    public double ONLINE_INQUIRY_NUM;
    public double OFFLINE_INQUIRY_NUM;
    public int IS_OFFLINE;
    public String CONTENT;
    public String PICS;

    public String getPICS() {
        return PICS;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public double getPET_ID() {
        return PET_ID;
    }

    public void setPET_ID(double PET_ID) {
        this.PET_ID = PET_ID;
    }

    public double getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(double USER_ID) {
        this.USER_ID = USER_ID;
    }

    public double getPET_TYPE_ID() {
        return PET_TYPE_ID;
    }

    public void setPET_TYPE_ID(double PET_TYPE_ID) {
        this.PET_TYPE_ID = PET_TYPE_ID;
    }

    public void setNICKNAME(String NICKNAME) {
        this.NICKNAME = NICKNAME;
    }

    public String getLOGO() {
        return LOGO;
    }

    public void setLOGO(String LOGO) {
        this.LOGO = LOGO;
    }

    public void setGENDER(double GENDER) {
        this.GENDER = GENDER;
    }

    public String getBIRTHDAY() {
        return BIRTHDAY;
    }

    public void setBIRTHDAY(String BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    public double getSORT() {
        return SORT;
    }

    public void setSORT(double SORT) {
        this.SORT = SORT;
    }

    public double getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(double CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public double getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(double STATUS) {
        this.STATUS = STATUS;
    }

    public double getSHOW_HEALTH() {
        return SHOW_HEALTH;
    }

    public void setSHOW_HEALTH(double SHOW_HEALTH) {
        this.SHOW_HEALTH = SHOW_HEALTH;
    }

    public String getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(String CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public String getPET_TYPE_NAME() {
        return PET_TYPE_NAME;
    }

    public void setPET_TYPE_NAME(String PET_TYPE_NAME) {
        this.PET_TYPE_NAME = PET_TYPE_NAME;
    }

    public void setKIND(double KIND) {
        this.KIND = KIND;
    }

    public String getAGE() {
        return AGE;
    }

    public void setAGE(String AGE) {
        this.AGE = AGE;
    }

    public void setVACCINE(double VACCINE) {
        this.VACCINE = VACCINE;
    }

    public void setNEUTER(double NEUTER) {
        this.NEUTER = NEUTER;
    }

    public String getACTIVE() {
        return ACTIVE;
    }

    public void setACTIVE(String ACTIVE) {
        this.ACTIVE = ACTIVE;
    }

    public String getACTIVE_TIME() {
        return ACTIVE_TIME;
    }

    public void setACTIVE_TIME(String ACTIVE_TIME) {
        this.ACTIVE_TIME = ACTIVE_TIME;
    }

    public String getAPPETITE() {
        return APPETITE;
    }

    public void setAPPETITE(String APPETITE) {
        this.APPETITE = APPETITE;
    }

    public String getEAT() {
        return EAT;
    }

    public void setEAT(String EAT) {
        this.EAT = EAT;
    }

    public String getFLATUS() {
        return FLATUS;
    }

    public void setFLATUS(String FLATUS) {
        this.FLATUS = FLATUS;
    }

    public String getSYMPTOM() {
        return SYMPTOM;
    }

    public void setSYMPTOM(String SYMPTOM) {
        this.SYMPTOM = SYMPTOM;
    }

    public String getTEETH() {
        return TEETH;
    }

    public void setTEETH(String TEETH) {
        this.TEETH = TEETH;
    }


    public void setWEIGHT(String WEIGHT) {
        this.WEIGHT = WEIGHT;
    }

    public String getBODY_LENTH() {
        return BODY_LENTH;
    }

    public void setBODY_LENTH(String BODY_LENTH) {
        this.BODY_LENTH = BODY_LENTH;
    }

    public String getHIGH() {
        return HIGH;
    }

    public void setHIGH(String HIGH) {
        this.HIGH = HIGH;
    }

    public String getPROGRESS() {
        return PROGRESS;
    }

    public void setPROGRESS(String PROGRESS) {
        this.PROGRESS = PROGRESS;
    }

    public double getONLINE_INQUIRY_NUM() {
        return ONLINE_INQUIRY_NUM;
    }

    public void setONLINE_INQUIRY_NUM(double ONLINE_INQUIRY_NUM) {
        this.ONLINE_INQUIRY_NUM = ONLINE_INQUIRY_NUM;
    }

    public double getOFFLINE_INQUIRY_NUM() {
        return OFFLINE_INQUIRY_NUM;
    }

    public void setOFFLINE_INQUIRY_NUM(double OFFLINE_INQUIRY_NUM) {
        this.OFFLINE_INQUIRY_NUM = OFFLINE_INQUIRY_NUM;
    }

    public String getIS_OFFLINE() {
        if (IS_OFFLINE == 2) {
            return "是";
        }
        return "否";
    }

    public String getKIND() {
        if (1==(KIND)) {
            return "狗狗";
        } else {
            return "猫猫";
        }
    }


    public String getNEUTER() {
        if (1==(NEUTER)) {
            return "否";
        } else if (2==(NEUTER)) {
            return "是";
        } else
            return "未录入";
    }

    public String getVACCINE() {
        if (1==(VACCINE)) {
            return "否";
        } else if (2==(VACCINE)) {
            return "是";
        } else
            return "未录入";
    }

    public String getGENDER() {
        if (GENDER==1) {
            return "弟弟";
        } else {
            return "妹妹";
        }
    }

    public String getNICKNAME() {
        if (NICKNAME.length() > 8) {
            return NICKNAME.substring(0, 8) + "...";
        }

        return NICKNAME;
    }

    public String getWEIGHT() {
        if (StringUtil.isEmpty(WEIGHT)) {
            return "未录入";
        }
        return   WEIGHT.replace("kg","")+"kg";
    }
}


