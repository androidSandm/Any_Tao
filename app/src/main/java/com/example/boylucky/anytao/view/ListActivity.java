package com.example.boylucky.anytao.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.base.BaseActivity;
import com.example.base.mvp.BaseModel;
import com.example.boylucky.anytao.R;
import com.example.boylucky.anytao.adapter.ListAdapter;
import com.example.boylucky.anytao.bean.ListBean;
import com.example.boylucky.anytao.interfaces.IListView;
import com.example.boylucky.anytao.model.ListModel;
import com.example.boylucky.anytao.presenter.ListPresenter;
import com.example.boylucky.anytao.utils.OnItemClickListener;
import com.example.boylucky.anytao.view.custom.MySelect;

import java.util.List;

import butterknife.BindView;

public class ListActivity extends BaseActivity<ListPresenter> implements IListView {


    @BindView(R.id.list_sel)
    MySelect mListSel;
    @BindView(R.id.list_lv)
    RecyclerView mListLv;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        presenter.getData(name);
    }

    @Override
    protected BaseModel initModel() {
        return new ListModel();
    }

    @Override
    protected ListPresenter initPresenter() {
        return new ListPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int binLayoutId() {
        return R.layout.activity_list;
    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess(ListBean listBean) {
        mListLv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        final List<ListBean.DataBean> data = listBean.getData();
        ListAdapter listAdapter = new ListAdapter(this, data);
        mListLv.setAdapter(listAdapter);

        listAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void setOnClickListen(View view, int position) {
                Intent intent = new Intent(ListActivity.this, DetailsActivity.class);
                intent.putExtra("name",data.get(position).getTitle())
                        .putExtra("img",data.get(position).getImages())
                        .putExtra("price",data.get(position).getPrice()+"");
                startActivity(intent);
            }
            @Override
            public void setLongClickListen() {

            }
            @Override
            public void setOnListen(View view, String string) {

            }
        });
    }

}
