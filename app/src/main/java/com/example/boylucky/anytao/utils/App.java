package com.example.boylucky.anytao.utils;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.anye.greendao.gen.DaoMaster;
import com.anye.greendao.gen.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by BoyLucky on 2018/6/13.
 */

public class App extends Application {
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    public static App instances;

    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Fresco.initialize(this);
        ZXingLibrary.initDisplayOpinion(this);
        instances = this;
        setDatabase();
    }

    public static App getInstances(){
        return instances;
    }
    private void setDatabase() {
        mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }
    public DaoSession getDaoSession() {
        return mDaoSession;
    }
    public SQLiteDatabase getDb() {
        return db;
    }

}
