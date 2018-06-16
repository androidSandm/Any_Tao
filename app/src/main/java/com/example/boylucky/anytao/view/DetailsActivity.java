package com.example.boylucky.anytao.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.base.BaseActivity;
import com.example.base.mvp.BaseModel;
import com.example.base.mvp.BasePresenter;
import com.example.boylucky.anytao.R;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.OnClick;

public class DetailsActivity extends BaseActivity {

    @BindView(R.id.img_ban)
    Banner mImgBan;
    @BindView(R.id.ban_tv)
    TextView mBanTv;
    @BindView(R.id.ban_price)
    TextView mBanPrice;
    @BindView(R.id.shop)
    Button mShop;
    @BindView(R.id.add_shop)
    Button mAddShop;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String img = intent.getStringExtra("img");
        String price = intent.getStringExtra("price");

    }

    @Override
    protected BaseModel initModel() {
        return null;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int binLayoutId() {
        return R.layout.activity_details;
    }

}
