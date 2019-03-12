package com.bawei.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @Author：lenovo
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 8:57
 * @Description：描述信息
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        initData();
        initListener();
    }
    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    protected <T extends View> T find(int resId){
        return (T)findViewById(resId);
    }

}
