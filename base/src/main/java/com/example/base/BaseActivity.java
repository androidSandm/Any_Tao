package com.example.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.base.mvp.BaseModel;
import com.example.base.mvp.BasePresenter;
import com.example.base.mvp.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by BoyLucky on 2018/6/12.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView{
    public P presenter;
    private Unbinder bind;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binLayoutId());
        bind = ButterKnife.bind(this);
        initView();

        presenter = initPresenter();
        if (presenter != null){
            presenter.attch(initModel(),this);
        }
        initData();

    }

    protected abstract void initData();

    protected abstract BaseModel initModel();

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract int binLayoutId();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void serverFail(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.detach();
        }
    }
}
