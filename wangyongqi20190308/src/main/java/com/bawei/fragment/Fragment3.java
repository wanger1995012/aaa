package com.bawei.fragment;


import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.activity.R;
import com.bawei.adapter.MyBaseAdapter;
import com.bawei.bean.News;
import com.bawei.bean.NewsBean;
import com.bawei.bean.NewsData;
import com.bawei.util.Utils;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：lenovo
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 9:01
 * @Description：多条目+ 上下拉加载刷新
 */
public class Fragment3 extends BaseFragment {

    private PullToRefreshListView list_view;
    private String mUrl = "http://365jia.cn/news/api3/365jia/news/categories/hotnews?page=";

    private int page = 1;
    private String mUrls;
    private List<News> list = new ArrayList<News>();
    private MyBaseAdapter adapter;

    @Override
    protected int initLayout() {
        return R.layout.fragment3;
    }

    @Override
    protected void initView() {
        list_view = find(R.id.p_list_view);
        list_view.setMode(PullToRefreshBase.Mode.BOTH);
        list_view.setScrollingWhileRefreshingEnabled(true);
    }

    @Override
    protected void initData() {
            //创建适配器
            adapter = new MyBaseAdapter(list, getActivity());
            list_view.setAdapter(adapter);
            //请求数据
            getData(page);
    }

    private void getData(int p) {

        mUrls = mUrl+p;
        Utils.MyTask(mUrls, new Utils.MyCallBack() {
            @Override
            public void getData(String str) {
                //解析
                jsonParse(str);
            }
        });
    }

    private void jsonParse(String str) {
        Gson gson = new Gson();
        NewsBean newsBean = gson.fromJson(str, NewsBean.class);
        NewsData datas = newsBean.getData();
        datas.getData();
        list.addAll(datas.getData());
        Log.i("aaa", "jsonParse: "+list.toString());
        //刷新适配器
        adapter.notifyDataSetChanged();
        //停止上下拉刷新
        list_view.onRefreshComplete();
    }

    @Override
    protected void initListener() {
        list_view.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                list.clear();
                getData(page);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                getData(page);
            }
        });
    }
}
