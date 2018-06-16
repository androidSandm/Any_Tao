package com.example.boylucky.anytao.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class FeiLeiAdapter extends XRecyclerView.Adapter {
    private Context context;
    private List<UserBean.DataBean.FenleiBean> list;

    public FeiLeiAdapter(Context context, List<UserBean.DataBean.FenleiBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //找到布局
        View view = View.inflate(parent.getContext(), R.layout.feilei, null);
        Myviewholder myviewholder = new Myviewholder(view);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Myviewholder myviewholder = (Myviewholder) holder;
        myviewholder.f_tv.setText(list.get(position).getName());
        myviewholder.f_sv.setImageURI(Uri.parse(list.get(position).getIcon()));
        Log.d("fei","fei-------------"+list.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Myviewholder extends XRecyclerView.ViewHolder {
        SimpleDraweeView f_sv;
        TextView f_tv;
        public Myviewholder(View itemView) {
            super(itemView);
            f_sv = itemView.findViewById(R.id.f_sv);
            f_tv = itemView.findViewById(R.id.f_tv);
        }
    }
}
