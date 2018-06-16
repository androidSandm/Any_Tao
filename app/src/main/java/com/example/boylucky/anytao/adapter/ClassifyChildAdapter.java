package com.example.boylucky.anytao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.boylucky.anytao.R;
import com.example.boylucky.anytao.bean.FenleiChildBean;

import java.util.List;

/**
 * Created by BoyLucky on 2018/6/14.
 */

public class ClassifyChildAdapter extends RecyclerView.Adapter {
    private List<FenleiChildBean.DataBean> data;
    private Context context;

    public ClassifyChildAdapter(List<FenleiChildBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //找到布局
        View view = View.inflate(parent.getContext(), R.layout.twoclassitem, null);
        Myviewholder myviewholder = new Myviewholder(view);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Myviewholder myviewholder = (Myviewholder) holder;
        myviewholder.two_tv.setText(data.get(position).getName());
        List<FenleiChildBean.DataBean.ListBean> list = data.get(position).getList();
        myviewholder.two_rlv.setLayoutManager(new GridLayoutManager(context,3));
        TwoAdapter twoAdapter = new TwoAdapter(list, context);
        myviewholder.two_rlv.setAdapter(twoAdapter);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class Myviewholder extends RecyclerView.ViewHolder {
        TextView two_tv;
        RecyclerView two_rlv;
        public Myviewholder(View itemView) {
            super(itemView);
            two_tv = itemView.findViewById(R.id.two_tv);
            two_rlv = itemView.findViewById(R.id.two_rlv);
        }
    }
}
