package com.alialfayed.marketapp.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;

import com.alialfayed.marketapp.view.activities.MainActivity;
import com.alialfayed.marketapp.view.activities.SlidesActivity;

import androidx.lifecycle.ViewModel;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 2/6/2020 - 12:17 AM
 */
public class SplashViewModel extends ViewModel {

    private Activity splashActivity;

    public SplashViewModel (Activity spActivity){
        this.splashActivity = spActivity;
    }


    public void durationofwait(){
        // Duration of wait
        int SPLASH_DISPLAY_LENGTH = 2300;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                firstAppStart();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    /**
     * this method doing switch method viewPagerMethod when Start App First Once
     */
    private void firstAppStart(){
        SharedPreferences preferences = splashActivity.getSharedPreferences("prefs",MODE_PRIVATE);
        Boolean firstStart = preferences.getBoolean("firstStart",true);
        if (firstStart){
            Intent intentSlides = new Intent(splashActivity , SlidesActivity.class);
            splashActivity.startActivity(intentSlides);
            // SharedPreferences
            SharedPreferences preferencesSave = splashActivity.getSharedPreferences("prefs",MODE_PRIVATE);
            SharedPreferences.Editor editor = preferencesSave.edit();
            editor.putBoolean("firstStart",false);
            editor.apply();
            splashActivity.finish();
        }else {
            Intent intentMain = new Intent(splashActivity , MainActivity.class);
            splashActivity.startActivity(intentMain);
            splashActivity.finish();

        }
    }
}
