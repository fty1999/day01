package com.bawei.com.fantengya20190407.presenter;

import com.bawei.com.fantengya20190407.model.http.LoginUtils;
import com.bawei.com.fantengya20190407.view.interfaces.IMView;

import java.lang.ref.WeakReference;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/7 16:33:30
 * @Description:
 */
public class LoginPresenter implements IMView.IPresenter<IMView.iView> {
    private IMView.iView iView;
    private IMView.IModel iModel;
    private WeakReference<IMView.IModel> iModelWeakReference;
    private WeakReference<IMView.iView> iViewWeakReference;

    @Override
    public void requestMsg(String phone, String pwd) {
        if (phone!=null){
            iModel.requestData(phone, pwd, new IMView.IModel.CallBack() {
                @Override
                public void responseData(String msg) {
                    iView.showData(msg);
                }
            });
        }
    }

    @Override
    public void attachView(IMView.iView iView) {
        this.iView = iView;
        iModel = new LoginUtils();
        iModelWeakReference = new WeakReference<>(iModel);
        iViewWeakReference = new WeakReference<>(iView);
    }

    @Override
    public void detachView(IMView.iView iView) {
        iModelWeakReference.clear();
        iViewWeakReference.clear();
    }

}
