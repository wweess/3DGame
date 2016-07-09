package com.kob.a3dgame.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.kob.a3dgame.model.ChapterCommentListItem;
import com.kob.a3dgame.model.ChapterContent;
import com.kob.a3dgame.model.ChapterListItem;
import com.kob.a3dgame.model.GameContent;
import com.kob.a3dgame.netUtils.SqliteHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/7/5.
 */
public class GameDao  {
    SqliteHelper dmGameSqliteOpenHelper=null;
    public GameDao(Context context){
        dmGameSqliteOpenHelper = new SqliteHelper(context);
    }
    //文章列表插入数据
    public boolean insert(ChapterListItem chapterListItem){
        SQLiteDatabase sqLiteDatabase=null;
        try {
            sqLiteDatabase = dmGameSqliteOpenHelper.getReadableDatabase();
            sqLiteDatabase.execSQL("insert into chapterlist(id,typeid,sortrank,flag," +
                    "ismake,channel,click,title,shorttitle," +
                    "writer,source,litpic,pubdate,senddate,mid,keywords,description," +
                    "filename,dutyadmin,weight,typedir,typename," +
                    "isdefault,defaultname,namerule,namerule2," +
                    "siteurl,sitepath,arcurl,typeurl) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?,?,?,?)",new Object[]{chapterListItem.getId(),
                    chapterListItem.getTypeid(),chapterListItem.getSortrank(),chapterListItem.getFlag(),
                    chapterListItem.getIsmake(),
                    chapterListItem.getChannel(),chapterListItem.getClick(),chapterListItem.getTitle(),
                    chapterListItem.getShorttitle(),
                    chapterListItem.getWriter(),chapterListItem.getSource(),chapterListItem.getLitpic(),
                    chapterListItem.getPubdate(),
                    chapterListItem.getSenddate(), chapterListItem.getMid(),chapterListItem.getKeywords(),
                    chapterListItem.getDescription(),
                    chapterListItem.getFilename(),chapterListItem.getDutyadmin(),chapterListItem.getWeight(),
                    chapterListItem.getTypedir(),
                    chapterListItem.getTypename(),chapterListItem.getIsdefault(),chapterListItem.getDefaultname(),
                    chapterListItem.getNamerule(),chapterListItem.getNamerule2(),chapterListItem.getSiteurl(),
                    chapterListItem.getSitepath(),
                    chapterListItem.getArcurl(),chapterListItem.getTypeurl()});

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            if(sqLiteDatabase!=null){
                sqLiteDatabase.close();
            }
        }
        return true;
    }

    public boolean insert(ChapterContent chapterContent){
        SQLiteDatabase sqLiteDatabase=null;

        try {
            sqLiteDatabase = dmGameSqliteOpenHelper.getReadableDatabase();
            sqLiteDatabase.execSQL("insert into chaptercontent(id,click,title,shorttitle," +
                    "writer,source,litpic,pubdate,senddate,description,typename,body,arcurl,typeurl) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{
                    chapterContent.getId(), chapterContent.getClick(), chapterContent.getTitle(), chapterContent.getShorttitle(),
                    chapterContent.getWriter(), chapterContent.getSource(), chapterContent.getLitpic(), chapterContent.getPubdate(),
                    chapterContent.getSenddate(), chapterContent.getDescription(), chapterContent.getTypename(),
                    chapterContent.getBody(), chapterContent.getArcurl(), chapterContent.getTypeurl()});
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            if(sqLiteDatabase!=null){
                sqLiteDatabase.close();
            }
        }
        return true;
    }

    public boolean insert(ChapterCommentListItem chapterCommentListItem){
        SQLiteDatabase sqLiteDatabase=null;

        try {
            sqLiteDatabase = dmGameSqliteOpenHelper.getReadableDatabase();
            sqLiteDatabase.execSQL("insert into chaptercommentlist(id,aid,typeid,username,ip," +
                    "ip1,ip2,ischeck,dtime,mid,bad,good,ftype,face,msg,cid,reid,topid,floor,reply) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",new Object[]{
                    chapterCommentListItem.getId(),chapterCommentListItem.getAid(),chapterCommentListItem.getTypeid(),chapterCommentListItem.getUsername(),chapterCommentListItem.getIp(),
                    chapterCommentListItem.getIp1(),chapterCommentListItem.getIp2(), chapterCommentListItem.getIscheck(),chapterCommentListItem.getDtime(),chapterCommentListItem.getMid(),chapterCommentListItem.getBad(),
                    chapterCommentListItem.getGood(),chapterCommentListItem.getFtype(),chapterCommentListItem.getFace(),chapterCommentListItem.getMsg(),
                    chapterCommentListItem.getCid(),chapterCommentListItem.getReid(),chapterCommentListItem.getTopid(),chapterCommentListItem.getFloor(),
                    chapterCommentListItem.getReply()});
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            if(sqLiteDatabase!=null){
                sqLiteDatabase.close();
            }
        }
        return  true;
    }

    public boolean insert(GameContent gameContent){
        SQLiteDatabase sqLiteDatabase=null;

        try {
            sqLiteDatabase = dmGameSqliteOpenHelper.getReadableDatabase();
            sqLiteDatabase.execSQL("insert into gamecontent(id,typeid,sortrank," +
                            "ismake,channel,arcrank,click,money,title,shorttitle,writer,source,litpic," +
                            "pubdate,senddate,mid,keywords,description,filename,dutyadmin,weight,feedback," +
                            "typedir,typename,corank,isdefault,defaultname,aid,game_bbs,total,multiplayer," +
                            "concept,sound,graphics,gameplay,websit,release_company,made_company,terrace," +
                            "language,release_date,game_trans_name,fst,tid,arcurl,typeurl) values(?,?,?,?,?," +
                            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                    new Object[]{gameContent.getId(),gameContent.getTypeid(),gameContent.getSortrank(),gameContent.getIsmake(),gameContent.getChannel(),
                            gameContent.getArcrank(),gameContent.getClick(),gameContent.getMoney(),gameContent.getTitle(),gameContent.getShorttitle(),
                            gameContent.getWriter(),gameContent.getSource(),gameContent.getLitpic(),gameContent.getPubdate(),gameContent.getSenddate(),
                            gameContent.getMid(),gameContent.getKeywords(),gameContent.getDescription(),gameContent.getFilename(),gameContent.getDutyadmin(),
                            gameContent.getWeight(),gameContent.getFeedback(),gameContent.getTypedir(),gameContent.getTypename(),
                            gameContent.getCorank(),gameContent.getIsdefault(),gameContent.getDefaultname(),gameContent.getAid(),gameContent.getGame_bbs(),
                            gameContent.getTotal(),gameContent.getMultiplayer(),gameContent.getConcept(),gameContent.getSound(),gameContent.getGraphics(),
                            gameContent.getGameplay(),gameContent.getWebsit(),gameContent.getRelease_company(),gameContent.getMade_company(),
                            gameContent.getTerrace(),gameContent.getLanguage(),gameContent.getRelease_date(),gameContent.getGame_trans_name(),gameContent.getFst(),
                            gameContent.getTid(),gameContent.getArcurl(),gameContent.getTypeurl()});
        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }finally {
            if(sqLiteDatabase!=null){
                sqLiteDatabase.close();
            }
        }
        return true;
    }
    //查询
    public List<ChapterListItem> getData() {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        List<ChapterListItem> data = new ArrayList<>();
        try {
            // 1获取SqliteDataBase对象
            db = dmGameSqliteOpenHelper.getReadableDatabase();
            cursor = db.query("chapterlist",null,null,null,null,null,null);

            while (cursor.moveToNext()) { // 下一条数据
                String title = cursor.getString(cursor.getColumnIndex("title"));
                int senddate = cursor.getInt(cursor
                        .getColumnIndex("senddate"));
                String litpic = cursor.getString(cursor
                        .getColumnIndex("litpic"));
                int  click = cursor.getInt(cursor.getColumnIndex("click"));
                String arcurl = cursor.getString(cursor.getColumnIndex("arcurl"));
                HashMap<String ,Object> map = new HashMap<>();
              ChapterListItem chapterListItem=new ChapterListItem();
                chapterListItem.setTitle(title);
                chapterListItem.setSenddate(senddate+"");
                chapterListItem.setLitpic(litpic);
                chapterListItem.setClick(click+"");
                chapterListItem.setArcurl(arcurl);
                data.add(chapterListItem);
            }
            return data;

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (cursor != null && !cursor.isClosed()) { // &&短路与
                cursor.close();
            }
            if (db != null && db.isOpen()) { // &&短路与
                db.close();
            }
        }

        return null;
    }
}
