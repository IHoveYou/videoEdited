package com.ziyi.netlibrary.bean;

/**
 * author : 创建人lxy
 * date : 2021/6/7 8:56
 * version :
 * desc : 于此创建有问题请联系
 */
public class OrderDetailBean {
    public long serialVersionUID;
    public double ORDER_ID;
    public double USER_ID;
    public String ORDER_NO;
    public double PAYWAY;
    public int CATEGORY;
    public int CONSULT_STATUS;
    public double TYPE;
    public double HOSPITAL_ID;
    public double DOCTOR_ID;
    public String DOCTOR_INFO;
    public String DOCTOR_NAME;
    public String DOCTOR_PHONE;
    public DOCTORBean DOCTOR;
    public double PET_ID;
    public String PET_INFO;
    public PetBean PET;
    public String CONTENT;
    public String PICS;
    public double TIP_ID;
    public String TIP;
    public String TIPS;
    public double IS_OFFLINE;
    public String OFFLINE_INFO;
    public double IS_PUBLIC;
    public double PRICE;
    public double PAYABLE_FEE;
    public double PAY_FEE;
    public double REFUND_FEE;
    public double SETTLE_FEE;
    public int STATUS;
    public double IS_SHOW;
    public int  REFUND_STATUS;
    public double REPORT_STATUS;
    public double SETTLE_STATUS;
    public String CREATETIME;
    public String PAYTIME;
    public String SETTLE_TIME;
    public String TRADE_NO;
    public String BUYER_EMAIL;
    public String CLOSE_TIME;
    public String DELETE_TIME;
    public String SERVICE_START_TIME;
    public String SERVICE_END_TIME;
    public double REPORT_NUM;
    public String REPORT_TIME;
    public String REPORT_TITLE;
    public String REPORT_ADVICE;
    public double IS_REPLY;
    public double ASK_NUM;
    public double REFUND_ID;
    public double TREATMENT_LENGTH_TIME;
    public String TREATMENT_LENGTH_TIME_DESC;
    public double TREATMENT_STATUS;

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public double getORDER_ID() {
        return ORDER_ID;
    }

    public void setORDER_ID(double ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

    public double getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(double USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getORDER_NO() {
        return ORDER_NO;
    }

    public void setORDER_NO(String ORDER_NO) {
        this.ORDER_NO = ORDER_NO;
    }

    public double getPAYWAY() {
        return PAYWAY;
    }

    public void setPAYWAY(double PAYWAY) {
        this.PAYWAY = PAYWAY;
    }

    //类型：1:问宠医  2:极速导诊  3:私人宠医 4:夜间急诊
    public String getCATEGORY() {
        switch (CATEGORY) {
            case 1:
                return "问宠医";
            case 2:
                return "极速导诊";

            case 3:
                return "私人宠医";
            case 4:
                return "夜间急诊";
        }
        return "未知";
    }

    public void setCATEGORY(int CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public double getTYPE() {
        return TYPE;
    }

    public void setTYPE(double TYPE) {
        this.TYPE = TYPE;
    }

    public double getHOSPITAL_ID() {
        return HOSPITAL_ID;
    }

    public void setHOSPITAL_ID(double HOSPITAL_ID) {
        this.HOSPITAL_ID = HOSPITAL_ID;
    }

    public double getDOCTOR_ID() {
        return DOCTOR_ID;
    }

    public void setDOCTOR_ID(double DOCTOR_ID) {
        this.DOCTOR_ID = DOCTOR_ID;
    }

    public String getDOCTOR_INFO() {
        return DOCTOR_INFO;
    }

    public void setDOCTOR_INFO(String DOCTOR_INFO) {
        this.DOCTOR_INFO = DOCTOR_INFO;
    }

    public String getDOCTOR_NAME() {
        return DOCTOR_NAME;
    }

    public void setDOCTOR_NAME(String DOCTOR_NAME) {
        this.DOCTOR_NAME = DOCTOR_NAME;
    }

    public String getDOCTOR_PHONE() {
        return DOCTOR_PHONE;
    }

    public void setDOCTOR_PHONE(String DOCTOR_PHONE) {
        this.DOCTOR_PHONE = DOCTOR_PHONE;
    }

    public DOCTORBean getDOCTOR() {
        return DOCTOR;
    }

    public void setDOCTOR(DOCTORBean DOCTOR) {
        this.DOCTOR = DOCTOR;
    }

    public double getPET_ID() {
        return PET_ID;
    }

    public void setPET_ID(double PET_ID) {
        this.PET_ID = PET_ID;
    }

    public String getPET_INFO() {
        return PET_INFO;
    }

    public void setPET_INFO(String PET_INFO) {
        this.PET_INFO = PET_INFO;
    }

    public PetBean getPET() {
        return PET;
    }

    public void setPET(PetBean PET) {
        this.PET = PET;
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

    public double getTIP_ID() {
        return TIP_ID;
    }

    public void setTIP_ID(double TIP_ID) {
        this.TIP_ID = TIP_ID;
    }

    public String getTIP() {
        return TIP;
    }

    public void setTIP(String TIP) {
        this.TIP = TIP;
    }

    public double getIS_OFFLINE() {
        return IS_OFFLINE;
    }

    public void setIS_OFFLINE(double IS_OFFLINE) {
        this.IS_OFFLINE = IS_OFFLINE;
    }

    public String getOFFLINE_INFO() {
        return OFFLINE_INFO;
    }

    public void setOFFLINE_INFO(String OFFLINE_INFO) {
        this.OFFLINE_INFO = OFFLINE_INFO;
    }

    public String getIS_PUBLIC() {
        return IS_PUBLIC==2?"是":"否";
    }

    public void setIS_PUBLIC(double IS_PUBLIC) {
        this.IS_PUBLIC = IS_PUBLIC;
    }

    public double getPRICE() {
        return PRICE;
    }

    public void setPRICE(double PRICE) {
        this.PRICE = PRICE;
    }

    public double getPAYABLE_FEE() {
        return PAYABLE_FEE;
    }

    public void setPAYABLE_FEE(double PAYABLE_FEE) {
        this.PAYABLE_FEE = PAYABLE_FEE;
    }

    public double getPAY_FEE() {
        return PAY_FEE;
    }

    public void setPAY_FEE(double PAY_FEE) {
        this.PAY_FEE = PAY_FEE;
    }

    public double getREFUND_FEE() {
        return REFUND_FEE;
    }

    public void setREFUND_FEE(double REFUND_FEE) {
        this.REFUND_FEE = REFUND_FEE;
    }

    public double getSETTLE_FEE() {
        return SETTLE_FEE;
    }

    public void setSETTLE_FEE(double SETTLE_FEE) {
        this.SETTLE_FEE = SETTLE_FEE;
    }

    // 1待支付 2已取消 3待咨询 4已退款 5咨询中 6待评价 7已完成
    public String getSTATUS() {
        switch (STATUS) {
            case 1:
                return "待支付";
            case 2:
                return "已取消";
            case 3:
                if (CONSULT_STATUS == 1){
                    return "待咨询-排队中";
                }else {
                    return "待咨询-已接入";
                }


            case 4:
                return "已退款";
            case 5:
                return "咨询中";
            case 6:
                return "待评价";
            case 7:
                return "已完成";
        }
        return "";
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    public double getIS_SHOW() {
        return IS_SHOW;
    }

    public void setIS_SHOW(double IS_SHOW) {
        this.IS_SHOW = IS_SHOW;
    }

    public int getREFUND_STATUS() {
        return REFUND_STATUS;
    }

    public void setREFUND_STATUS(int REFUND_STATUS) {
        this.REFUND_STATUS = REFUND_STATUS;
    }

    public double getREPORT_STATUS() {
        return REPORT_STATUS;
    }

    public void setREPORT_STATUS(double REPORT_STATUS) {
        this.REPORT_STATUS = REPORT_STATUS;
    }

    public double getSETTLE_STATUS() {
        return SETTLE_STATUS;
    }

    public void setSETTLE_STATUS(double SETTLE_STATUS) {
        this.SETTLE_STATUS = SETTLE_STATUS;
    }

    public String getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(String CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public String getPAYTIME() {
        return PAYTIME;
    }

    public void setPAYTIME(String PAYTIME) {
        this.PAYTIME = PAYTIME;
    }

    public String getSETTLE_TIME() {
        return SETTLE_TIME;
    }

    public void setSETTLE_TIME(String SETTLE_TIME) {
        this.SETTLE_TIME = SETTLE_TIME;
    }

    public String getTRADE_NO() {
        return TRADE_NO;
    }

    public void setTRADE_NO(String TRADE_NO) {
        this.TRADE_NO = TRADE_NO;
    }

    public String getBUYER_EMAIL() {
        return BUYER_EMAIL;
    }

    public void setBUYER_EMAIL(String BUYER_EMAIL) {
        this.BUYER_EMAIL = BUYER_EMAIL;
    }

    public String getCLOSE_TIME() {
        return CLOSE_TIME;
    }

    public void setCLOSE_TIME(String CLOSE_TIME) {
        this.CLOSE_TIME = CLOSE_TIME;
    }

    public String getDELETE_TIME() {
        return DELETE_TIME;
    }

    public void setDELETE_TIME(String DELETE_TIME) {
        this.DELETE_TIME = DELETE_TIME;
    }

    public String getSERVICE_START_TIME() {
        return SERVICE_START_TIME;
    }

    public void setSERVICE_START_TIME(String SERVICE_START_TIME) {
        this.SERVICE_START_TIME = SERVICE_START_TIME;
    }

    public String getSERVICE_END_TIME() {
        return SERVICE_END_TIME;
    }

    public void setSERVICE_END_TIME(String SERVICE_END_TIME) {
        this.SERVICE_END_TIME = SERVICE_END_TIME;
    }

    public double getREPORT_NUM() {
        return REPORT_NUM;
    }

    public void setREPORT_NUM(double REPORT_NUM) {
        this.REPORT_NUM = REPORT_NUM;
    }

    public String getREPORT_TIME() {
        return REPORT_TIME;
    }

    public void setREPORT_TIME(String REPORT_TIME) {
        this.REPORT_TIME = REPORT_TIME;
    }

    public String getREPORT_TITLE() {
        return REPORT_TITLE;
    }

    public void setREPORT_TITLE(String REPORT_TITLE) {
        this.REPORT_TITLE = REPORT_TITLE;
    }

    public String getREPORT_ADVICE() {
        return REPORT_ADVICE;
    }

    public void setREPORT_ADVICE(String REPORT_ADVICE) {
        this.REPORT_ADVICE = REPORT_ADVICE;
    }

    public double getIS_REPLY() {
        return IS_REPLY;
    }

    public void setIS_REPLY(double IS_REPLY) {
        this.IS_REPLY = IS_REPLY;
    }

    public double getASK_NUM() {
        return ASK_NUM;
    }

    public void setASK_NUM(double ASK_NUM) {
        this.ASK_NUM = ASK_NUM;
    }

    public double getREFUND_ID() {
        return REFUND_ID;
    }

    public void setREFUND_ID(double REFUND_ID) {
        this.REFUND_ID = REFUND_ID;
    }

    public double getTREATMENT_LENGTH_TIME() {
        return TREATMENT_LENGTH_TIME;
    }

    public void setTREATMENT_LENGTH_TIME(double TREATMENT_LENGTH_TIME) {
        this.TREATMENT_LENGTH_TIME = TREATMENT_LENGTH_TIME;
    }

    public String getTREATMENT_LENGTH_TIME_DESC() {
        return TREATMENT_LENGTH_TIME_DESC;
    }

    public void setTREATMENT_LENGTH_TIME_DESC(String TREATMENT_LENGTH_TIME_DESC) {
        this.TREATMENT_LENGTH_TIME_DESC = TREATMENT_LENGTH_TIME_DESC;
    }

    public double getTREATMENT_STATUS() {
        return TREATMENT_STATUS;
    }

    public void setTREATMENT_STATUS(double TREATMENT_STATUS) {
        this.TREATMENT_STATUS = TREATMENT_STATUS;
    }

    public static class DOCTORBean {
        /**
         * USER_ID : 5
         * IM_ID :
         * USERNAME : 小李医生
         * PHONE :
         * LOGO : /upload/default/logo.png
         * TITLE : 1
         * TITLE_DESC : 医师
         * DEPARTMENT : 2
         * DEPARTMENT_DESC : 内科
         * HOSPITAL_ID : 1
         * HOSPITAL_NAME : 萧东宠物医院111
         * ASK_DOCTOR_STATUS : 1
         * GUIDANCE_STATUS : 1
         * public_DOCTOR_STATUS : 1
         * NIGHT_EMERGENCY_STATUS : 0
         * CURRENT_STATUS : 5
         * STATUS : 1
         */

        public double USER_ID;
        public String IM_ID;
        public String USERNAME;
        public String PHONE;
        public String LOGO;
        public double TITLE;
        public String TITLE_DESC;
        public double DEPARTMENT;
        public String DEPARTMENT_DESC;
        public double HOSPITAL_ID;
        public String HOSPITAL_NAME;
        public double ASK_DOCTOR_STATUS;
        public double GUIDANCE_STATUS;
        public double public_DOCTOR_STATUS;
        public double NIGHT_EMERGENCY_STATUS;
        public double CURRENT_STATUS;
        public double STATUS;

        public double getUSER_ID() {
            return USER_ID;
        }

        public void setUSER_ID(double USER_ID) {
            this.USER_ID = USER_ID;
        }

        public String getIM_ID() {
            return IM_ID;
        }

        public void setIM_ID(String IM_ID) {
            this.IM_ID = IM_ID;
        }

        public String getUSERNAME() {
            return USERNAME;
        }

        public void setUSERNAME(String USERNAME) {
            this.USERNAME = USERNAME;
        }

        public String getPHONE() {
            return PHONE;
        }

        public void setPHONE(String PHONE) {
            this.PHONE = PHONE;
        }

        public String getLOGO() {
            return LOGO;
        }

        public void setLOGO(String LOGO) {
            this.LOGO = LOGO;
        }

        public double getTITLE() {
            return TITLE;
        }

        public void setTITLE(double TITLE) {
            this.TITLE = TITLE;
        }

        public String getTITLE_DESC() {
            return TITLE_DESC;
        }

        public void setTITLE_DESC(String TITLE_DESC) {
            this.TITLE_DESC = TITLE_DESC;
        }

        public double getDEPARTMENT() {
            return DEPARTMENT;
        }

        public void setDEPARTMENT(double DEPARTMENT) {
            this.DEPARTMENT = DEPARTMENT;
        }

        public String getDEPARTMENT_DESC() {
            return DEPARTMENT_DESC;
        }

        public void setDEPARTMENT_DESC(String DEPARTMENT_DESC) {
            this.DEPARTMENT_DESC = DEPARTMENT_DESC;
        }

        public double getHOSPITAL_ID() {
            return HOSPITAL_ID;
        }

        public void setHOSPITAL_ID(double HOSPITAL_ID) {
            this.HOSPITAL_ID = HOSPITAL_ID;
        }

        public String getHOSPITAL_NAME() {
            return HOSPITAL_NAME;
        }

        public void setHOSPITAL_NAME(String HOSPITAL_NAME) {
            this.HOSPITAL_NAME = HOSPITAL_NAME;
        }

        public double getASK_DOCTOR_STATUS() {
            return ASK_DOCTOR_STATUS;
        }

        public void setASK_DOCTOR_STATUS(double ASK_DOCTOR_STATUS) {
            this.ASK_DOCTOR_STATUS = ASK_DOCTOR_STATUS;
        }

        public double getGUIDANCE_STATUS() {
            return GUIDANCE_STATUS;
        }

        public void setGUIDANCE_STATUS(double GUIDANCE_STATUS) {
            this.GUIDANCE_STATUS = GUIDANCE_STATUS;
        }

        public double getpublic_DOCTOR_STATUS() {
            return public_DOCTOR_STATUS;
        }

        public void setpublic_DOCTOR_STATUS(double public_DOCTOR_STATUS) {
            this.public_DOCTOR_STATUS = public_DOCTOR_STATUS;
        }

        public double getNIGHT_EMERGENCY_STATUS() {
            return NIGHT_EMERGENCY_STATUS;
        }

        public void setNIGHT_EMERGENCY_STATUS(double NIGHT_EMERGENCY_STATUS) {
            this.NIGHT_EMERGENCY_STATUS = NIGHT_EMERGENCY_STATUS;
        }

        public double getCURRENT_STATUS() {
            return CURRENT_STATUS;
        }

        public void setCURRENT_STATUS(double CURRENT_STATUS) {
            this.CURRENT_STATUS = CURRENT_STATUS;
        }

        public double getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(double STATUS) {
            this.STATUS = STATUS;
        }
    }


}
