package com.kob.a3dgame.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kob.a3dgame.R;
import com.kob.a3dgame.adapter.ChapterContentPullToRefreshAdapter;
import com.kob.a3dgame.adapter.MainViewPagerFragmentAdapter;
import com.kob.a3dgame.dao.GameDao;
import com.kob.a3dgame.netUtils.HttpUtils;
import com.kob.a3dgame.netUtils.JSONUtils;
import com.kob.a3dgame.service.DMGameService;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class GameListViewPagerFragment extends Fragment {
    MainViewPagerFragmentAdapter mainViewPagerFragmentAdapter;
    private List<HashMap<String, Object>> mListItems, mDataUpdate;
    private PullToRefreshListView mPullRefreshListView;
    private ChapterContentPullToRefreshAdapter mAdapter;
    //    private ArrayAdapter<String> mAdapter;
    private DMGameService dmGameService;
    ListView lv;

    private GameDao gamedao;
    private String url;

    public GameListViewPagerFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hotnewsfragment, null);
        mPullRefreshListView = (PullToRefreshListView) view.findViewById(R.id.main_articlefragment_pullrefreshlist);
        mPullRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);

        mListItems = new ArrayList<>();
        GetDataTask task = new GetDataTask();
        task.execute(url);
        lv = mPullRefreshListView.getRefreshableView();
        Log.i("ppppp", "onCreateView: " + mListItems.toString());

        mAdapter = new ChapterContentPullToRefreshAdapter(getContext(), mListItems);
        Log.i("pppp", "onPostExecute:======== " + "onRefreshComplete");
        lv.setAdapter(mAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GetDataTask task = new GetDataTask();
                task.execute(url);
            }
        });


        return view;
    }

    public void msage(String data) {
        url = data;
        Log.i("pppppp", "msage: " + data);
    }

    private class GetDataTask extends AsyncTask<String, Void, List<HashMap<String, Object>>> {

        @Override
        protected List<HashMap<String, Object>> doInBackground(String... params) {
            // Simulates a background job.
//			dmGameService.getData();
            byte[] b = HttpUtils.request(params[0]);
            if (b != null) {
                try {
                    String json = new String(b, "utf-8");
                    Log.i("pppp", "doInBackground: =========");
                    return JSONUtils.getChapterListJsonList(json);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<HashMap<String, Object>> result) {
            super.onPostExecute(result);
            mListItems.addAll(result);
            mAdapter.notifyDataSetChanged();
            Log.i("pppp", "====****===" + mListItems.toString());

        }
    }


}
