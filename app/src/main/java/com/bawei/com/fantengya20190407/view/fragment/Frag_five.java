package com.bawei.com.fantengya20190407.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.com.fantengya20190407.R;
import com.bawei.com.fantengya20190407.view.activity.LoginActivity;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/7 14:00:02
 * @Description:
 */
public class Frag_five extends Fragment {

    private TextView textView_login;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_five,container,false);
        textView_login = view.findViewById(R.id.text_login);
        textView_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
        return view;
    }
}
