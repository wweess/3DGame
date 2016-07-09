package com.kob.a3dgame.netUtils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/7/5.
 */
public class JSONUtils {
    public static List<HashMap<String,Object>> getChapterCommentJsonList(String json){
        List<HashMap<String,Object>> dataList = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(json);
            JSONObject description =root.getJSONObject("description");
            JSONArray data = description.getJSONArray("data");
            Log.i("aaaa","------------------");
            for(int i=0;i<data.length();i++){
                HashMap<String,Object> map = new HashMap<>();
                JSONObject content = data.getJSONObject(i);
                String id = content.getString("id");
                String aid = content.getString("aid");

                String typeid = content.getString("typeid");
                String username = content.getString("username");
                String ip = content.getString("ip");

                String ip1 = content.getString("ip1");

                String ip2 = content.getString("ip2");

                String ischeck = content.getString("ischeck");
                String dtime = content.getString("dtime");
                String mid = content.getString("mid");
                String bad = content.getString("bad");
                String good = content.getString("good");

                String ftype = content.getString("ftype");
                String face = content.getString("face");
                String msg = content.getString("msg");
                String cid = content.getString("cid");

                String reid = content.getString("reid");
                String topid = content.getString("topid");
                String floor = content.getString("floor");

                String reply = content.getString("reply");
                map.put("id",id);
                map.put("aid",aid);
                map.put("typeid",typeid);
                map.put("username",username);
                map.put("ip",ip);
                map.put("ip1",ip1);

                map.put("ip2",ip2);

                map.put("ischeck",ischeck);
                map.put("dtime",dtime);
                map.put("mid",mid);
                map.put("bad",bad);
                map.put("good",good);
                map.put("ftype",ftype);
                map.put("face",face);
                map.put("msg",msg);
                map.put("mid",mid);
                map.put("cid",cid);

                map.put("reid",reid);
                map.put("topid",topid);
                map.put("floor",floor);

                map.put("reply",reply);



                dataList.add(map);

            }
            return dataList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static HashMap<String ,Object> getChapterContentJsonList(String json){
        try {
            HashMap<String ,Object> map = new HashMap<>();
            JSONObject root = new JSONObject(json);
            String id = root.getString("id");
            map.put("id",id);
            String click = root.getString("click");
            map.put("click",click);

            String title = root.getString("title");
            map.put("title",title);

            String shorttitle = root.getString("shorttitle");
            map.put("shorttitle",shorttitle);

            String writer = root.getString("writer");
            map.put("writer",writer);

            String source = root.getString("source");
            map.put("source",source);

            String litpic = root.getString("litpic");
            map.put("litpic",litpic);

            String pubdate = root.getString("pubdate");
            map.put("pubdate",pubdate);

            String senddate = root.getString("senddate");
            map.put("senddate",senddate);

            String description = root.getString("description");
            map.put("description",description);

            String typename = root.getString("typename");
            map.put("typename",typename);

            String body = root.getString("body");
            map.put("body",body);

            String arcurl = root.getString("arcurl");
            map.put("arcurl",arcurl);

            String typeurl = root.getString("typeurl");
            map.put("typeurl",typeurl);
            return map;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;

    }
    public static List<HashMap<String,Object>> getChapterListJsonList(String json){
        List<HashMap<String,Object>> dataList = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(json);
            JSONObject data = root.getJSONObject("data");
            Log.i("aaaa","------------------");
            for(int i=0;i<19;i++){
                HashMap<String,Object> map = new HashMap<>();
                JSONObject content = data.getJSONObject(i+"");
                String id = content.getString("id");
                String typeid = content.getString("typeid");

                String sortrank = content.getString("sortrank");
                String flag = content.getString("flag");
                String ismake = content.getString("ismake");
                String channel = content.getString("channel");

                String click = content.getString("click");
                Log.i("json","click:"+click);

                String title = content.getString("title");
                String shorttitle = content.getString("shorttitle");
                String color = content.getString("color");
                String writer = content.getString("writer");
                String source = content.getString("source");
                String litpic = "http://www.3dmgame.com"+content.getString("litpic");
                String pubdate = content.getString("pubdate");
                String senddate = content.getString("senddate");
                String mid = content.getString("mid");
                String keywords = content.getString("keywords");

                String description = content.getString("description");
                String filename = content.getString("filename");
                String dutyadmin = content.getString("dutyadmin");

                String weight = content.getString("weight");

                String typedir = content.getString("typedir");
                String typename = content.getString("typename");

                String isdefault = content.getString("isdefault");
                String defaultname = content.getString("defaultname");
                String namerule = content.getString("namerule");
                String namerule2 = content.getString("namerule2");

                String siteurl = content.getString("siteurl");
                String sitepath = content.getString("sitepath");
                String arcurl = content.getString("arcurl");
                String typeurl = content.getString("typeurl");

                map.put("id",id);
                map.put("typeid",typeid);

                map.put("sortrank",sortrank);
                map.put("flag",flag);
                map.put("ismake",ismake);
                map.put("channel",channel);

                map.put("click",click);

                map.put("title",title);
                map.put("shorttitle",shorttitle);
                map.put("color",color);
                map.put("writer",writer);
                map.put("source",source);
                map.put("litpic",litpic);
                map.put("pubdate",pubdate);
                map.put("senddate",senddate);
                map.put("mid",mid);
                map.put("keywords",keywords);

                map.put("description",description);
                map.put("filename",filename);
                map.put("dutyadmin",dutyadmin);

                map.put("weight",weight);

                map.put("typedir",typedir);
                map.put("typename",typename);

                map.put("isdefault",isdefault);
                map.put("defaultname",defaultname);
                map.put("namerule",namerule);
                map.put("namerule2",namerule2);

                map.put("siteurl",siteurl);
                map.put("sitepath",sitepath);
                map.put("arcurl",arcurl);
                map.put("typeurl",typeurl);

                dataList.add(map);

            }
            return dataList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<HashMap<String,Object>> getGameContentJsonList(String json){
        List<HashMap<String,Object>> list = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(json);
            JSONObject data = root.getJSONObject("data");
            Log.i("aaaa","------------------");
            for(int i=0;i<15;i++){
                HashMap<String,Object> map = new HashMap<>();
                JSONObject content = data.getJSONObject(i+"");
                String id = content.getString("id");
                String typeid = content.getString("typeid");
                String sortrank = content.getString("sortrank");
                String ismake = content.getString("ismake");
                String channel = content.getString("channel");
                String arcrank = content.getString("arcrank");
                String click = content.getString("click");
                String money = content.getString("money");
                String title = content.getString("title");
                String shorttitle = content.getString("shorttitle");
                String writer = content.getString("writer");
                String source = content.getString("source");
                String litpic = "http://www.3dmgame.com"+content.getString("litpic");
                String pubdate = content.getString("pubdate");
                String senddate = content.getString("senddate");
                String mid = content.getString("mid");
                String keywords = content.getString("keywords");

                String description = content.getString("description");
                String filename = content.getString("filename");
                String dutyadmin = content.getString("dutyadmin");

                String weight = content.getString("weight");

                String feedback = content.getString("feedback");
                String typedir = content.getString("typedir");
                String typename = content.getString("typename");
                String corank = content.getString("corank");
                String isdefault = content.getString("isdefault");
                String defaultname = content.getString("defaultname");
                String aid = content.getString("aid");
                String game_bbs = content.getString("game_bbs");
                String total = content.getString("total");
                String multiplayer = content.getString("multiplayer");
                String concept = content.getString("concept");
                String sound = content.getString("sound");
                String arcurl = content.getString("arcurl");
                String typeurl = content.getString("typeurl");
                String graphics=content.getString("graphics");
                String gameplay= content.getString("gameplay");
                String websit= content.getString("websit");
                String release_company= content.getString("release_company");
                String made_company= content.getString("made_company");
                String terrace= content.getString("terrace");
                String language= content.getString("language");
                String release_date= content.getString("release_date");
                String game_trans_name= content.getString("game_trans_name");
                String fst= content.getString("fst");
                String tid= content.getString("game_trans_name");
                map.put("id",id);
                map.put("typeid",typeid);

                map.put("sortrank",sortrank);

                map.put("ismake",ismake);
                map.put("channel",channel);
                map.put("arcrank",arcrank);
                map.put("click",click);
                map.put("money",money);
                map.put("title",title);
                map.put("shorttitle",shorttitle);

                map.put("writer",writer);
                map.put("source",source);
                map.put("litpic",litpic);
                map.put("pubdate",pubdate);
                map.put("senddate",senddate);
                map.put("mid",mid);
                map.put("keywords",keywords);

                map.put("description",description);
                map.put("filename",filename);
                map.put("dutyadmin",dutyadmin);

                map.put("weight",weight);

                map.put("feedback",feedback);
                map.put("typedir",typedir);
                map.put("typename",typename);
                map.put("corank",corank);
                map.put("isdefault",isdefault);
                map.put("defaultname",defaultname);

                map.put("aid",aid);
                map.put("game_bbs",game_bbs);
                map.put("total",total);
                map.put("multiplayer",multiplayer);
                map.put("concept",concept);
                map.put("sound",sound);


                map.put("arcurl",arcurl);
                map.put("typeurl",typeurl);


                map.put("graphics",graphics);
                map.put("gameplay",gameplay);
                map.put("websit",websit);
                map.put("release_company",release_company);
                map.put("made_company",made_company);
                map.put("terrace",terrace);

                map.put("language",language);
                map.put("release_date",release_date);
                map.put("game_trans_name",game_trans_name);
                map.put("fst",fst);
                map.put("tid",tid);

                list.add(map);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
