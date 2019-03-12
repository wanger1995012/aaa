package com.bawei.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.bawei.adapter.MyGridAdapter;
import com.bawei.dao.MyDao;
import com.bawei.util.Utils;

import java.util.ArrayList;

/**
 * 频道管理的实现
 */
public class PinDaoActivity extends BaseActivity {

    private TextView text_finish;
    private GridView grid_top,grid_xia;
    private ArrayList<String> tops,xias;
    private MyGridAdapter tAdapter;
    private MyGridAdapter xAdapter;
    private MyDao dao;

    @Override
    protected int initLayout() {
        return R.layout.activity_pin_dao;
    }

    @Override
    protected void initView() {
        text_finish = find(R.id.text_finish);
        grid_top = find(R.id.grid_top);
        grid_xia = find(R.id.grid_xia);

    }

    @Override
    protected void initData() {
        dao = new MyDao(this);
        if(Utils.isNetState(this)){
            tops = getIntent().getStringArrayListExtra("key");
            xias = new ArrayList<String>();
            for (int i = 0; i < 10; i++) {
                xias.add("频道"+i);
            }
            //清除xias中的重复频道
            xias.removeAll(tops);
            dao.insertData(tops.toString(),xias.toString());
            //创建适配器适配上下grid
            tAdapter = new MyGridAdapter(tops, this);
            xAdapter = new MyGridAdapter(xias, this);
            grid_top.setAdapter(tAdapter);
            grid_xia.setAdapter(xAdapter);
        }else{
            //没网查询数据库
            String s = dao.selectData(xias.toString());

        }

    }

    @Override
    protected void initListener() {
        //上方的监听。
        grid_top.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //添加到下方
                xias.add(tops.get(i));
                //删除上方的item
                tops.remove(i);
                //刷新适配器
                tAdapter.notifyDataSetChanged();
                xAdapter.notifyDataSetChanged();
            }
        });
        //下方的监听
        grid_xia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //添加到上方
                tops.add(xias.get(i));
                //删除下方的item
                xias.remove(i);
                //刷新适配器
                tAdapter.notifyDataSetChanged();
                xAdapter.notifyDataSetChanged();
            }
        });
        text_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putStringArrayListExtra("key",tops);
                setResult(200,intent);
                finish();
            }
        });
    }
}
