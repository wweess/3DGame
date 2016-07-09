package com.kob.a3dgame.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kob.a3dgame.R;

public class ForumFragment extends Fragment {
String url="http://bbs.3dmgame.com/forum.php";
    WebView webView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.forum_fragment,null);
        webView=(WebView)view.findViewById(R.id.forume_fragment_webview);
        //加载网页
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

            //获得网页的标题信息
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.i("aaa", title);
            }
        });

        return view;

    }
}
