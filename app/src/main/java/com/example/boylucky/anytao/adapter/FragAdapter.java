package com.example.boylucky.anytao.adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.boylucky.anytao.R;
import com.example.boylucky.anytao.bean.UserBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by BoyLucky on 2018/6/13.
 */

public class FragAdapter extends Adapter {
    private Context context;
    private UserBean.DataBean data;

    private final int TYPEONE = 0;
    private final int TYPETWO = 1;
    private final int TYPETHREE = 2;
    private final int TYPEFOUR = 3;

    private Handler handler ;

    public FragAdapter(Context context, UserBean.DataBean data) {
        this.context = context;
        this.data = data;

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return TYPEONE;
        }else if (position == 1){
            return TYPETWO;
        }else if (position == 2){
            return TYPETHREE;
        }else{
            return TYPEFOUR;
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPEONE){
            //找到布局
            View view = View.inflate(parent.getContext(), R.layout.item_banner, null);
            Myviewholder myviewholder = new Myviewholder(view);
            return myviewholder;
        }else if (viewType == TYPETWO){
            //找到布局
            View view = View.inflate(parent.getContext(), R.layout.item_jiugong, null);
            Myviewholder1 myviewholder = new Myviewholder1(view);
            return myviewholder;
        }else if (viewType == TYPETHREE){
            //找到布局
            View view = View.inflate(parent.getContext(), R.layout.item_miaosha, null);
            Myviewholder2 myviewholder = new Myviewholder2(view);
            return myviewholder;
        }else{
            //找到布局
            View view = View.inflate(parent.getContext(), R.layout.item_tuijian, null);
            Myviewholder3 myviewholder = new Myviewholder3(view);
            return myviewholder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPEONE){
            Myviewholder myviewholder = (Myviewholder) holder;
            List<UserBean.DataBean.BannerBean> banner = data.getBanner();
            List<String> img = new ArrayList<>();
            for (int i = 0; i < banner.size(); i++) {
                img.add(banner.get(i).getIcon());
            }
            myviewholder.banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    imageView.setImageURI(Uri.parse((String) path));
                }

                @Override
                public ImageView createImageView(Context context) {
                    SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
                    return simpleDraweeView;
                }
            }).setImages(img)
                    .start();
        }else if (getItemViewType(position) == TYPETWO){
            Myviewholder1 myviewholder1 = (Myviewholder1) holder;
            List<UserBean.DataBean.FenleiBean> fenlei = data.getFenlei();
            Log.d("tui","分类-------------"+fenlei.size());
            myviewholder1.xrlv_j.setLayoutManager(new GridLayoutManager(context,2,RecyclerView.HORIZONTAL,false));
            FeiLeiAdapter feiLeiAdapter = new FeiLeiAdapter(context, fenlei);
            myviewholder1.xrlv_j.setAdapter(feiLeiAdapter);

        }else if (getItemViewType(position) == TYPETHREE){
            final Myviewholder2 myviewholder2 = (Myviewholder2) holder;

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    Looper.prepare();
//                    handler = new Handler(){
//                        @Override
//                        public void handleMessage(Message msg) {
//                            super.handleMessage(msg);
//                            setTime(myviewholder2);
//                        }
//                    };
//                    Looper.loop();

//                    message.obj = myviewholder2;
                    setTime(myviewholder2);

//                }
//            }).start();
//            Message message = new Message();
//            handler.sendMessage(message);
            List<UserBean.DataBean.MiaoshaBean.ListBean> list = data.getMiaosha().getList();
            Log.d("tui","秒杀-------------"+list.size());
            myviewholder2.xrlv_m.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            MiaoAdapter miaoAdapter = new MiaoAdapter(context, list);
            myviewholder2.xrlv_m.setAdapter(miaoAdapter);

        }else{
            Myviewholder3 myViewHolder3 = (Myviewholder3) holder;
            List<UserBean.DataBean.TuijianBean.ListBeanX> list = data.getTuijian().getList();
            Log.d("tui","推荐-------------"+list.size());
            TuiAdapter t_adapter = new TuiAdapter(context,list);
            myViewHolder3.xrlv_t.setLayoutManager(new GridLayoutManager(context,2));
            myViewHolder3.xrlv_t.setAdapter(t_adapter);
        }


    }

    @Override
    public int getItemCount() {
        return 4;
    }
    class Myviewholder extends XRecyclerView.ViewHolder{
        Banner banner;
        public Myviewholder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }
    class Myviewholder1 extends XRecyclerView.ViewHolder{
        RecyclerView xrlv_j;
        public Myviewholder1(View itemView) {
            super(itemView);
            xrlv_j = itemView.findViewById(R.id.xrlv_j);
        }
    }
    class Myviewholder2 extends XRecyclerView.ViewHolder{
        RecyclerView xrlv_m;
        private TextView miaosha_time;
        private TextView miaosha_shi;
        private TextView miaosha_minter;
        private TextView miaosha_second;
        public Myviewholder2(View itemView) {
            super(itemView);
            xrlv_m = itemView.findViewById(R.id.xrlv_m);
            miaosha_time = itemView.findViewById(R.id.tv_miaosha_time);
            miaosha_shi = itemView.findViewById(R.id.tv_miaosha_shi);
            miaosha_minter = itemView.findViewById(R.id.tv_miaosha_minter);
            miaosha_second = itemView.findViewById(R.id.tv_miaosha_second);
        }
    }
    class Myviewholder3 extends XRecyclerView.ViewHolder{
        XRecyclerView xrlv_t;
        public Myviewholder3(View itemView) {
            super(itemView);
            xrlv_t = itemView.findViewById(R.id.xrlv_t);
        }
    }
    //秒杀倒计时
    public void setTime(Myviewholder2 myviewholder2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String format = df.format(curDate);
        StringBuffer buffer = new StringBuffer();
        String substring = format.substring(0, 11);
        buffer.append(substring);
        Log.d("ccc", substring);
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour % 2 == 0) {
            myviewholder2.miaosha_time.setText(hour + "点场");
            buffer.append((hour + 2));
            buffer.append(":00:00");
        } else {
            myviewholder2.miaosha_time.setText((hour - 1) + "点场");
            buffer.append((hour + 1));
            buffer.append(":00:00");
        }
        String totime = buffer.toString();
        try {
            java.util.Date date = df.parse(totime);
            java.util.Date date1 = df.parse(format);
            long defferenttime = date.getTime() - date1.getTime();
            long days = defferenttime / (1000 * 60 * 60 * 24);
            long hours = (defferenttime - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minute = (defferenttime - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
            long seconds = defferenttime % 60000;
            long second = Math.round((float) seconds / 1000);
            myviewholder2.miaosha_shi.setText("0" + hours + "");
            if (minute >= 10) {
                myviewholder2.miaosha_minter.setText(minute + "");
            } else {
                myviewholder2.miaosha_minter.setText("0" + minute + "");
            }
            if (second >= 10) {
                myviewholder2.miaosha_second.setText(second + "");
            } else {
                myviewholder2.miaosha_second.setText("0" + second + "");
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
