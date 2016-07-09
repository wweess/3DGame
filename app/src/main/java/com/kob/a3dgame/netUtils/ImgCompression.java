package com.kob.a3dgame.netUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/**
 * Created by Administrator on 2016/7/8.
 */
public class ImgCompression {
    /**
     * 得到压缩后的图片
     * @param data  图片的二进制数据
     * @param picWidth  目标图片的宽度
     * @param picHeight  目标图片高度
     * @return
     */
    public static Bitmap getCompressionImage(byte[] data, int picWidth, int picHeight) {
        Bitmap bitmap = null;
        //原始图片大小
        Bitmap initBitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        Log.i("aaaa", "原始图片大小是： " + initBitmap.getByteCount());

        //当我们设置option.inJustDecodeBounds = true  我们指获取图片大小，而不获取图片
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap beforeBitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);

        //原始图片的width height
        int width = 0;
        int height = 0;
        width = options.outWidth;
        height = options.outHeight;

        Log.i("aaaa", "原始图片的宽：" + width + "  高： " + height);

        //计算压缩比
        options.inSampleSize = calculateSampleSize(options, picWidth, picHeight);
        Log.i("aaaa", "inSampleSize=" + options.inSampleSize);

        //开始压缩图片
        options.inJustDecodeBounds = false;
        Bitmap afterBitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);
        Log.i("aaaa", "结果图片的大小：" + afterBitmap.getByteCount());
        return afterBitmap;
    }

    /**
     * 计算压缩比
     * @param options 里面包含的图片的宽高
     * @param reqWidth  目标宽度
     * @param reqHeight  目标高度
     * @return
     */

    public static int calculateSampleSize(BitmapFactory.Options options , int reqWidth, int reqHeight){
        int width = options.outWidth;
        int height = options.outHeight;

        //初始的缩放比率是
        int sampleSize = 1;
        //当现在图片的宽高大于期望的宽高，需要压缩
        if(width >reqHeight || height >reqHeight){
            //计算压缩比率
            int widthRatio = Math.round((float)width/reqWidth);
            int heightRatio = Math.round((float)height/reqHeight);
            //得到最终的压缩比
            sampleSize = widthRatio >heightRatio?heightRatio:widthRatio;

        }
        return sampleSize;

    }

}
