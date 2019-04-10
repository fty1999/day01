package com.bawei.com.fantengya20190407.view.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bawei.com.fantengya20190407.R;
import com.bawei.com.fantengya20190407.view.fragment.Frag_five;
import com.bawei.com.fantengya20190407.view.fragment.Frag_four;
import com.bawei.com.fantengya20190407.view.fragment.Frag_one;
import com.bawei.com.fantengya20190407.view.fragment.Frag_three;
import com.bawei.com.fantengya20190407.view.fragment.Frag_two;

public class MainActivity extends FragmentActivity {

    private FrameLayout frameLayout;
    private RadioGroup radioGroup;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找ID
        frameLayout = findViewById(R.id.fram);
        radioGroup = findViewById(R.id.radioGroup);

        manager = getSupportFragmentManager();

        final Frag_one one = new Frag_one();
        final Frag_two two = new Frag_two();
        final Frag_three three = new Frag_three();
        final Frag_four four = new Frag_four();
        final Frag_five five = new Frag_five();
        manager.beginTransaction()
                .add(R.id.fram,one)
                .add(R.id.fram,two)
                .add(R.id.fram,three)
                .add(R.id.fram,four)
                .add(R.id.fram,five)
                .commit();

        manager.beginTransaction().hide(five).hide(four).hide(three).hide(two).show(one).commit();
        radioGroup.check(radioGroup.getChildAt(0).getId());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radio0:
                    manager.beginTransaction().hide(five).hide(four).hide(three).hide(two).show(one).commit();
                    break;
                    case R.id.radio1:
                    manager.beginTransaction().hide(five).hide(four).hide(three).hide(one).show(two).commit();
                    break;
                    case  R.id.radio2:
                    manager.beginTransaction().hide(five).hide(four).hide(one).hide(two).show(three).commit();
                    break;
                    case R.id.radio3:
                    manager.beginTransaction().hide(five).hide(one).hide(three).hide(two).show(four).commit();
                    break;
                    case R.id.radio4:
                    manager.beginTransaction().hide(one).hide(four).hide(three).hide(two).show(five).commit();
                    break;
                }
            }
        });
    }
}
