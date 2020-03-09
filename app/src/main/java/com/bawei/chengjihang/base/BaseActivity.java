package com.bawei.chengjihang.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public  P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        initData();
        presenter=initPresenter();
    }

    protected abstract P initPresenter();
    //获取布局
    protected abstract int getLayout();
    //初始化控件
    protected abstract void initView();
    //获取数据
    protected abstract void initData();

}
