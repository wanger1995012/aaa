package com.bawei.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：lenovo
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 9:28
 * @Description：描述信息
 */
public class MyFragmentAdapters extends FragmentPagerAdapter {
    private List<Fragment> list;
    private ArrayList<String> titles;

    public MyFragmentAdapters(FragmentManager fm, List<Fragment> list, ArrayList<String> titles) {
        super(fm);
        this.list = list;
        this.titles = titles;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int i) {
        return titles.get(i);
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }
}
