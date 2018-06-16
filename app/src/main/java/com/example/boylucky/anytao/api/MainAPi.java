package com.example.boylucky.anytao.api;



import com.example.boylucky.anytao.bean.FenleiBean;
import com.example.boylucky.anytao.bean.FenleiChildBean;
import com.example.boylucky.anytao.bean.ListBean;
import com.example.boylucky.anytao.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by BoyLucky on 2018/6/12.
 */

public interface MainAPi {
    //首页
    @GET("home/getHome")
    Observable<UserBean> getAd();
    //分类
    @GET("product/getCatagory")
    Observable<FenleiBean> getAd1();
    //分类
    @GET("product/getProductCatagory")
    Observable<FenleiChildBean> getAd2(@Query("cid") int cid);
    //搜索
    @GET("product/searchProducts")
    Observable<ListBean> getAd3(@Query("keywords") String keywords);
}
