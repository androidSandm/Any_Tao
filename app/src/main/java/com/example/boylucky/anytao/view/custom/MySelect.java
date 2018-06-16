package com.example.boylucky.anytao.view.custom;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anye.greendao.gen.NameBeanDao;
import com.example.boylucky.anytao.R;
import com.example.boylucky.anytao.bean.NameBean;
import com.example.boylucky.anytao.utils.App;
import com.example.boylucky.anytao.utils.OnItemClickListener;
import com.example.boylucky.anytao.view.ListActivity;

/**
 * Created by BoyLucky on 2018/6/16.
 */

public class MySelect extends LinearLayout {
    private ImageView back;
    private EditText tv_sousuo;
    private TextView sousuo_tv;

    private OnItemClickListener onItemClickListener;
    private View view;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    public MySelect(Context context) {
        this(context,null);
    }

    public MySelect(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MySelect(final Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        view = LayoutInflater.from(context).inflate(R.layout.select_out, this);
        back =  findViewById(R.id.back);
        tv_sousuo = findViewById(R.id.tv_sousuo);
        sousuo_tv = findViewById(R.id.sousuo_tv);
        sousuo_tv.setOnClickListener(new OnClickListener() {

            private NameBeanDao nameBeanDao;

            @Override
            public void onClick(View v) {
                String s = tv_sousuo.getText().toString();
                nameBeanDao = App.getInstances().getDaoSession().getNameBeanDao();
                nameBeanDao.insert(new NameBean(s));
                Intent intent = new Intent(context, ListActivity.class);
                intent.putExtra("name",s);
                context.startActivity(intent);
            }
        });
    }
    public void setOnItemClick(OnClickListener onItemClick){
        back.setOnClickListener(onItemClick);
    }
}
