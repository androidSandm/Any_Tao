package com.example.boylucky.anytao.presenter;

import android.util.Log;

import com.example.base.mvp.BasePresenter;
import com.example.boylucky.anytao.bean.UserBean;
import com.example.boylucky.anytao.interfaces.IMainView;
import com.example.boylucky.anytao.model.MainModel;

/**
 * Created by BoyLucky on 2018/6/12.
 */

public class MainPresenter extends BasePresenter<MainModel,IMainView> {
    public void login(){
        model.login( new MainModel.GetModel() {
            @Override
            public void getModel(UserBean userBean) {
                if (view != null){
                    view.onSuccess(userBean);
                }
            }
        });
    }
}
