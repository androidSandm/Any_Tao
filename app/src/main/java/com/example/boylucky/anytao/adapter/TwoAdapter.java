package com.example.boylucky.anytao.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.boylucky.anytao.R;
import com.example.boylucky.anytao.bean.FenleiChildBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by BoyLucky on 2018/6/14.
 */

public class TwoAdapter extends RecyclerView.Adapter {
    private List<FenleiChildBean.DataBean.ListBean> list;
    private Context context;

    public TwoAdapter(List<FenleiChildBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //找到布局
        View view = View.inflate(parent.getContext(), R.layout.miaosha, null);
        Myviewholder myviewholder = new Myviewholder(view);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Myviewholder myviewholder = (Myviewholder) holder;
        myviewholder.c_tv.setText(list.get(position).getName());
        myviewholder.c_sv.setImageURI(Uri.parse(list.get(position).getIcon()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Myviewholder extends XRecyclerView.ViewHolder {
        SimpleDraweeView c_sv;
        TextView c_tv;
        public Myviewholder(View itemView) {
            super(itemView);
            c_sv = itemView.findViewById(R.id.m_sv);
            c_tv = itemView.findViewById(R.id.m_tv);
        }
    }
}
