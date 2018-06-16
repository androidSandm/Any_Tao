package com.example.boylucky.anytao.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.anye.greendao.gen.NameBeanDao;
import com.example.base.BaseActivity;
import com.example.base.mvp.BaseModel;
import com.example.base.mvp.BasePresenter;
import com.example.boylucky.anytao.R;
import com.example.boylucky.anytao.bean.NameBean;
import com.example.boylucky.anytao.utils.App;
import com.example.boylucky.anytao.utils.OnItemClickListener;
import com.example.boylucky.anytao.view.custom.FluidLayout;
import com.example.boylucky.anytao.view.custom.MySelect;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SousuoActivity extends BaseActivity {

    @BindView(R.id.f_layout)
    FluidLayout mFLayout;
    @BindView(R.id.my_sel)
    MySelect mMy_sel;
//    @BindView(R.id.lishi_layout)
   private FluidLayout mLishi_layout;
    @BindView(R.id.del)
    Button mDel;
    private NameBeanDao nameBeanDao;

    @Override
    protected void initData() {

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
        mLishi_layout = findViewById(R.id.lishi_layout);
        nameBeanDao = App.getInstances().getDaoSession().getNameBeanDao();
        mFLayout.setHorizontalSpace(10);
        mFLayout.setVerticalSpace(5);
        add();
        mMy_sel.setOnItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int binLayoutId() {
        return R.layout.activity_sousuo;
    }


    private void add() {

        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 5;
        lp.rightMargin = 5;
        lp.topMargin = 5;
        lp.bottomMargin = 5;
        final TextView textView = new TextView(this);
        textView.setText("笔记本");
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.WHITE);
        textView.setBackgroundColor(Color.RED);
        textView.setTextSize(24);
        mFLayout.addView(textView,lp);
        List<NameBean> nameBeans = nameBeanDao.loadAll();

        ViewGroup.MarginLayoutParams lp1 = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp1.leftMargin = 5;
        lp1.rightMargin = 5;
        lp1.topMargin = 5;
        lp1.bottomMargin = 5;
        for (int i = 0; i < nameBeans.size(); i++) {
            final TextView textView1 = new TextView(this);
            textView1.setText(nameBeans.get(i).getName());
            textView1.setGravity(Gravity.CENTER);
            textView1.setTextColor(Color.WHITE);
            textView1.setBackgroundColor(Color.RED);
            textView1.setTextSize(24);
            mLishi_layout.addView(textView1,lp1);
        }



    }
}
