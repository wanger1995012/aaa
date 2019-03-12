package com.bawei.bean;

/**
 * @Author：lenovo
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 10:47
 * @Description：描述信息
 */
public class NewsBean {
    private NewsData data;

    public NewsBean(NewsData data) {
        this.data = data;
    }

    public NewsData getData() {
        return data;
    }

    public void setData(NewsData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NewsBean{" +
                "data=" + data +
                '}';
    }
}
