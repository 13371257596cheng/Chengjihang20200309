package com.bawei.chengjihang.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.chengjihang.R;
import com.bawei.chengjihang.base.BaseActivity;
import com.bawei.chengjihang.base.BasePresenter;
import com.bawei.chengjihang.contret.IHomeContert;
import com.google.gson.Gson;

public class MainActivity extends BaseActivity implements IHomeContert.IView {

    String json="http://mobile.bwstudent.com/small/user/v1/register";
    private EditText et_phone;
    private EditText et_pwd;
    private Button btn_zc;
    private Button btn_dl;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        et_phone = findViewById(R.id.et_phone);
        et_pwd = findViewById(R.id.et_pwd);
        btn_zc = findViewById(R.id.btn_zc);
        btn_dl = findViewById(R.id.btn_dl);

    }

    @Override
    protected void initData() {
        //登录
        btn_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);

            }
        });
        //注册
        btn_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "该账号已注册，请登录", Toast.LENGTH_SHORT).show();
                Log.i("Message:","注册成功");
                Log.i("status:","0000");
            }
        });
    }

    @Override
    public void getSuccess(String json) {
        Gson gson=new Gson();

    }

    @Override
    public void getError(String str) {
        Log.i("xxx",""+str);
    }

    @Override
    public void getSousuo(String json) {
        Log.i("ooo",""+json);
    }
}
