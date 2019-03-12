package com.bawei.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.activity.R;
import com.bawei.bean.News;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @Author：lenovo
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 10:53
 * @Description：多条目的适配器
 */
public class MyBaseAdapter extends BaseAdapter {

    private List<News> list;
    private Context context;

    public MyBaseAdapter(List<News> list, Context context) {
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
    public int getItemViewType(int i) {
        return i%2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)){
            case 0:
                ViewHolder1 holder1;
                if(view == null){
                    holder1 = new ViewHolder1();
                    view = View.inflate(context,R.layout.list_layout1,null);
                    holder1.text1_1 = view.findViewById(R.id.text1_1);
                    holder1.text1_2 = view.findViewById(R.id.text1_2);
                    holder1.img1 = view.findViewById(R.id.img1);
                    holder1.img2 = view.findViewById(R.id.img2);
                    holder1.img3 = view.findViewById(R.id.img3);
                    view.setTag(holder1);
                }else{
                    holder1 = (ViewHolder1) view.getTag();
                }
                holder1.text1_1.setText(list.get(i).getTitle());
                holder1.text1_2.setText(list.get(i).getCatalog_name());
                Glide.with(context).load("http://img.365jia.cn/uploads/"+list.get(i).getPics().toString()).into(holder1.img1);
                Glide.with(context).load("http://img.365jia.cn/uploads/"+list.get(i).getPics().toString()).into(holder1.img2);
                Glide.with(context).load("http://img.365jia.cn/uploads/"+list.get(i).getPics().toString()).into(holder1.img3);
                break;
            case 1:
                ViewHolder2 holder2;
                if(view == null){
                    holder2 = new ViewHolder2();
                    view = View.inflate(context,R.layout.list_layout2,null);
                    holder2.text2_1 = view.findViewById(R.id.text2_1);
                    holder2.text2_2 = view.findViewById(R.id.text2_2);
                    holder2.img2_2 = view.findViewById(R.id.img2_2);
                    view.setTag(holder2);
                }else{
                    holder2 = (ViewHolder2) view.getTag();
                }
                holder2.text2_1.setText(list.get(i).getTitle());
                holder2.text2_2.setText(list.get(i).getCatalog_name());
                Glide.with(context).load("//http://img.365jia.cn/uploads/"+list.get(i).toString()).into(holder2.img2_2);
                break;
        }

        return view;
    }
    class ViewHolder1{
        TextView text1_1,text1_2;
        ImageView img1,img2,img3;
    }
    class ViewHolder2{
        TextView text2_1,text2_2;
        ImageView img2_2;
    }
}
