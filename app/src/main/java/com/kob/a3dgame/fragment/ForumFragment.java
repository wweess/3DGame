package com.kob.a3dgame.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        webView.getSettings().setBuiltInZoomControls(true);

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

        return view;

    }
}
