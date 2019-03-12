package com.bawei.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bawei.activity.R;

import java.util.List;

/**
 * @Author：lenovo
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 10:01
 * @Description：描述信息
 */
public class MyGridAdapter extends BaseAdapter {
    private List<String> list;
    private Context context;

    public MyGridAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_layout_grid,null);
            holder.t1 = view.findViewById(R.id.text_grid);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
            holder.t1.setText(list.get(i));
        return view;
    }
    class ViewHolder{
        TextView t1;
    }
}
