package com.alialfayed.marketapp.view.activities;

import android.app.Activity;
import android.os.Bundle;

import com.alialfayed.marketapp.R;
import com.alialfayed.marketapp.viewmodel.SplashViewModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SplashViewModel splashViewModel = ViewModelProviders.of(this, new SplashViewModelFactory(SplashActivity.this)).get(SplashViewModel.class);
        splashViewModel.durationofwait();
    }

    /**
     * to get an Object from SplashViewModel
     */

    class SplashViewModelFactory implements ViewModelProvider.Factory {
        private Activity mActivity;

        private SplashViewModelFactory(Activity activity) {
            this.mActivity = activity;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new SplashViewModel(mActivity);
        }
    }

}
