package com.bawei.com.fantengya20190407.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.com.fantengya20190407.R;
import com.bawei.com.fantengya20190407.model.bean.ShopBean;
import com.bawei.com.fantengya20190407.presenter.MainPresenter;
import com.bawei.com.fantengya20190407.view.adapter.JsonAdapter;
import com.bawei.com.fantengya20190407.view.adapter.ShopAdapter;
import com.bawei.com.fantengya20190407.view.interfaces.IMainView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/7 14:00:02
 * @Description:
 */
public class Frag_one extends Fragment implements IMainView {

    private Banner banner;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private ShopAdapter shopAdapter;
    private MainPresenter mainPresenter;
    private JsonAdapter jsonAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_one,container,false);
        banner = view.findViewById(R.id.banner);
        List<String> list = new ArrayList<>();
        list.add("http://172.17.8.100/images/small/banner/cj.png");
        list.add("http://172.17.8.100/images/small/banner/hzp.png");
        list.add( "http://172.17.8.100/images/small/banner/lyq.png");
        list.add( "http://172.17.8.100/images/small/banner/px.png");
        list.add("http://172.17.8.100/images/small/banner/wy.png");

        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                DisplayImageOptions options = new DisplayImageOptions.Builder()
                        .cacheInMemory(true)
                        .cacheOnDisk(true)
                        .build();
                com.nostra13.universalimageloader.core.ImageLoader.getInstance()
                        .displayImage((String) path,imageView,options);
            }
        });
        banner.setImages(list);
        banner.isAutoPlay(true);
        banner.setDelayTime(3000);
        banner.start();

        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        shopAdapter = new ShopAdapter(getContext());
        recyclerView.setAdapter(shopAdapter);
        mainPresenter = new MainPresenter();
        mainPresenter.setView(this);
        mainPresenter.loadFormDataNet();

        recyclerView2 = view.findViewById(R.id.recyclerView2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        jsonAdapter = new JsonAdapter(getContext());
        recyclerView.setAdapter(jsonAdapter);
        mainPresenter = new MainPresenter();
        mainPresenter.setView(this);
        mainPresenter.loadFormDataNet();

        init();
        return view;
    }

    //拦截器
    public void init() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = null;
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                builder.addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        return null;
                    }
                });
                okHttpClient = builder.build();
            }
        });
    }

    @Override
    public void CallBackSuccess(ShopBean shopBean) {
        List<ShopBean.ResultBean.RxxpBean.CommodityListBean>data = shopBean.getResult().getRxxp().getCommodityList();
        shopAdapter.setData(data);
        List<ShopBean.ResultBean.PzshBean.CommodityListBeanX> data1 = shopBean.getResult().getPzsh().getCommodityList();
        jsonAdapter.setDatae(data1);
    }

    @Override
    public void CallBackFail(String errMsg) {

    }
}
