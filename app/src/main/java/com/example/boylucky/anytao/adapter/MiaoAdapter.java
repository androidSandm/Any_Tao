package com.example.boylucky.anytao.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.boylucky.anytao.R;
import com.example.boylucky.anytao.bean.UserBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by BoyLucky on 2018/6/13.
 */

public class MiaoAdapter extends XRecyclerView.Adapter {
    private Context context;
    private List<UserBean.DataBean.MiaoshaBean.ListBean> list;

    public MiaoAdapter(Context context, List<UserBean.DataBean.MiaoshaBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //找到布局
        View inflate = LayoutInflater.from(context).inflate(R.layout.miaosha, parent,false);
        Myviewholder myviewholder = new Myviewholder(inflate);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Myviewholder myviewholder = (Myviewholder) holder;
        myviewholder.m_tv.setText(list.get(position).getPrice()+"");
        myviewholder.m_sv.setImageURI(Uri.parse(list.get(position).getImages().split("\\|")[0]));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Myviewholder extends XRecyclerView.ViewHolder {
        SimpleDraweeView m_sv;
        TextView m_tv;
        public Myviewholder(View itemView) {
            super(itemView);
            m_sv = itemView.findViewById(R.id.m_sv);
            m_tv = itemView.findViewById(R.id.m_tv);
        }
    }
}
