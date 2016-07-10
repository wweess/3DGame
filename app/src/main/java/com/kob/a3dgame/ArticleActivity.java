package com.kob.a3dgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class ArticleActivity extends AppCompatActivity {
private  WebView webView;
    private Button btn_sx,btn_xq;
    private ImageButton pager,next;
    private EditText et_ye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_activity);

        webView=(WebView)findViewById(R.id.article_activity_webview);
        btn_sx=(Button) findViewById(R.id.article_acivity_sx);
        btn_xq=(Button) findViewById(R.id.article_acivity_xq);
        pager=(ImageButton)findViewById(R.id.article_acivity_syy);
        next=(ImageButton)findViewById(R.id.article_acivity_xyy);
        et_ye=(EditText)findViewById(R.id.article_acivity_et);
        webView.getSettings().setBuiltInZoomControls(true);
        Intent intent=getIntent();
      String url= intent.getStringExtra("url");
        //加载网页
        webView.loadUrl(url);
        Log.i("pppp",url);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
