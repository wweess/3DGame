package com.kob.a3dgame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.kob.a3dgame.fragment.ArticleFragment;
import com.kob.a3dgame.fragment.ForumFragment;
import com.kob.a3dgame.fragment.GameFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private FrameLayout frameLayout;
    private RadioGroup main_booton_rg;
    private RadioButton main_booton_rg_rb1, main_booton_rg_rb2, main_booton_rg_rb3;
    private List<Fragment> fragments;
    private FragmentManager fragmentManager;
    FragmentTransaction transaction;
    int indext = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initData();

    }

    private void initData() {
        fragments = new ArrayList<>();
        fragmentManager = getSupportFragmentManager();

        ArticleFragment article = new ArticleFragment();
        GameFragment game = new GameFragment();
        ForumFragment forum = new ForumFragment();
        fragments.add(article);
        fragments.add(forum);
        fragments.add(game);
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.main_framelayout_top_fl, fragments.get(indext));
        transaction.commit();

    }

    private void initListener() {
        main_booton_rg.setOnCheckedChangeListener(this);
    }

    private void initView() {
        frameLayout = (FrameLayout) findViewById(R.id.main_framelayout_top_fl);
        main_booton_rg = (RadioGroup) findViewById(R.id.main_booton_rg);
        main_booton_rg_rb1 = (RadioButton) findViewById(R.id.main_booton_rg_rb1);
        main_booton_rg_rb2 = (RadioButton) findViewById(R.id.main_booton_rg_rb2);
        main_booton_rg_rb3 = (RadioButton) findViewById(R.id.main_booton_rg_rb3);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_booton_rg_rb1:
                indext = 0;
                transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.main_framelayout_top_fl, fragments.get(indext));
                transaction.commit();

                break;
            case R.id.main_booton_rg_rb2:
                indext = 1;
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_framelayout_top_fl, fragments.get(indext));
                transaction.commit();
                break;
            case R.id.main_booton_rg_rb3:
                indext = 2;
                transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.main_framelayout_top_fl, fragments.get(indext));
                transaction.commit();
                break;
        }

    }
}
