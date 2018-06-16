package com.example.boylucky.anytao.interfaces;

import com.example.base.mvp.IBaseView;
import com.example.boylucky.anytao.bean.FenleiBean;
import com.example.boylucky.anytao.bean.FenleiChildBean;
import com.example.boylucky.anytao.bean.UserBean;

/**
 * Created by BoyLucky on 2018/6/12.
 */

public interface IClassifyView extends IBaseView {
    void onError();
    void onSuccess(FenleiBean fenleiBean);
    void onSuccessChild(FenleiChildBean fenleiChildBean);
}
