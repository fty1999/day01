package com.bawei.com.smzq;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/10 20:21:53
 * @Description:
 */
public class Fragment_one extends android.support.v4.app.Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("樊腾亚","onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("樊腾亚","onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);

        Log.e("樊腾亚","onCreateView");
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("樊腾亚","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("樊腾亚","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("樊腾亚","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("樊腾亚","onStop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("樊腾亚","onDetach");
    }
}
