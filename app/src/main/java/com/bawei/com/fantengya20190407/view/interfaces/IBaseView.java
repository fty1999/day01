package com.bawei.com.fantengya20190407.view.interfaces;

import com.bawei.com.fantengya20190407.model.bean.ShopBean;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/7 14:13:59
 * @Description:
 */
public interface IBaseView {
    void CallBackSuccess(ShopBean shopBean);
    void CallBackFail(String errMsg);
}
