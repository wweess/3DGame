package com.kob.a3dgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kob.a3dgame.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private List<View> views;
    private LayoutInflater inflater;
    private ViewPagerAdapter viewPagerAdapter;
    private int currentIndex;//
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_activity);
        initView();
        initDot();
        viewPager.addOnPageChangeListener(this);
    }

    private void initDot() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.guide_dot_ll);
        dots = new ImageView[views.size()];
        for (int i = 0; i < views.size(); i++) {
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(false);
        }
        //初始化点的颜色
        currentIndex = 0;
        dots[currentIndex].setEnabled(true);

    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.guide_viewpager);
        views = new ArrayList<View>();
        inflater = LayoutInflater.from(GuideActivity.this);
        View view1 = inflater.inflate(R.layout.viewpager01, null);
        View view2 = inflater.inflate(R.layout.viewpager02, null);
        View view3 = inflater.inflate(R.layout.viewpager03, null);

        views.add(view1);
        views.add(view2);
        views.add(view3);

        viewPagerAdapter = new ViewPagerAdapter(views);
        viewPager.setAdapter(viewPagerAdapter);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position < 0 || position >= views.size()) {
            return;
        }
        dots[position].setEnabled(true);
        dots[currentIndex].setEnabled(false);
        currentIndex = position;
        //添加最后一个引导界面的Button监听
        if (position == (views.size() - 1)) {
            Button btn = (Button) views.get(position).findViewById(R.id.guide_viewpager_ll_btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //记录登录过的信息
                    setGuide();
                    //跳转到主页面
                    Intent mainIntent = new Intent(GuideActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            });
        }
    }

    private void setGuide() {
        SharedPreferences sharedPreferences = getSharedPreferences("isFistLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("isLogin", true);
        edit.commit();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
