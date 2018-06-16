package com.example.boylucky.anytao.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.boylucky.anytao.R;
import com.example.boylucky.anytao.bean.ListBean;
import com.example.boylucky.anytao.utils.OnItemClickListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by BoyLucky on 2018/6/16.
 */

public class ListAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ListBean.DataBean> list;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public ListAdapter(Context context, List<ListBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //找到布局
        View inflate = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false);
        Myviewholder myviewholder = new Myviewholder(inflate);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Myviewholder myviewholder = (Myviewholder) holder;
        myviewholder.list_price.setText(list.get(position).getPrice()+"");
        myviewholder.list_tv.setText(list.get(position).getTitle());
        myviewholder.list_sv.setImageURI(Uri.parse(list.get(position).getImages().split("\\|")[0]));
        myviewholder.list_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.setOnClickListen(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Myviewholder extends XRecyclerView.ViewHolder {
        SimpleDraweeView list_sv;
        TextView list_tv, list_price;
        LinearLayout list_ll;
        public Myviewholder(View itemView) {
            super(itemView);
            list_sv = itemView.findViewById(R.id.list_simg);
            list_tv = itemView.findViewById(R.id.list_tv);
            list_price = itemView.findViewById(R.id.list_price);
            list_ll = itemView.findViewById(R.id.list_ll);
        }
    }
}
