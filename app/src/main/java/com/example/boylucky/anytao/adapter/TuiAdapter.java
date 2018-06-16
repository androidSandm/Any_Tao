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

public class TuiAdapter extends XRecyclerView.Adapter {
    private Context context;
    private List<UserBean.DataBean.TuijianBean.ListBeanX> list;

    public TuiAdapter(Context context, List<UserBean.DataBean.TuijianBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //找到布局
        View view = View.inflate(parent.getContext(), R.layout.tuijian, null);
        Myviewholder myviewholder = new Myviewholder(view);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Myviewholder myviewholder = (Myviewholder) holder;
        myviewholder.t_tv.setText(list.get(position).getTitle());
        myviewholder.t_sv.setImageURI(Uri.parse(list.get(position).getImages().split("\\|")[0]));
        Log.d("tui","miao-------------"+list.get(position).getImages().split("\\|")[0]+"tui");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Myviewholder extends XRecyclerView.ViewHolder {
        SimpleDraweeView t_sv;
        TextView t_tv;
        public Myviewholder(View itemView) {
            super(itemView);
            t_sv = itemView.findViewById(R.id.t_sv);
            t_tv = itemView.findViewById(R.id.t_tv);
        }
    }
}
