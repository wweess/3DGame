package com.kob.a3dgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Toast;

import com.kob.a3dgame.netUtils.NetUtils;
import com.kob.a3dgame.service.MainService;

import pl.droidsonroids.gif.GifImageView;

/*
欢迎界面
设置一个欢迎动画
并跳转服务后台
 */
public class WelcomeActivity extends AppCompatActivity {
    private GifImageView gifImageView;
    private Animation animation;
    private boolean netOpen;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        gifImageView = (GifImageView) findViewById(R.id.welcome_gif);
        //设置透明动画
        animation = new AlphaAnimation(0f, 1.0f);
        animation.setDuration(3000);
        gifImageView.startAnimation(animation);
        //添加动画监听
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                netOpen = NetUtils.netConnect(WelcomeActivity.this);
                if (netOpen) {
                    //开启后台服务
                    intent = new Intent(WelcomeActivity.this, MainService.class);
                    intent.putExtra("url","http://www.3dmgame.com/sitemap/api.php?row=20&typeid=1&paging=1&page=1");
                    startService(intent);
                }

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!netOpen) {
                    Toast.makeText(WelcomeActivity.this, "请连接网络", Toast.LENGTH_SHORT).show();
                }
                isFristLogin();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

    private void isFristLogin() {
        SharedPreferences sharedPrefer = getSharedPreferences("isFistLogin", Context.MODE_PRIVATE);
        boolean isLogin = sharedPrefer.getBoolean("isLogin", false);
        if (!isLogin) {
            //是第一次登录
            Intent pagerIntent = new Intent(WelcomeActivity.this,GuideActivity.class);
            startActivity(pagerIntent);

            finish();
        } else {
            //不是第一次登录，直接跳转主页面
            Intent mainIntent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }

    }
}
