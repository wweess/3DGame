package com.kob.a3dgame;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.kob.a3dgame.netUtils.HttpUtils;

public class GameWebViewActivity extends AppCompatActivity {
private ImageView iv;
    private TextView tv_name,tv_tid,tv_terrace,tv_description,tv_writer,tv_arcurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_webview);
iv=(ImageView)findViewById(R.id.game_fragment_xq_iv);
        tv_name=(TextView)findViewById(R.id.game_fragment_xq_name);
        tv_tid=(TextView)findViewById(R.id.game_fragment_xq_tid);
        tv_terrace=(TextView)findViewById(R.id.game_fragment_xq_terrace);
        tv_description=(TextView)findViewById(R.id.game_fragment_xq_tv1);
        tv_writer=(TextView)findViewById(R.id.game_fragment_xq_tv2);
        tv_arcurl=(TextView)findViewById(R.id.game_fragment_xq_arcurl);
        Intent intent=getIntent();
        String arcurl= intent.getStringExtra("arcurl");
        String title=intent.getStringExtra("title");
        String tid=intent.getStringExtra("tid");
        String terrace=intent.getStringExtra("terrace");
        String description=intent.getStringExtra("description");
        String writer=intent.getStringExtra("writer");
        String litpic=intent.getStringExtra("litpic");

        tv_name.setText("游戏名："+title);
        tv_description.setText("描述："+description);
        tv_tid.setText("游戏类型："+tid);
        tv_writer.setText("作者："+writer);
        tv_arcurl.setText("游戏官网："+arcurl);
        tv_terrace.setText("适用机型："+terrace);
PictureAsyncTask task=new PictureAsyncTask(iv);
        task.execute(litpic);

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
            Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
            iv.setImageBitmap(bitmap);
        }
    }
}
