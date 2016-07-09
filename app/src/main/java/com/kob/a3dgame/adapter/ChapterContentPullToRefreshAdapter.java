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

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/7/8.
 */
public class ChapterContentPullToRefreshAdapter extends BaseAdapter {

    private Context context;
    private List<HashMap<String,Object>> mListItems;

    public ChapterContentPullToRefreshAdapter(Context context, List<HashMap<String,Object>> mListItems) {
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
            convertView = View.inflate(context, R.layout.pulltorefresh, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.article_fragment_iv);
            holder.titletv = (TextView) convertView.findViewById(R.id.article_fragment_titletv);
            holder.timetv = (TextView) convertView.findViewById(R.id.article_fragment_timetv);
            holder.clicktv = (TextView) convertView.findViewById(R.id.article_fragment_clicktv);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.titletv.setText(mListItems.get(position).get("title").toString());
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        holder.timetv.setText( format.format(Integer.parseInt(mListItems.get(position).get("senddate").toString())));
        holder.clicktv.setText(mListItems.get(position).get("click").toString() + "");

        String path = mListItems.get(position).get("litpic").toString();

       PictureAsyncTask task=new PictureAsyncTask(holder.imageView);
        task.execute(path);
        Log.i("pppp", "getView: =====++++++++");
        return convertView;
    }
class PictureAsyncTask extends AsyncTask<String,Void,byte[]>{
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
        ImageView imageView;
        TextView titletv;
        TextView timetv;
        TextView clicktv;
    }
}
