package com.kob.a3dgame.service;

import android.content.Context;

import com.kob.a3dgame.dao.GameDao;
import com.kob.a3dgame.model.ChapterCommentListItem;
import com.kob.a3dgame.model.ChapterContent;
import com.kob.a3dgame.model.ChapterListItem;
import com.kob.a3dgame.model.GameContent;

import java.util.List;

/**
 * Created by Administrator on 2016/7/8.
 */
public class DMGameService {
    private Context context;
    private GameDao gameDao;
    public DMGameService(Context context){
        this.context=context;
        gameDao=new GameDao(context);
    }

    public boolean insert(ChapterListItem chapterListItem){

        return gameDao.insert(chapterListItem);
    }

    public boolean insert(ChapterContent chapterContent){

        return gameDao.insert(chapterContent);
    }

    public boolean insert(ChapterCommentListItem chapterCommentListItem){

        return  gameDao.insert(chapterCommentListItem);
    }

    public boolean insert(GameContent gameContent){

        return gameDao.insert(gameContent);
    }
    //查询
    public List<ChapterListItem> getData() {

        return gameDao.getData();
    }
}
