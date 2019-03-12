package com.bawei.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author：lenovo
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 10:13
 * @Description：工具类
 */
public class Utils {
    //网络状态
    public static boolean isNetState(Context context){
        if(context != null){
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if(info != null){
                return info.isConnected();
            }
        }
        return false;
    }
    //获取数据
    public static String getNetData(String string){
        try {
            URL url = new URL(string);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int code = connection.getResponseCode();
            if(code == 200){
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder = new StringBuilder();
                String str = "";
                while ((str=reader.readLine())!= null){
                    builder.append(str);
                }
                return builder.toString();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return "";
    }
    //接口回传的异步请求

    public interface MyCallBack{
        void getData(String str);
    }
    public static void MyTask(String url, final MyCallBack callBack){
        new AsyncTask<String , Void , String>(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                callBack.getData(s);
            }

            @Override
            protected String doInBackground(String... strings) {
                return getNetData(strings[0]);
            }
        }.execute(url);

    }
}
