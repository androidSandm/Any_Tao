package com.example.boylucky.anytao.presenter;

import com.example.base.mvp.BasePresenter;
import com.example.boylucky.anytao.bean.FenleiBean;
import com.example.boylucky.anytao.bean.FenleiChildBean;
import com.example.boylucky.anytao.interfaces.IClassifyView;
import com.example.boylucky.anytao.model.ClassifyModel;

/**
 * Created by BoyLucky on 2018/6/14.
 */

public class ClassifyPresenter extends BasePresenter<ClassifyModel,IClassifyView>{
    public void getDataFrom(){
        model.getData(new ClassifyModel.GetModel() {
            @Override
            public void getModel(FenleiBean value) {
                view.onSuccess(value);
            }

            @Override
            public void getModelChild(FenleiChildBean value) {

            }
        });

    }

    public void getDataFromChild(int position) {
        model.getDataChild(position, new ClassifyModel.GetModel() {
            @Override
            public void getModel(FenleiBean value) {

            }

            @Override
            public void getModelChild(FenleiChildBean value) {
                view.onSuccessChild(value);
            }
        });
    }

    public void detach(){
        if (view!=null){
            view = null;
        }
    }
}
