package com.kob.a3dgame.netUtils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2016/7/5.
 */
public class SqliteHelper extends SQLiteOpenHelper {
    public SqliteHelper(Context context) {
        super(context, "dmgame.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("sss","创建数据库前");
        //创建文章列表数据
        sqLiteDatabase.execSQL("create table if not exists chapterlist( num integer primary key," +
                "id varchar(20),typeid varchar(200)," +
                "sortrank  varchar(200), flag  varchar(200),ismake varchar(200),channel varchar(200)," +
                "click varchar(200), title varchar(200),shorttitle varchar(200)," +
                "writer varchar(200),source varchar(200),litpic varchar(200)," +
                "pubdate varchar(200),senddate varchar(100),mid varchar(200)," +
                "keywords varchar(200), description varchar(200),filename varchar(200), " +
                "dutyadmin varchar(200), weight varchar(200), typedir varchar(200), typename varchar(200)," +
                " isdefault varchar(200), defaultname varchar(200), " +
                "namerule varchar(200),namerule2 varchar(200), " +
                "siteurl varchar(200),sitepath varchar(200), " +
                "arcurl varchar(200),typeurl varchar(200))");
        Log.i("sss","创建数据库chapterlist");
        //创建文章详情 数据表
        sqLiteDatabase.execSQL("create table if not exists chaptercontent(id varchar(20),click varchar(200)," +
                "title varchar(200),shorttitle varchar(200),writer varchar(200),source varchar(200)," +
                "litpic varchar(200),pubdate varchar(200),senddate varchar(100),description varchar(200)," +
                "typename varchar(200), body varchar(200),arcurl varchar(200),typeurl varchar(200))");

        //创建评论列表实体 数据
        sqLiteDatabase.execSQL("create table if not exists chaptercommentlist(id varchar(20),typeid varchar(200)," +
                "username varchar(200),ip  varchar(200),ip1  varchar(200),ip2 varchar(200),ischeck varchar(200)," +
                "dtime varchar(200),mid varchar(200),bad varchar(200)," +
                "good varchar(200),ftype varchar(200),face varchar(200),msg varchar(200),cid varchar(200)," +
                "reid varchar(200)," +
                "topid varchar(200),floor varchar(100),reply varchar(200))");

        //创建游戏详情 数据
        sqLiteDatabase.execSQL("create table if not exists gamecontent(id varchar(20)," +
                "typeid varchar(200),sortrank  varchar(200),ismake  varchar(200)," +
                "channel varchar(200),arcrank varchar(200),click varchar(200),money varchar(200)," +
                "title varchar(200),shorttitle varchar(200),writer varchar(200),source varchar(200)," +
                "litpic varchar(200),pubdate varchar(200),senddate varchar(100),mid varchar(200)," +
                "keywords varchar(200), description varchar(200),filename varchar(200), dutyadmin varchar(200)," +
                "weight varchar(200), feedback varchar(200), typedir varchar(200), typename varchar(200)," +
                "corank varchar(200), isdefault varchar(200), defaultname varchar(200), " +
                "aid varchar(200), game_bbs varchar(200), total varchar(200),multiplayer varchar(200), " +
                "concept varchar(200),sound varchar(200),graphics varchar(200)" +
                ",gameplay varchar(200), websit varchar(200), release_company varchar(200)," +
                "made_company varchar(200), terrace varchar(200),language varchar(200),release_date varchar(200)," +
                "game_trans_name varchar(200), fst varchar(200), tid varchar(200),arcurl varchar(200), " +
                "typeurl varchar(200))");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
