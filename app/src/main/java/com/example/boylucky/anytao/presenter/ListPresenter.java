package com.example.boylucky.anytao.presenter;

import com.example.base.mvp.BasePresenter;
import com.example.boylucky.anytao.bean.ListBean;
import com.example.boylucky.anytao.interfaces.IListView;
import com.example.boylucky.anytao.model.ListModel;

/**
 * Created by BoyLucky on 2018/6/16.
 */

public class ListPresenter extends BasePresenter<ListModel,IListView> {
    public void getData(String name) {
        model.getDataFrom(name, new ListModel.GetModel() {
            @Override
            public void getModel(ListBean listBean) {
                view.onSuccess(listBean);
            }
        });
    }
}
