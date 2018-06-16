package com.example.boylucky.anytao.model;

import android.util.Log;

import com.example.base.mvp.BaseModel;
import com.example.boylucky.anytao.bean.UserBean;
import com.example.boylucky.anytao.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by BoyLucky on 2018/6/12.
 */

public class MainModel extends BaseModel {
    public void login(final GetModel getModel){
        RetrofitUtils.getInstance().api()
                .getAd()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean value) {

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
        void getModel(UserBean userBean);
    }
}
