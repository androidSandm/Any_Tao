package com.example.boylucky.anytao.view.frag;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.base.BaseFrag;
import com.example.base.mvp.BaseModel;
import com.example.boylucky.anytao.R;
import com.example.boylucky.anytao.adapter.ClassifyAdapter;
import com.example.boylucky.anytao.adapter.ClassifyChildAdapter;
import com.example.boylucky.anytao.bean.FenleiBean;
import com.example.boylucky.anytao.bean.FenleiChildBean;
import com.example.boylucky.anytao.interfaces.IClassifyView;
import com.example.boylucky.anytao.model.ClassifyModel;
import com.example.boylucky.anytao.presenter.ClassifyPresenter;
import com.example.boylucky.anytao.utils.OnItemClickListener;

import java.util.List;

/**
 * Created by BoyLucky on 2018/5/10.
 */

public class ClassfyFrag extends BaseFrag<ClassifyPresenter> implements IClassifyView{

    private RecyclerView f_xrlv;
    private RecyclerView fen_xrlv;

    @Override
    protected void initView() {
        f_xrlv = view.findViewById(R.id.f_xrlv);
        fen_xrlv = view.findViewById(R.id.fen_xrlv);
    }

    @Override
    protected void initData() {
        presenter.getDataFrom();
//        presenter.getDataFromChild(0);
    }

    @Override
    protected BaseModel initModel() {
        return new ClassifyModel();
    }

    @Override
    protected ClassifyPresenter initPresenter() {
        return new ClassifyPresenter();
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.classfy_frag;
    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess(FenleiBean fenleiBean) {
        final List<FenleiBean.DataBean> data = fenleiBean.getData();
        Log.d("class","class-----------------------------"+data.size());
        f_xrlv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        final ClassifyAdapter classifyAdapter = new ClassifyAdapter(getContext(), data);
        f_xrlv.setAdapter(classifyAdapter);
        presenter.getDataFromChild(data.get(0).getCid());
        classifyAdapter.changedChecked(0,true);
        classifyAdapter.setRlvItemClick(new OnItemClickListener() {
            @Override
            public void setOnClickListen(View view, int position) {
                classifyAdapter.changedChecked(position,true);
                presenter.getDataFromChild(data.get(position).getCid());

            }

            @Override
            public void setLongClickListen() {

            }

            @Override
            public void setOnListen(View view, String string) {

            }
        });

    }

    @Override
    public void onSuccessChild(FenleiChildBean fenleiChildBean) {
        fen_xrlv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        List<FenleiChildBean.DataBean> data = fenleiChildBean.getData();
        fen_xrlv.setAdapter(new ClassifyChildAdapter(data,getContext()));

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
