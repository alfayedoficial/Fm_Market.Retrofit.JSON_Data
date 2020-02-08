package com.alialfayed.marketapp.viewmodel;

import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alialfayed.marketapp.R;
import com.alialfayed.marketapp.model.ViewPagerItems;
import com.alialfayed.marketapp.view.activities.MainActivity;
import com.alialfayed.marketapp.view.adapters.ViewPagerCatAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 2/6/2020 - 5:13 AM
 */
public class MainViewModel extends ViewModel {
    private MainActivity mainActivity;
    private ViewPager viewPagerCategory;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    private ViewPagerCatAdapter mAdapter;
    private ArrayList<ViewPagerItems> viewPagerItems = new ArrayList<>();


    public MainViewModel(MainActivity mActivity) {
        this.mainActivity = mActivity;
    }

    public void viewPagerCategory() {
        initCompoments();
        Log.i("TAG" , "ViewModel");
        loadData();
        mAdapter = new ViewPagerCatAdapter(mainActivity, viewPagerItems);
        viewPagerCategory.setAdapter(mAdapter);
        viewPagerCategory.setCurrentItem(0);
        viewPagerCategory.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // Change the current position intimation
                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(mainActivity, R.drawable.non_selected_item_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(mainActivity, R.drawable.selected_item_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setUiPageViewController();
    }

    private void initCompoments() {
        viewPagerCategory = mainActivity.findViewById(R.id.pager_introduction);
        pager_indicator = mainActivity.findViewById(R.id.viewPagerCountDots);
    }

    // setup the
    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(mainActivity);
            dots[i].setImageDrawable(ContextCompat.getDrawable(mainActivity, R.drawable.non_selected_item_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(6, 0, 6, 0);

            pager_indicator.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(mainActivity, R.drawable.selected_item_dot));
    }

    private void loadData() {
        Log.i("TAG" , "LoadDate");
        int[] header = {R.string.ob_header1, R.string.ob_header2, R.string.ob_header3};
        int[] imageId = {R.drawable.onboard_page1, R.drawable.onboard_page2, R.drawable.onboard_page3};
        Log.i("TAG" , "Store");
        for (int i = 0; i < imageId.length; i++) {
            ViewPagerItems item = new ViewPagerItems();
            item.setImgItem(imageId[i]);
            item.setTitleItem(mainActivity.getResources().getString(header[i]));
            viewPagerItems.add(item);
            Log.i("TAG" , "done");
        }
    }


}
