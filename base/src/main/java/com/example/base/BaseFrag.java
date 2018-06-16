package com.example.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.base.mvp.BaseModel;
import com.example.base.mvp.BasePresenter;
import com.example.base.mvp.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by BoyLucky on 2018/6/12.
 */

public abstract class BaseFrag<P extends BasePresenter> extends Fragment implements IBaseView {
    public P presenter;
    public View view;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(bindLayoutId(), container, false);
        bind = ButterKnife.bind(this, view);
        initView();
        presenter = initPresenter();

        if (presenter != null){
            presenter.attch(initModel(),this);
        }
        initData();
        return view;
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract BaseModel initModel();

    protected abstract P initPresenter();

    protected abstract int bindLayoutId();

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
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
