package com.ziyi.netlibrary.bean;

import java.io.Serializable;

/**
 * author : 创建人lxy
 * date : 2021/6/15 17:05
 * version :
 * desc : 于此创建有问题请联系
 */
public class ListBean implements Serializable {
    public ListBean(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String name;
    public String id;
    public boolean isSelect = false;

}
