package com.alialfayed.marketapp.view.activities;

import android.os.Bundle;

import com.alialfayed.marketapp.R;
import com.alialfayed.marketapp.viewmodel.SlidesViewModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class SlidesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slides);
        SlidesViewModel slidesViewModel = ViewModelProviders.of(this, new SlidesViewModelFactory(this)).get(SlidesViewModel.class);
        slidesViewModel.viewPagerSlides();

    }

    class SlidesViewModelFactory implements ViewModelProvider.Factory {
        private SlidesActivity slidesActivity;

        private SlidesViewModelFactory(SlidesActivity sActivity) {
            this.slidesActivity = sActivity;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new SlidesViewModel(slidesActivity);
        }
    }


}
