package com.example.boylucky.anytao.interfaces;

import com.example.base.mvp.IBaseView;
import com.example.boylucky.anytao.bean.ListBean;
import com.example.boylucky.anytao.bean.UserBean;

/**
 * Created by BoyLucky on 2018/6/16.
 */

public interface IListView extends IBaseView {
    void onError();
    void onSuccess(ListBean listBean);
}
