package com.bawei.com.fantengya20190407.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.com.fantengya20190407.R;
import com.bawei.com.fantengya20190407.model.bean.ShopBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/7 16:07:33
 * @Description:
 */
public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.MyViewHolder>{

    private Context context;
    private List<ShopBean.ResultBean.PzshBean.CommodityListBeanX> mList = new ArrayList<>();

    public JsonAdapter(Context context) {
        this.context = context;
    }
    public void setDatae(List<ShopBean.ResultBean.PzshBean.CommodityListBeanX> list){
        mList.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item2,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.text_price.setText(mList.get(i).getCommodityName());
        Glide.with(context).load(mList.get(i).getMasterPic()).into(myViewHolder.imageView1);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView text_price;
        private final ImageView imageView1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_price = itemView.findViewById(R.id.text_price2);
            imageView1 = itemView.findViewById(R.id.image2);
        }
    }
}
