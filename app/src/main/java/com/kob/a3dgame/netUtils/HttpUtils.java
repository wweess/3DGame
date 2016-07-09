package com.kob.a3dgame.netUtils;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/7/5.
 */
public class HttpUtils {
        public void getWebcache(final String url, final CallBack callBack){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        byte[] data = request(url);
                        callBack.getresult(data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }).start();

        }
        public static  byte[] request (String urlpath){
            try {
                URL url = new URL(urlpath);
                HttpURLConnection connection =(HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                Log.i("aaaa","HttpUtils");
                connection.connect();
                Log.i("aaaa","HttpUtils"+connection.getResponseCode());
                if(connection.getResponseCode()==200){
                    InputStream inputStream = connection.getInputStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] by = new byte[1024*4];
                    int len = 0;
                    while((len=inputStream.read(by))!=-1){

                        byteArrayOutputStream.write(by,0,len);
                        byteArrayOutputStream.flush();

                    }
                    if(inputStream!=null){
                        inputStream.close();
                    }
                    byte[] data = byteArrayOutputStream.toByteArray();
                    Log.i("bbb","读取的字节长度："+data.length);

                    return data;
                }
            } catch (Exception e) {
                Log.i("bbb","文件读取异常");
            }
            return null;
        }
        public interface  CallBack{
            public void getresult(byte[] data);
        }
    }

