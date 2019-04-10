package com.bawei.com.fantengya20190407.presenter;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/7 13:36:58
 * @Description:
 */
public class BasePresenter <V>{
    public V view;
    public V getView(){
        return view;
    }
    public void setView(V view){
        this.view = view;
    }
    public void detachView(){
        this.view = null;
    }
}
