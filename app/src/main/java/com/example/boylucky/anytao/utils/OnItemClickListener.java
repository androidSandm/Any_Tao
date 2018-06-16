package com.example.boylucky.anytao.utils;

import android.view.View;

/**
 * Created by BoyLucky on 2018/6/14.
 */

public interface OnItemClickListener {
    void setOnClickListen(View view,int position);
    void setLongClickListen();

    void setOnListen(View view,String string);
}
