package com.ziyi.netlibrary.bean;


import com.duoyi.lxybaselibrary.BaseApplication;

import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * author : 创建人lxy
 * date : 2021/6/2 11:09
 * version :
 * desc : 于此创建有问题请联系
 */
public class MsgEvent {
    public static final int TOUCHUAN = 100000;
    public static final int NEWMSG = 100001;

    public static void send(int type, List messages) {
        BaseApplication.getInstance().registerServer();
        EventBus.getDefault().post(new MsgEvent(type, messages));
    }


    public int type;
    public List messages;

    public MsgEvent(int type, List messages) {
        this.type = type;
        this.messages = messages;
    }

}
