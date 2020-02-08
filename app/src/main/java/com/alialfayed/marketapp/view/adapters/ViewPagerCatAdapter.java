package com.alialfayed.marketapp.view.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alialfayed.marketapp.R;
import com.alialfayed.marketapp.model.CategoryItems;
import com.alialfayed.marketapp.model.ViewPagerItems;
import com.alialfayed.marketapp.view.activities.MainActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 2/7/2020 - 4:50 PM
 */
public class ViewPagerCatAdapter extends PagerAdapter {
    private ArrayList<ViewPagerItems> viewpagerItems = new ArrayList<>();
//    private ArrayList<CategoryItems> categoryItems = new ArrayList<>();
    private MainActivity mainActivity;
    public ViewPagerCatAdapter(MainActivity mActivity , ArrayList<ViewPagerItems> items)
    {
        this.mainActivity = mActivity;
        this.viewpagerItems = items;
    }

    @Override
    public int getCount() { return viewpagerItems.size(); }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mainActivity.getApplicationContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View viewitem = Objects.requireNonNull(inflater).inflate(R.layout.viewpagercat_item, container, false);
        ViewPagerItems itemsModel = viewpagerItems.get(position);
        ImageView imgview_item = (ImageView) viewitem.findViewById(R.id.imgview_item);
        imgview_item.setImageResource(itemsModel.getImgItem());
        TextView txtTitle = viewitem.findViewById(R.id.txtTile_item);
        txtTitle.setText(itemsModel.getTitleItem());
//        //TODO get Image by retrofit
//        CategoryItems itemsModel =categoryItems.get(position);
//        txtTitle.setText(categoryItems.get(position).getName());
//        Glide.with(mainActivity).load(categoryItems.get(position).getCategory_img()).into(imgview_item);

        container.addView(viewitem);
        return viewitem;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
