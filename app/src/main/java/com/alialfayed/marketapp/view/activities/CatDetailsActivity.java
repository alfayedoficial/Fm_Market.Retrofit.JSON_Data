package com.alialfayed.marketapp.view.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.alialfayed.marketapp.R;
import com.alialfayed.marketapp.viewmodel.CatDetailsViewModel;

public class CatDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_details);
        CatDetailsViewModel catDetailsViewModel = ViewModelProviders.of(this,new CatDetailsViewModelFactory(this)).get(CatDetailsViewModel.class);
    }

    class CatDetailsViewModelFactory implements ViewModelProvider.Factory{
        private CatDetailsActivity catDetailsActivity;
        CatDetailsViewModelFactory(CatDetailsActivity detailsActivity){
            this.catDetailsActivity = detailsActivity;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new CatDetailsViewModel(catDetailsActivity);
        }
    }
}
