package com.example.boylucky.anytao.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.boylucky.anytao.R;
import com.example.boylucky.anytao.bean.FenleiBean;
import com.example.boylucky.anytao.utils.OnItemClickListener;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import static com.example.boylucky.anytao.R.color.colorAccent;
import static com.example.boylucky.anytao.R.color.miao;

/**
 * Created by BoyLucky on 2018/6/13.
 */

public class ClassifyAdapter extends XRecyclerView.Adapter {
    private Context context;
    private List<FenleiBean.DataBean> list;

    private OnItemClickListener onItemClickListener;


    public ClassifyAdapter(Context context, List<FenleiBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setRlvItemClick(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //找到布局
        View view = View.inflate(parent.getContext(), R.layout.item_classify, null);
        Myviewholder myviewholder = new Myviewholder(view);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final Myviewholder myviewholder = (Myviewholder) holder;
        myviewholder.c_tv.setText(list.get(position).getName());

        if (list.get(position).getChecked()){
            myviewholder.c_tv.setBackgroundColor(Color.BLUE);
        }else{
            myviewholder.c_tv.setBackgroundColor(Color.WHITE);
        }

        myviewholder.c_relative.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
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
        TextView c_tv;
        LinearLayout c_relative;
        public Myviewholder(View itemView) {
            super(itemView);
            c_tv = itemView.findViewById(R.id.c_tv);
            c_relative = itemView.findViewById(R.id.c_relative);
        }
    }

    public void changedChecked(int p,boolean b){
        for (int i = 0; i < list.size(); i++) {
            list.get(p).setChecked(false);
        }
        FenleiBean.DataBean dataBean = list.get(p);
        dataBean.setChecked(b);

        notifyDataSetChanged();
    }
}
