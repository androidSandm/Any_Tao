package com.example.boylucky.anytao.model;

import com.example.base.mvp.BaseModel;
import com.example.boylucky.anytao.bean.ListBean;
import com.example.boylucky.anytao.utils.RetrofitUtils;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by BoyLucky on 2018/6/16.
 */

public class ListModel extends BaseModel {
    public void getDataFrom(String name, final GetModel getModel) {
        RetrofitUtils.getInstance().api()
                .getAd3(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListBean value) {
                        getModel.getModel(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface GetModel{
        void getModel(ListBean listBean);
    }
}
