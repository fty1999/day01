package com.bawei.com.fantengya20190407.presenter;

import com.bawei.com.fantengya20190407.application.Contans;
import com.bawei.com.fantengya20190407.model.bean.ShopBean;
import com.bawei.com.fantengya20190407.model.http.HttpUtils;
import com.bawei.com.fantengya20190407.view.interfaces.IMainView;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/7 13:37:08
 * @Description:
 */
public class MainPresenter extends BasePresenter<IMainView<ShopBean>>{

    private final HttpUtils httpUtils;

    public MainPresenter(){
        httpUtils = HttpUtils.getInstance();
    }
    public void loadFormDataNet(){
        httpUtils.getData(Contans.URL_L1, ShopBean.class, new HttpUtils.CallBackData<ShopBean>() {

            @Override
            public void onSuccess(ShopBean shopBean) {
                getView().CallBackSuccess(shopBean);
            }

            @Override
            public void onFail(String msg) {
                getView().CallBackFail(msg);
            }
        });
    }
}
