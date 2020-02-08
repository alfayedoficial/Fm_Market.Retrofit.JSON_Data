package com.alialfayed.marketapp.view.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alialfayed.marketapp.R;
import com.alialfayed.marketapp.view.activities.MainActivity;
import com.alialfayed.marketapp.view.activities.SlidesActivity;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 2/6/2020 - 2:32 AM
 */
public class ViewPagerSlidesAdapter extends PagerAdapter {
    private SlidesActivity slidesActivity;
    private Button btn_get_started;

    public ViewPagerSlidesAdapter(SlidesActivity sActivity) {
        this.slidesActivity = sActivity;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) slidesActivity.getApplicationContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View itemView = Objects.requireNonNull(inflater).inflate(R.layout.item_viewpager_slides, container, false);
        TextView textView = itemView.findViewById(R.id.number);
        ImageView imageView = itemView.findViewById(R.id.imageView7);
        ImageView imageView1 = itemView.findViewById(R.id.imageView1);
        ImageView imageView2 = itemView.findViewById(R.id.imageView2);
        ImageView imageView3 = itemView.findViewById(R.id.imageView3);
        btn_get_started = itemView.findViewById(R.id.btn_get_started);

        switch (position) {
            case 0:
                textView.setText(R.string.slide_1_desc);
                imageView.setImageResource(R.drawable.pic_1);
                imageView1.setImageResource(R.drawable.selected_item_dot);
                imageView2.setImageResource(R.drawable.non_selected_item_dot);
                imageView3.setImageResource(R.drawable.non_selected_item_dot);
                hide_animation();
                break;
            case 1:
                textView.setText(R.string.slide_3_desc);
                imageView.setImageResource(R.drawable.pic_2);
                imageView1.setImageResource(R.drawable.non_selected_item_dot);
                imageView2.setImageResource(R.drawable.selected_item_dot);
                imageView3.setImageResource(R.drawable.non_selected_item_dot);
                hide_animation();
                break;
            case 2:
                textView.setText(R.string.slide_2_desc);
                imageView.setImageResource(R.drawable.pic_3);
                imageView1.setImageResource(R.drawable.non_selected_item_dot);
                imageView2.setImageResource(R.drawable.non_selected_item_dot);
                imageView3.setImageResource(R.drawable.selected_item_dot);
                show_animation();
                btn_get_started.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(slidesActivity, MainActivity.class);
                        slidesActivity.startActivity(intent);
                        slidesActivity.finish();
                    }
                });
                break;
        }
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }

    // Button bottomUp animation
    private void show_animation() {
        Animation show = AnimationUtils.loadAnimation(slidesActivity, R.anim.slide_up_anim);
        btn_get_started.startAnimation(show);
        show.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                btn_get_started.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                btn_get_started.clearAnimation();
            }
        });
    }

    // Button Topdown animation
    private void hide_animation() {
        Animation hide = AnimationUtils.loadAnimation(slidesActivity, R.anim.slide_down_anim);
        btn_get_started.startAnimation(hide);
        hide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                btn_get_started.clearAnimation();
                btn_get_started.setVisibility(View.GONE);

            }

        });
    }


}
