package com.example.boylucky.anytao.view.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.boylucky.anytao.R;
import com.example.boylucky.anytao.utils.OnItemClickListener;

import butterknife.BindView;

/**
 * Created by BoyLucky on 2018/6/15.
 */

public class MyLinearLayout extends LinearLayout {
   private ImageView mOIv;
    private LinearLayout mSouSou;
    private ImageView mMsgIv;

    public MyLinearLayout(Context context) {
        this(context,null);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.sousuo_layout, this);
        mOIv =  findViewById(R.id.o_iv);
        mSouSou = findViewById(R.id.sou_sou);
        mMsgIv = findViewById(R.id.msg_iv);
    }

    public void setOnItemClick(OnClickListener onItemClick){
        mOIv.setOnClickListener(onItemClick);
    }
    public void setOnItemClick2(OnClickListener onItemClick){
        mSouSou.setOnClickListener(onItemClick);
    }
    public void setOnItemClick3(OnClickListener onItemClick){
        mMsgIv.setOnClickListener(onItemClick);
    }
}
