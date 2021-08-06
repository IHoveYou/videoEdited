package com.duoyi.lxybaselibrary.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author : 创建人lxy
 * date : 2021/6/1 16:52
 * version :
 * desc : 于此创建有问题请联系
 */
public class DateUtils {

    public static String getDateToString(long time,String str) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat(str);
        return sf.format(d);
    }



    /*
     * 将时间转换为时间戳
     */
    public static long stringToLong(String time,String key) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(key);
        Date date = simpleDateFormat.parse(time);
        long ts = date.getTime();
        LogUtil.e("stringToLong",time+"==="+ts);
        return ts ;
    }

    /**
     * 将时间戳转换为时间
     */
    public static String timeToString(long time,String key){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(key);
        long lt = new Long(time);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}
