package com.example.boylucky.anytao.view.frag;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.base.BaseFrag;
import com.example.base.mvp.BaseModel;
import com.example.boylucky.anytao.R;
import com.example.boylucky.anytao.adapter.FragAdapter;
import com.example.boylucky.anytao.bean.UserBean;
import com.example.boylucky.anytao.interfaces.IMainView;
import com.example.boylucky.anytao.model.MainModel;
import com.example.boylucky.anytao.presenter.MainPresenter;
import com.example.boylucky.anytao.view.SousuoActivity;
import com.example.boylucky.anytao.view.custom.MyLinearLayout;
import com.example.boylucky.anytao.view.custom.MyScrollView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.uuzuche.lib_zxing.activity.CaptureActivity;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;


/**
 * Created by BoyLucky on 2018/5/10.
 */

public class HomeFrag extends BaseFrag<MainPresenter> implements IMainView {


    @BindView(R.id.xrlv)
    XRecyclerView mXrlv;
//    @BindView(R.id.o_iv)
//    ImageView mOIv;
//    @BindView(R.id.sou_sou)
//    LinearLayout mSouSou;
//    @BindView(R.id.msg_iv)
//    ImageView mMsgIv;
//    @BindView(R.id.ne)
//    LinearLayout mNe;
    @BindView(R.id.mysv)
    MyScrollView mMysv;
   private  MyLinearLayout mMyll;
    private int imageHeight=50; //设置渐变高度，一般为导航图片高度，自己控制

    @Override
    protected BaseModel initModel() {
        return new MainModel();
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.home_frag;
    }

    @Override
    protected void initView() {

       mMyll =  view.findViewById(R.id.myll);
       mMyll.bringToFront();
        mMysv.setScrollViewListener(new MyScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy) {
                if (y <= 0) {
                    mMyll.setBackgroundColor(Color.argb((int) 0, 227, 29, 26));//AGB由相关工具获得，或者美工提供
                } else if (y > 0 && y <= imageHeight) {
                    float scale = (float) y / imageHeight;
                    float alpha = (255 * scale);
                    // 只是layout背景透明
                    mMyll.setBackgroundColor(Color.argb((int) alpha, 227, 29, 26));
                } else {
                    mMyll.setBackgroundColor(Color.argb((int) 255, 227, 29, 26));
                }
            }
        });

        mMyll.setOnItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CaptureActivity.class);
                startActivityForResult(intent, RESULT_OK);
            }
        });
        mMyll.setOnItemClick2(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),SousuoActivity.class));
            }
        });
        mMyll.setOnItemClick3(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"消息",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData() {
        presenter.login();
    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess(UserBean userBean) {
        mXrlv.setLayoutManager(new LinearLayoutManager(getContext()));
        UserBean.DataBean data = userBean.getData();
        FragAdapter fragAdapter = new FragAdapter(getContext(), data);
        mXrlv.setAdapter(fragAdapter);
    }
}
