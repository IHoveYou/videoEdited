package com.ziyi.netlibrary.bean;

import com.duoyi.lxybaselibrary.utils.StringUtil;

/**
 * author : 创建人lxy
 * date : 2021/6/1 15:57
 * version :
 * desc : 于此创建有问题请联系
 */
public class HomeItemBean  {




    /**
     * CHANNEL_ID : 1110201210040281#taxiu_im_t_c_1@easemob.com
     * USER_ID : 1
     * IM_ID : im_t_c_1
     * CHAT_TYPE : chat
     * PHONE : 15100000000
     * NICKNAME : aa
     * LOGO : //upload/image/20190605/hh7k647jf6ub2jnodmrrcdpzjapr5s4f.png
     * SEND_TIME : 2021-03-09
     * MSG_ID : 849138782119663608
     * chatMessage : {"CHAT_ID":15176,"MSG_ID":"849138782119663608","TIMESTAMP":1615270329197,"SEND_TIME":"2021-03-09 14:12:09","FROM_USER":"im_t_c_1","TO_USER":"im_t_d_103","CHAT_TYPE":"chat","TYPE":"custom","MSG":"[{\"WEIGHT\":\"\"},{\"VACCINE\":0},{\"PICS\":\"\"},{\"PET_TYPE_NAME\":\"布偶猫\"},{\"PET_ID\":5474},{\"ORDER_ID\":400},{\"OFFLINE_INFO\":\"\"},{\"NICKNAME\":\"JJ\"},{\"NEUTER\":0},{\"LOGO\":\"//upload/image/20210309/wiyvb4ao72smmrdcbhrjxiq2qakdbyjp.jpg\"},{\"KIND\":2},{\"IS_OFFLINE\":1},{\"GENDER\":2},{\"CONTENT\":\"额额额额额\"},{\"CATEGORY\":1},{\"AGE\":\"1岁\"}]","FILE_LENGTH":0,"FILE_NAME":"","HEIGHT":"","WIDTH":"","URL":"","SECRET":"","PIC":"","LENGTH":0,"AUDIO":"","THUMB":"","THUMB_SECRET":"","VIDEO":"","FILE":"","CREATETIME":"2021-03-09 14:12:09","EVENT_TYPE":"chat","CUSTOM_EVENT":"condition","SEND_ROLE":"U","ACTION":"","EXT":"{\"IS_OFFLINE\":1,\"SYSTEM_REMINDER\":\"系统提醒：宠医回复后将通过系统消息提醒您。您可以选择先前往社区内随便逛逛。\",\"VACCINE\":0,\"DOCTOR_IM_ID\":\"im_t_d_103\",\"LOGO\":\"//upload/image/20210309/wiyvb4ao72smmrdcbhrjxiq2qakdbyjp.jpg\",\"USER_IM_ID\":\"im_t_c_1\",\"PICS\":\"\",\"PET_ID\":5474,\"NEUTER\":0,\"OFFLINE_INFO\":\"\",\"NICKNAME\":\"JJ\",\"ORDER_ID\":400,\"CATEGORY\":1,\"KIND\":2,\"GENDER\":2,\"CONTENT\":\"额额额额额\",\"WEIGHT\":\"\",\"PET_TYPE_NAME\":\"布偶猫\",\"AGE\":\"1岁\"}"}
     * CATEGORY : 1
     * ORDER_ID : 400
     * CHAT_STATUS : 2
     * LEFT_SECONDS : -12343
     * ORDER_STATUS : 3
     * OVER_TIME_SECONDS : 12343
     * REPORT_STATUS : 0
     * REPORT_NUM : 0
     * DOCTOR_LOGO : /upload/default/logo.png
     */

    private String CHANNEL_ID;
    private int USER_ID;
    private String IM_ID;
    private String CHAT_TYPE;
    private String PHONE;
    private String NICKNAME;
    private String LOGO;
    private String SEND_TIME;
    private String MSG_ID;
    private ChatMessageBean chatMessage;
    private int CATEGORY;
    private int ORDER_ID;
    private int CHAT_STATUS;
    private int LEFT_SECONDS;
    private int ORDER_STATUS;
    private int OVER_TIME_SECONDS;
    private int REPORT_STATUS;
    private int REPORT_NUM;
    private String DOCTOR_LOGO;


    public String getCHANNEL_ID() {
        return CHANNEL_ID;
    }

    public void setCHANNEL_ID(String CHANNEL_ID) {
        this.CHANNEL_ID = CHANNEL_ID;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getIM_ID() {
        return IM_ID;
    }

    public void setIM_ID(String IM_ID) {
        this.IM_ID = IM_ID;
    }

    public String getCHAT_TYPE() {
        return CHAT_TYPE;
    }

    public void setCHAT_TYPE(String CHAT_TYPE) {
        this.CHAT_TYPE = CHAT_TYPE;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getNICKNAME() {
        return StringUtil.isEmpty(NICKNAME) ? "" : NICKNAME;
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

    public String getSEND_TIME() {
        return SEND_TIME;
    }



    public String getMSG_ID() {
        return MSG_ID;
    }

    public void setMSG_ID(String MSG_ID) {
        this.MSG_ID = MSG_ID;
    }

    public ChatMessageBean getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(ChatMessageBean chatMessage) {
        this.chatMessage = chatMessage;
    }

    public int getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(int CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public int getORDER_ID() {
        return ORDER_ID;
    }

    public void setORDER_ID(int ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

    public int getCHAT_STATUS() {
        return CHAT_STATUS;
    }

    public void setCHAT_STATUS(int CHAT_STATUS) {
        this.CHAT_STATUS = CHAT_STATUS;
    }

    public int getLEFT_SECONDS() {
        return LEFT_SECONDS;
    }

    public void setLEFT_SECONDS(int LEFT_SECONDS) {
        this.LEFT_SECONDS = LEFT_SECONDS;
    }

    public int getORDER_STATUS() {
        return ORDER_STATUS;
    }

    public void setORDER_STATUS(int ORDER_STATUS) {
        this.ORDER_STATUS = ORDER_STATUS;
    }

    public int getOVER_TIME_SECONDS() {
        return OVER_TIME_SECONDS;
    }

    public void setOVER_TIME_SECONDS(int OVER_TIME_SECONDS) {
        this.OVER_TIME_SECONDS = OVER_TIME_SECONDS;
    }

    public int getREPORT_STATUS() {
        return REPORT_STATUS;
    }

    public void setREPORT_STATUS(int REPORT_STATUS) {
        this.REPORT_STATUS = REPORT_STATUS;
    }

    public int getREPORT_NUM() {
        return REPORT_NUM;
    }

    public void setREPORT_NUM(int REPORT_NUM) {
        this.REPORT_NUM = REPORT_NUM;
    }

    public String getDOCTOR_LOGO() {
        return DOCTOR_LOGO;
    }

    public void setDOCTOR_LOGO(String DOCTOR_LOGO) {
        this.DOCTOR_LOGO = DOCTOR_LOGO;
    }

}
