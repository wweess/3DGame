package com.kob.a3dgame.customview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/7/7.
 */
public class MainArticleFragmentViewPager extends ViewPager {
    public MainArticleFragmentViewPager(Context context) {
        super(context);
    }

    public MainArticleFragmentViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }
}
