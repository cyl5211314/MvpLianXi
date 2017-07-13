package com.example.lenovo.mvplianxi.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/7/11 16:17
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentView());
        initView();
        initData();
        initDataFromServer();
    }
    abstract int setContentView();
    abstract void initView();
    abstract void  initData();
    abstract void initDataFromServer();
}
