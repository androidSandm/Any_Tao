package com.example.boylucky.anytao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by BoyLucky on 2018/6/16.
 */
@Entity
public class NameBean {
    public String name;

    @Generated(hash = 400932304)
    public NameBean(String name) {
        this.name = name;
    }

    @Generated(hash = 936324891)
    public NameBean() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }
}
