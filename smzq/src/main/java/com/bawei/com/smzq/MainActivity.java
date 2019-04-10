package com.bawei.com.smzq;

import android.nfc.Tag;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private ViewPager pager;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Log.e("樊腾亚==","onCreate"+"创建");

        pager = findViewById(R.id.pager);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.check(radioGroup.getChildAt(0).getId());

        final ArrayList<Fragment> list1 = new ArrayList<>();
        list1.add(new Fragment_one());
        list1.add(new Fragment_two());

        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list1.get(i);
            }

            @Override
            public int getCount() {
                return list1.size();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radio0:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.radio1:
                        pager.setCurrentItem(1);
                        break;
                }
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("樊腾亚==","onStart"+"开始");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("樊腾亚==","onResume"+"获取焦点");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("樊腾亚==","onPause"+"失去焦点");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("樊腾亚==","onStop"+"停止");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("樊腾亚==","onDestroy"+"销毁");
    }
}
