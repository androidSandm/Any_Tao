package com.example.base.mvp;

/**
 * Created by BoyLucky on 2018/6/12.
 */

public interface IBaseView {
    void showLoading();
    void hideLoading();

    void serverFail(String msg);
}
