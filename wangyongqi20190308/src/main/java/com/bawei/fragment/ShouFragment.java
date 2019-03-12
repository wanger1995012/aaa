package com.bawei.fragment;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.bawei.activity.PinDaoActivity;
import com.bawei.activity.R;
import com.bawei.adapter.MyFragmentAdapters;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：lenovo
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 9:01
 * @Description：描述信息
 */
public class ShouFragment extends BaseFragment {
    private TabLayout tab_layout;
    private ViewPager pager_tab;
    private ArrayList<String> titles;
    private List<Fragment> list;
    private TextView text_pindao;
    private MyFragmentAdapters adapter;

    @Override
    protected int initLayout() {
        return R.layout.shou_fragment;
    }

    @Override
    protected void initView() {
        //获取资源控件
        tab_layout = find(R.id.tab_layout);
        pager_tab = find(R.id.view_pager_tab);
        text_pindao = find(R.id.text_pindao);
    }

    @Override
    protected void initData() {
        //添加数据
        titles = new ArrayList<String>();
        titles.add("关注");
        titles.add("推荐");
        titles.add("热点");
        titles.add("北京");
        titles.add("视频");
        list = new ArrayList<Fragment>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());
        list.add(new Fragment4());
        list.add(new Fragment5());
        //创建适配器
        adapter = new MyFragmentAdapters(getChildFragmentManager(), list, titles);
        tab_layout.setupWithViewPager(pager_tab);
        pager_tab.setAdapter(adapter);
        pager_tab.setOffscreenPageLimit(list.size());
    }

    @Override
    protected void initListener() {
        text_pindao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),PinDaoActivity.class);
                intent.putStringArrayListExtra("key",titles);
                startActivityForResult(intent,100);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == 200){
            ArrayList<String> newTitles = data.getStringArrayListExtra("key");
            list.clear();
            titles.clear();
            tab_layout.removeAllTabs();
            titles.addAll(newTitles);
            for (int i = 0; i < titles.size(); i++) {
                TabLayout.Tab tab = tab_layout.newTab();
                tab.setText(titles.get(i));
                tab_layout.addTab(tab);
                if(i == 0){
                    list.add(new Fragment1());
                }else if(i == 1){
                    list.add(new Fragment2());
                }else if(i == 2){
                    list.add(new Fragment3());
                }else if(i == 3){
                    list.add(new Fragment4());
                }else if(i == 4){
                    list.add(new Fragment5());
                }else{
                    list.add(new WeiFragment());
                }
            }
            adapter.notifyDataSetChanged();
            tab_layout.setupWithViewPager(pager_tab);
        }
    }
}
