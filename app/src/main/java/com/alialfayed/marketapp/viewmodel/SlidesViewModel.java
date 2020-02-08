package com.alialfayed.marketapp.viewmodel;

import android.app.Activity;

import com.alialfayed.marketapp.R;
import com.alialfayed.marketapp.view.activities.SlidesActivity;
import com.alialfayed.marketapp.view.adapters.ViewPagerSlidesAdapter;

import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 2/6/2020 - 4:51 AM
 */
public class SlidesViewModel extends ViewModel {

    private SlidesActivity slidesActivity;
    private ViewPager viewPagerSlides;

    public SlidesViewModel(SlidesActivity sActivity){
        this.slidesActivity = sActivity;
    }

    public void viewPagerSlides() {
        viewPagerSlides = slidesActivity.findViewById(R.id.viewPagerSlides);
        PagerAdapter pagerAdapter = new ViewPagerSlidesAdapter(slidesActivity);
        viewPagerSlides.setAdapter(pagerAdapter);
        viewPagerSlides.setCurrentItem(0);
    }




}
