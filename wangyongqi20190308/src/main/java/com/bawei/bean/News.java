package com.bawei.bean;

import java.util.List;

/**
 * @Author：lenovo
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 10:48
 * @Description：描述信息
 */
public class News {
    private String title;
    private List<String> pics;
    private String catalog_name;

    public News(String title, List<String> pics, String catalog_name) {
        this.title = title;
        this.pics = pics;
        this.catalog_name = catalog_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    public String getCatalog_name() {
        return catalog_name;
    }

    public void setCatalog_name(String catalog_name) {
        this.catalog_name = catalog_name;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", pics=" + pics +
                ", catalog_name='" + catalog_name + '\'' +
                '}';
    }
}
