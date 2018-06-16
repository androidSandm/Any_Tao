package com.example.boylucky.anytao.model;

import com.example.base.mvp.BaseModel;
import com.example.boylucky.anytao.bean.FenleiBean;
import com.example.boylucky.anytao.bean.FenleiChildBean;
import com.example.boylucky.anytao.bean.UserBean;
import com.example.boylucky.anytao.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by BoyLucky on 2018/6/14.
 */

public class ClassifyModel extends BaseModel{
    public void getData(final GetModel getModel){
        RetrofitUtils.getInstance().api().getAd1()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FenleiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FenleiBean value) {
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

    public void getDataChild(int position, final GetModel getModel) {
        RetrofitUtils.getInstance().api().getAd2(position)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FenleiChildBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FenleiChildBean value) {
                        getModel.getModelChild(value);
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
        void getModel(FenleiBean value);
        void getModelChild(FenleiChildBean value);
    }
}
