package com.kob.a3dgame.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.kob.a3dgame.R;
import com.kob.a3dgame.adapter.MainFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/7.
 */
public class ArticleFragment extends Fragment implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{
    private HorizontalScrollView main_top_hsv;
    private RadioGroup main_top_rg;
    private RadioButton main_top_rg_rb1, main_top_rg_rb2, main_top_rg_rb3, main_top_rg_rb4, main_top_rg_rb5, main_top_rg_rb6, main_top_rg_rb7, main_top_rg_rb8, main_top_rg_rb9, main_top_rg_rb10;
    private ViewPager main_center_viewpager;
    private MainFragmentPagerAdapter mainFragmentPagerAdapter;
    List<Fragment> fragments;
    private FragmentManager fragmentManager;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.article,null);
        initView();
        initListener();
        initData();


        return view;
    }
    private void initData() {
        fragments=new ArrayList<>();
        fragmentManager=getFragmentManager();
        MainViewPagerFragment fragment1=new MainViewPagerFragment();
        fragment1.msage("http://www.3dmgame.com/sitemap/api.php?row=20&typeid=1&paging=1&page=1");
        fragments.add(fragment1);
        RedNewsViewPagerFragment fragment2=new RedNewsViewPagerFragment();
        fragment2.msage("http://www.3dmgame.com/sitemap/api.php?row=20&typeid=2&paging=1&page=1");
        fragments.add(fragment2);
        GameTopicsViewPagerFragment gameTopics=new GameTopicsViewPagerFragment();
        gameTopics.msage("http://www.3dmgame.com/sitemap/api.php?row=20&typeid=151&paging=1&page=1");
        fragments.add(gameTopics);
        HardwareinfoViewPagerFragment fragment4=new HardwareinfoViewPagerFragment();
        fragment4.msage("http://www.3dmgame.com/sitemap/api.php?row=20&typeid=152&paging=1&page=1");
        fragments.add(fragment4);
        CaptainBloodPreviewViewPagerFragment fragment5=new CaptainBloodPreviewViewPagerFragment();
        fragment5.msage("http://www.3dmgame.com/sitemap/api.php?row=20&typeid=153&paging=1&page=1");
        fragments.add(fragment5);
        GameEvaluatingViewPagerFragment fragment6=new GameEvaluatingViewPagerFragment();
        fragment6.msage("http://www.3dmgame.com/sitemap/api.php?row=20&typeid=154&paging=1&page=1");
        fragments.add(fragment6);
        HomeViewPagerFragment fragment7=new HomeViewPagerFragment();
        fragment7.msage("http://www.3dmgame.com/sitemap/api.php?row=20&typeid=196&paging=1&page=1");
        fragments.add(fragment7);
        GameListViewPagerFragment fragment8=new GameListViewPagerFragment();
        fragment8.msage("http://www.3dmgame.com/sitemap/api.php?row=20&typeid=197&paging=1&page=1");
        fragments.add(fragment8);
        NewsFocusViewPagerFragment fragment9=new NewsFocusViewPagerFragment();
        fragment9.msage("http://www.3dmgame.com/sitemap/api.php?row=20&typeid=199&paging=1&page=1");
        fragments.add(fragment9);
        StrategyViewPagerFragment fragment10=new StrategyViewPagerFragment();
        fragment10.msage("http://www.3dmgame.com/sitemap/api.php?row=20&typeid=25&paging=1&page=1");
        fragments.add(fragment10);

        mainFragmentPagerAdapter =new MainFragmentPagerAdapter(fragmentManager,fragments);
        main_center_viewpager.setAdapter(mainFragmentPagerAdapter);
    }

    private void initListener() {
        main_top_rg.setOnCheckedChangeListener(this);
        main_center_viewpager.addOnPageChangeListener(this);
    }

    private void initView() {
        main_top_hsv=(HorizontalScrollView)view.findViewById(R.id.main_top_hsv);
        main_top_rg=(RadioGroup)view.findViewById(R.id.main_top_rg);
        main_top_rg_rb1=(RadioButton)view.findViewById(R.id.main_top_rg_rb1);
        main_top_rg_rb2=(RadioButton)view.findViewById(R.id.main_top_rg_rb2);
        main_top_rg_rb3=(RadioButton)view.findViewById(R.id.main_top_rg_rb3);
        main_top_rg_rb4=(RadioButton)view.findViewById(R.id.main_top_rg_rb4);
        main_top_rg_rb5=(RadioButton)view.findViewById(R.id.main_top_rg_rb5);
        main_top_rg_rb6=(RadioButton)view.findViewById(R.id.main_top_rg_rb6);
        main_top_rg_rb7=(RadioButton)view.findViewById(R.id.main_top_rg_rb7);
        main_top_rg_rb8=(RadioButton)view.findViewById(R.id.main_top_rg_rb8);
        main_top_rg_rb9=(RadioButton)view.findViewById(R.id.main_top_rg_rb9);
        main_top_rg_rb10=(RadioButton)view.findViewById(R.id.main_top_rg_rb10);
        main_top_rg_rb1.setChecked(true);
        main_center_viewpager=(ViewPager)view.findViewById(R.id.main_center_viewpager);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.main_top_rg_rb1:
                main_center_viewpager.setCurrentItem(0);
                Toast.makeText(getContext(), "top rb01", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rg_rb2:
                main_center_viewpager.setCurrentItem(1);
                break;
            case R.id.main_top_rg_rb3:
                main_center_viewpager.setCurrentItem(2);
                break;
            case R.id.main_top_rg_rb4:
                main_center_viewpager.setCurrentItem(3);
                break;
            case R.id.main_top_rg_rb5:
                main_center_viewpager.setCurrentItem(4);
                break;
            case R.id.main_top_rg_rb6:
                main_center_viewpager.setCurrentItem(5);
                break;
            case R.id.main_top_rg_rb7:
                main_center_viewpager.setCurrentItem(6);
                break;
            case R.id.main_top_rg_rb8:
                main_center_viewpager.setCurrentItem(7);
                break;
            case R.id.main_top_rg_rb9:
                main_center_viewpager.setCurrentItem(8);
                break;
            case R.id.main_top_rg_rb10:
                main_center_viewpager.setCurrentItem(9);
                break;
        }
    }




    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //顶部的滚动条出现移动效果
        main_top_hsv.setVisibility(View.VISIBLE);
        main_top_rg.setVisibility(View.VISIBLE);

        //获得当前ViewPager对应的RadioButton
        RadioButton radioButton = (RadioButton) main_top_rg.getChildAt(position);
        radioButton.setChecked(true);
        //让顶部的RadioButton随着ViewPager一起滚动
        int left = radioButton.getLeft();
        main_top_hsv.smoothScrollTo(left,0);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
