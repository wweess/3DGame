package com.kob.a3dgame.service;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.util.Log;

import com.kob.a3dgame.dao.GameDao;
import com.kob.a3dgame.model.ChapterListItem;
import com.kob.a3dgame.netUtils.FileCache;
import com.kob.a3dgame.netUtils.ImgCompression;

import java.io.ByteArrayOutputStream;

/**
 * Created by Administrator on 2016/7/5.
 */
public class MainService extends Service {
    String url = null;
    ChapterListItem chapterListItem;
    ImgCompression imgCompression;
    FileCache fileCache;
    DMGameService dmGameService;
    GameDao dmGameInfoDao;


    @Override
    public void onCreate() {
        super.onCreate();

        imgCompression = new ImgCompression();
        fileCache = new FileCache();
        dmGameInfoDao = new GameDao(getApplicationContext());
        dmGameService = new DMGameService(getApplicationContext());

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    ////把压缩后的bitmap转化成byte数据
    public static byte[] Bitmap2Bytes(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);

        //0--100表示正常，小于0或大于100都是异常
        return byteArrayOutputStream.toByteArray();

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //使用线程下载数据
        url = intent.getStringExtra("url");
        Log.i("aaaa","===="+url);
//        load();
        Log.i("aaaa","数据下载成功");
        stopSelf();

        return super.onStartCommand(intent, flags, startId);
    }

    public  void load(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                byte[] chapterlist = HttpUtils.request(url);
//                try {
//                    if (chapterlist != null) {
//                        String json = new String(chapterlist,"utf-8");
//
//                        List<HashMap<String, Object>> dataList = JSONUtils.getChapterListJsonList(json);
//                        Log.i("aaaa","list_____________________"+dataList.size());
//                        for (HashMap<String, Object> map : dataList) {
//                            chapterListItem = new ChapterListItem();
//                            String id = map.get("id").toString();
//                            chapterListItem.setId(id);
//                            String typeid = (map.get("typeid") == null) ? null : map.get("typeid").toString();
//                            chapterListItem.setTypeid(typeid);
//
//                            String sortrank = (map.get("sortrank") == null) ? null : map.get("sortrank").toString();
//                            chapterListItem.setSortrank(sortrank);
//                            String flag = map.get("flag") == null ? null : map.get("flag").toString();
//                            chapterListItem.setFlag(flag);
//                            String ismake = map.get("ismake") == null ? null : map.get("ismake").toString();
//                            chapterListItem.setIsmake(ismake);
//                            String channel = map.get("channel") == null ? null : map.get("channel").toString();
//                            chapterListItem.setChannel(channel);
//
//                            String click = map.get("click") == null ? null : map.get("click").toString();
//                            Log.i("click", "click:" + click);
//                            chapterListItem.setClick(click);
//
//                            String title = map.get("title") == null ? null : map.get("title").toString();
//                            Log.i("title", "title:" + title);
//                            chapterListItem.setTitle(title);
//                            String shorttitle = map.get("shorttitle") == null ? null : map.get("shorttitle").toString();
//                            chapterListItem.setShorttitle(shorttitle);
//
//                            String writer = map.get("writer") == null ? null : map.get("writer").toString();
//                            chapterListItem.setWriter(writer);
//                            String source = map.get("source") == null ? null : map.get("source").toString();
//                            chapterListItem.setSource(source);
//                            String pubdate = map.get("pubdate") == null ? null : map.get("pubdate").toString();
//                            chapterListItem.setPubdate(pubdate);
//                            String senddate = map.get("senddate") == null ? null : map.get("senddate").toString();
//                            chapterListItem.setSenddate(senddate);
//                            String mid = map.get("mid") == null ? null : map.get("mid").toString();
//                            chapterListItem.setMid(mid);
//                            String keywords = map.get("keywords") == null ? null : map.get("keywords").toString();
//                            chapterListItem.setKeywords(keywords);
//
//                            String description = map.get("description") == null ? null : map.get("description").toString();
//                            chapterListItem.setDescription(description);
//                            String filename = map.get("filename") == null ? null : map.get("filename").toString();
//                            chapterListItem.setFilename(filename);
//                            String dutyadmin = map.get("dutyadmin") == null ? null : map.get("dutyadmin").toString();
//                            chapterListItem.setDutyadmin(dutyadmin);
//
//                            String weight = map.get("weight") == null ? null : map.get("weight").toString();
//                            chapterListItem.setWeight(weight);
//
//                            String typedir = map.get("typedir") == null ? null : map.get("typedir").toString();
//                            chapterListItem.setTypedir(typedir);
//                            String typename = map.get("typename") == null ? null : map.get("typename").toString();
//                            chapterListItem.setTypename(typename);
//
//                            String isdefault = map.get("isdefault") == null ? null : map.get("isdefault").toString();
//                            chapterListItem.setIsdefault(isdefault);
//                            String defaultname = map.get("defaultname") == null ? null : map.get("defaultname").toString();
//                            chapterListItem.setDefaultname(defaultname);
//                            String namerule = map.get("namerule") == null ? null : map.get("namerule").toString();
//                            chapterListItem.setNamerule(namerule);
//
//                            String siteurl = map.get("siteurl") == null ? null : map.get("siteurl").toString();
//                            chapterListItem.setSiteurl(siteurl);
//                            String sitepath = map.get("sitepath") == null ? null : map.get("sitepath").toString();
//                            chapterListItem.setSitepath(sitepath);
//                            String arcurl = map.get("arcurl") == null ? null : map.get("arcurl").toString();
//                            chapterListItem.setArcurl(arcurl);
//                            String typeurl = map.get("typeurl") == null ? null : map.get("typeurl").toString();
//                            chapterListItem.setTypeurl(typeurl);
//
//                            String litpic = map.get("litpic").toString();
//                            Log.i("sss", "picture:   " + litpic);
//                            byte[] bt = HttpUtils.request(litpic);
//                            Log.i("sss", bt.toString() + "-------bt.length:  " + bt.length);
//                            if (bt != null) {
//                                String path = litpic.substring(litpic.lastIndexOf("/")+1); //获取图片名字 xxxxxx.jpg
//                                Log.i("aaaa", "图片的名字" + path);
//                                Bitmap bitmap = imgCompression.getCompressionImage(bt, 80, 70); //压缩图片
//                                byte[] b = MainService.Bitmap2Bytes(bitmap);
//                                String sd = fileCache.saveFile(b, path); //获取保存图片文件的路径/mnt/sdcard/download
//
//                                Log.i("bbb", "缓存图片");
//                                Log.i("aaaa", "获取保存图片文件的路径" + sd);
//                                litpic = sd;  //放在数据库中的图片所在SD卡中的路径/mnt/sdcard/download/226-1606241204460-L.jpg
//
//                                chapterListItem.setLitpic(litpic); //将SD卡中图片的路径放入实体类中，存入数据库
//
//                            }
////                            dmGameService.insert(chapterListItem);
//                            Log.i("bbbb"," dmGameService.insert(chapterListItem)_________"+dmGameService.insert(chapterListItem));
//                        }
//
//
//                    }
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

    }
}
