package com.example.boylucky.anytao.interfaces;

import com.example.base.mvp.IBaseView;
import com.example.boylucky.anytao.bean.UserBean;

/**
 * Created by BoyLucky on 2018/6/12.
 */

public interface IMainView extends IBaseView {
    void onError();
    void onSuccess(UserBean userBean);
}
