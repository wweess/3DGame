package com.kob.a3dgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class GameWebViewActivity extends AppCompatActivity {
    private WebView webView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_webview);
        webView = (WebView) findViewById(R.id.game_webview_wv);
        progressBar = (ProgressBar) findViewById(R.id.game_webview_frame_pb);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        //使用WebView加载网页
        webView.loadUrl(url);
        //让我们的WebView隐藏起来
        webView.setVisibility(View.INVISIBLE);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //掌控网页的加载进度
        webView.setWebChromeClient(new WebChromeClient() {

            //可以获得网页进度信息
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                Log.i("aaa", "newProgress=" + newProgress);
                setTitle("loading.....");
                progressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    setTitle("done.....");
                    webView.setVisibility(View.VISIBLE);
                }


            }

            //获得网页的标题信息
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.i("aaa", title);
            }
        });


    }
}
