package com.bawei.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bawei.helper.MyHelper;

/**
 * @Author：lenovo
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 10:20
 * @Description：描述信息
 */
public class MyDao {
    private MyHelper helper;
    private String table = "user";

    public MyDao(Context context) {
        helper = new MyHelper(context);
    }
    public void insertData(String top,String down){
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("top" ,top);
        values.put("down",down);
        database.insert(table,null,values);
    }
    public String selectData(String s){
        String down = "";
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query(table, null, "down=?", new String[]{down}, null, null, null);
        while (cursor.moveToNext()){
            down = cursor.getString(cursor.getColumnIndex("down"));
        }
        return down;
    }
}
