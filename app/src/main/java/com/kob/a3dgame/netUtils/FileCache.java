package com.kob.a3dgame.netUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2016/7/8.
 */
public class FileCache {
    boolean isMounted = false;
    File root=null;
    public synchronized String saveFile(byte[] data ,String fileName){

        String filepath=null;
        Log.i("sss","----------------------------Environment.getExternalStorageState()"+ Environment.getExternalStorageState());
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            isMounted = true;
            root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(root,fileName);
            filepath = file.getAbsolutePath();
            Log.i("sss","---------------------------------filepath"+filepath);
            Log.i("sss","---------------------------------filepath"+file.toString());

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(data,0,data.length);
                Log.i("sss","file大小    "+file.length());
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return filepath;
    }
    //
    //从SD卡中获取图片
    public Bitmap getFile(String urlStr){
        Bitmap bitmap = null;
        if(isMounted){
            if(root.exists()){
                //获取网络图片的名字
                String fileName = urlStr.substring(urlStr.lastIndexOf("/")+1);
                File getFile = new File(root,fileName);
                if(getFile.exists()){
                    bitmap = BitmapFactory.decodeFile(getFile.getAbsolutePath());
                }
            }
        }
        return null;
    }

    public boolean deleteFile(String urlStr){
        if(isMounted){
            if(urlStr!=null) {
                String deleteName = urlStr.substring(urlStr.lastIndexOf("/") + 1);

                File deleteFile = new File(root,deleteName);
                if(deleteFile.exists()){
                    return   deleteFile.delete();
                }
            }
        }
        return false;
    }
    //从sd卡中清空缓存文件
    public void clear(){
        if(isMounted){
            File[] allFile = root.listFiles();
            for (File file :allFile){
                file.delete();
            }
        }
    }
}
