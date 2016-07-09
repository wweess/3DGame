package com.kob.a3dgame.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.kob.a3dgame.GameWebViewActivity;
import com.kob.a3dgame.R;
import com.kob.a3dgame.adapter.GameContentPullToRefreshAdapter;
import com.kob.a3dgame.netUtils.HttpUtils;
import com.kob.a3dgame.netUtils.JSONUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameFragment extends Fragment {
    static final int MENU_SET_MODE = 0;

    private List<HashMap<String,Object>> mListItems,mDataUpdate;
    private PullToRefreshGridView mPullRefreshGridView;
    private GridView mGridView;
    private GameContentPullToRefreshAdapter mAdapter;
    private int pager=1 ,typeid=179;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.activity_game,null);
        Spinner spinner=(Spinner)view.findViewById(R.id.game_fragment_spinner);
        String[] str={"动作(ACT)181","182射击(FPS)","183角色扮演(RPG)","184养成(GAL)"
                ,"185益智(PUZ)"," 186即时战略(RTS)","187策略(SLG)"," 188体育(SPG)","189模拟经营(SIM)"
               ,"190赛车(RAC)","191冒险(AVG)","192动作角色(ARPG)"};
ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),R.layout.game_spinner_item,R.id.game_spinner_tv,str);
spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        typeid=181;
                        break;
                    case 1:
                        typeid=182;
                        break;
                    case 2:
                        typeid=183;
                        break;
                    case 3:
                        typeid=184;
                        break;
                    case 4:
                        typeid=185;
                        break;
                    case 5:
                        typeid=186;
                        break;
                    case 6:
                        typeid=187;
                        break;
                    case 7:
                        typeid=188;
                        break;
                    case 8:
                        typeid=189;
                        break;
                    case 9:
                        typeid=190;
                        break;
                    case 10:
                        typeid=191;
                        break;
                    case 11:
                        typeid=192;
                        break;
                }
                new GetDataTask().execute("http://www.3dmgame.com/sitemap/api.php?row=15&typeid="+typeid+"&paging=1&page="+pager);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mPullRefreshGridView = (PullToRefreshGridView) view.findViewById(R.id.pull_refresh_grid);
        mGridView = mPullRefreshGridView.getRefreshableView();
        mListItems = new ArrayList<>();
        // Set a listener to be invoked when the list should be refreshed.
        mPullRefreshGridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                Toast.makeText(getContext(), "Pull Down!", Toast.LENGTH_SHORT).show();
                if (pager>1){
                    pager--;
                }
                new GetDataTask().execute("http://www.3dmgame.com/sitemap/api.php?row=15&typeid="+typeid+"&paging=1&page="+pager);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                Toast.makeText(getContext(), "Pull Up!", Toast.LENGTH_SHORT).show();
                if (pager<20){
                    pager++;
                }
                new GetDataTask().execute("http://www.3dmgame.com/sitemap/api.php?row=15&typeid="+typeid+"&paging=1&page="+pager);
            }

        });


        new GetDataTask().execute("http://www.3dmgame.com/sitemap/api.php?row=15&typeid="+typeid+"&paging=1&page="+pager);
        Log.i("ppppp", "onCreateView: "+mListItems.toString());
        mAdapter = new GameContentPullToRefreshAdapter(getContext(),mListItems);
        mGridView.setAdapter(mAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url= (String) mListItems.get(position).get("arcurl");
                Intent intent=new Intent(getContext(), GameWebViewActivity.class);
                Log.i("ppppp", "onItemSelected: "+url);
                intent.putExtra("url",url);
                intent.setAction("game_webview_intent");
                startActivity(intent);
            }
        });

        return view;
    }

    private class GetDataTask extends AsyncTask<String, Void, List<HashMap<String,Object>>> {

        @Override
        protected List<HashMap<String,Object>> doInBackground(String... params) {
            // Simulates a background job.
            byte[] b = HttpUtils.request(params[0]);
            if (b != null) {
                try {
                    String json = new String(b, "utf-8");
                    Log.i("pppp", "doInBackground: =========");
                    return JSONUtils.getGameContentJsonList(json);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<HashMap<String,Object>> result) {
            super.onPostExecute(result);
            if (result!=null){
                mListItems.clear();
                mListItems.addAll(result);
                Log.i("ppppp", "onCreateView: "+mListItems.toString());
                mAdapter.notifyDataSetChanged();
            }

            // Call onRefreshComplete when the list has been refreshed.
            mPullRefreshGridView.onRefreshComplete();

        }
    }
}
