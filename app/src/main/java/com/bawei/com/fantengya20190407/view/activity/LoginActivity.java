package com.bawei.com.fantengya20190407.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.com.fantengya20190407.R;
import com.bawei.com.fantengya20190407.model.bean.LoginBean;
import com.bawei.com.fantengya20190407.presenter.LoginPresenter;
import com.bawei.com.fantengya20190407.view.interfaces.IMView;
import com.google.gson.Gson;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/7 16:28:16
 * @Description:
 */
public class LoginActivity extends BaseActivity implements IMView.iView {
    private Button login_button;
    private TextView register_text;
    private EditText phone_edit;
    private EditText pwd_edit;
    private CheckBox rememb;
    private SharedPreferences sp;
    private LoginPresenter loginPresenter;

    @Override
    protected void initView() {
        login_button = findViewById(R.id.login_button);
        register_text = findViewById(R.id.text1);
        phone_edit = findViewById(R.id.editText0);
        pwd_edit = findViewById(R.id.editText1);
        rememb = findViewById(R.id.checkbox0);
    }
    @Override
    protected void initData() {
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = phone_edit.getText().toString();
                String pwd = pwd_edit.getText().toString();
                if (phone.equals("")&&pwd.equals("")){
                    Toast.makeText(LoginActivity.this,"手机号或者密码不能为空", Toast.LENGTH_LONG).show();;
                    return;
                }
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("phone",phone);
                edit.putString("pwd",pwd);
                edit.putBoolean("记住密码",rememb.isChecked());

                edit.commit();
                loginPresenter.requestMsg(phone,pwd);
            }
        });
        register_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }
        });
        sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        if (sp.getBoolean("记住密码",false)){
            String pwd2 = sp.getString("pwd", "");
            pwd_edit.setText(pwd2);
            rememb.setChecked(true);
        }

        String phone2 = sp.getString("phone", "");
        phone_edit.setText(phone2);

        loginPresenter = new LoginPresenter();
        loginPresenter.attachView(this);
    }
    @Override
    public void showData(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this,msg,Toast.LENGTH_SHORT).show();
                Gson gson = new Gson();
                LoginBean loginBean = gson.fromJson(msg, LoginBean.class);
                String status = loginBean.getStatus();
                if (status.equals("0000")){
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    @Override
    protected int setSelfView() {
        return R.layout.activity_login;
    }

}
