package com.kob.a3dgame.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kob.a3dgame.R;
import com.kob.a3dgame.netUtils.HttpUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/7/8.
 */
public class GameContentPullToRefreshAdapter extends BaseAdapter {

    private Context context;
    private List<HashMap<String, Object>> mListItems;

    public GameContentPullToRefreshAdapter(Context context, List<HashMap<String, Object>> mListItems) {
        this.context = context;
        this.mListItems = mListItems;
    }

    @Override
    public int getCount() {
        return mListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.gamecontent_item, null);
            holder = new ViewHolder();
            holder.gameiv = (ImageView) convertView.findViewById(R.id.gamecontent_adapter_iv);
            holder.gamenametv = (TextView) convertView.findViewById(R.id.gamecontent_adapter_tv);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String path = mListItems.get(position).get("litpic").toString();
        PictureAsyncTask task=new PictureAsyncTask(holder.gameiv);
        task.execute(path);
        Log.i("pppp", "getView: =====++++++++");

         holder.gamenametv.setText(mListItems.get(position).get("shorttitle").toString());
        return convertView;
    }
    class PictureAsyncTask extends AsyncTask<String,Void,byte[]> {
        private ImageView iv;

        public PictureAsyncTask(ImageView iv) {
            this.iv = iv;
        }

        @Override
        protected byte[] doInBackground(String... params) {
            return HttpUtils.request(params[0]);
        }

        @Override
        protected void onPostExecute(byte[] bytes) {
            super.onPostExecute(bytes);
            Bitmap bitmap=BitmapFactory.decodeByteArray(bytes,0,bytes.length);
            iv.setImageBitmap(bitmap);
        }
    }
    class ViewHolder {
        ImageView gameiv;
        TextView gamenametv;

    }
}
