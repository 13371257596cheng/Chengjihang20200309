package com.bawei.chengjihang.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bawei.chengjihang.R;
import com.bawei.chengjihang.base.BaseActivity;
import com.bawei.chengjihang.base.BasePresenter;
import com.bawei.chengjihang.contret.IHomeContert;

public class Main2Activity extends BaseActivity implements IHomeContert.IView {


    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void getSuccess(String json) {

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
