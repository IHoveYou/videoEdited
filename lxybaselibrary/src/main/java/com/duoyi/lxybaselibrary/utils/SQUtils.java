package com.duoyi.lxybaselibrary.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.duoyi.lxybaselibrary.BaseApplication;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * author : 创建人lxy
 * date : 2021/5/12 16:32
 * version :
 * desc : 于此创建有问题请联系
 */
public class SQUtils extends SQLiteOpenHelper {
    static SQUtils utils;
    SQLiteDatabase mdb;
    final String TABLE_NAME = "user";

    public static SQUtils getInstance() {
        if (utils == null) {
            utils = new SQUtils(BaseApplication.getInstance(), "taxiu.db", null, 1);
        }
        return utils;
    }

    public SQUtils(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mdb = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table user(id varchar(20),var varchar(11))";
        db.execSQL(sql);
        mdb = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }


    public void add(String id, String var) {
        delete(id);
        if (StringUtil.isEmpty(get(id))){
            ContentValues values = new ContentValues();
            values.put("id", id);
            values.put("var",  encode(var));
            mdb.insert(TABLE_NAME, null, values);
        }else {
            update(id,var);
        }

    }


    public void add(String id, Object var) {
        add(id, getString(var));
    }


    public void delete(String key, String[] ver) {
        mdb.delete(TABLE_NAME, key + "=?", ver);
    }
    public void delete(String key) {
        mdb.delete(TABLE_NAME,  "id=?",new String[]{key} );
    }


    public void update(String id, String var) {
        ContentValues values = new ContentValues();
        values.put("var", encode(var));
        mdb.update(TABLE_NAME, values, "id=?", new String[]{id});
    }


    public String get(String id) {

        Cursor cursor = mdb.query(TABLE_NAME, new String[]{"id", "var"}, "id=?", new String[]{id}, null, null, null);



        while (cursor.moveToNext()) {
            String var = cursor.getString(cursor.getColumnIndex("var"));
            cursor.close();
            return decode(var);
        }
        return null;
    }


    public <T extends Object> T getBean(String id, Class<T> classOfT) {
        String str = get(id);
        if (!StringUtil.isEmpty(str)) {
            T bean = gson.fromJson(str, classOfT);
            return bean;
        }
        return null;
    }

    public <T extends Object> T getBean(String id, Type typeOfT) {
        String str = get(id);
        if (!StringUtil.isEmpty(str)) {
            T bean = gson.fromJson(str, typeOfT);
            return bean;
        }
        return null;
    }

    /**
     * 功能：Base64解码
     *
     * @param data 源字符串
     * @return String
     * @author jiangshuai
     * @date 2016年10月03日
     */
    private static String decode(String data) {
        try {
            byte byteArr[] = android.util.Base64.decode(data.getBytes("utf-8"), android.util.Base64.NO_WRAP);
            data = new String(byteArr);
        } catch (Exception e) {

        }
        return data;
    }


    private static String getString(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * 功能：编码Base64
     *
     * @param str 源
     * @return char[]
     * @author jiangshuai
     * @date 2016年10月03日
     */
    private static String encode(String str) {
        if (StringUtil.isEmpty(str.trim())) {
            return "";
        }
        String dataMessage = str;
        try {
            dataMessage = android.util.Base64.encodeToString(str.getBytes("utf-8"), android.util.Base64.NO_WRAP);
        } catch (Exception e) {
        }
        return dataMessage;
    }


    private static Gson gson = new Gson();


}
