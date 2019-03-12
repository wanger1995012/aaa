package com.bawei.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bawei.adapter.MyFragmentAdapter;
import com.bawei.fragment.ShouFragment;
import com.bawei.fragment.WeiFragment;
import com.bawei.fragment.XiFragment;
import com.bawei.fragment.XiaoFragment;
import com.bawei.fragment.ZhaoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager pager;
    private RadioGroup group;
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        pager = find(R.id.view_pager);
        group = find(R.id.radio_group);
    }

    @Override
    protected void initData() {
        //创建五个Fragment添加入集合
        list.add(new ShouFragment());
        list.add(new XiFragment());
        list.add(new ZhaoFragment());
        list.add(new XiaoFragment());
        list.add(new WeiFragment());
        //创建适配器
        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(adapter);

    }

    @Override
    protected void initListener() {
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }
            @Override
            public void onPageSelected(int i) {
                group.check(group.getChildAt(i).getId());
            }
            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb1:
                        pager.setCurrentItem(0,false);
                        break;
                    case R.id.rb2:
                        pager.setCurrentItem(1,false);
                        break;
                    case R.id.rb3:
                        pager.setCurrentItem(2,false);
                        break;
                    case R.id.rb4:
                        pager.setCurrentItem(3,false);
                        break;
                    case R.id.rb5:
                        pager.setCurrentItem(4,false);
                        break;
                }
            }
        });
    }
}
