package com.bawei.bean;

import java.util.List;

/**
 * @Author：lenovo
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 10:47
 * @Description：描述信息
 */
public class NewsData {
    private List<News> data;

    public NewsData(List<News> data) {
        this.data = data;
    }

    public List<News> getData() {
        return data;
    }

    public void setData(List<News> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NewsData{" +
                "data=" + data +
                '}';
    }
}
