package com.alialfayed.marketapp.view.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.alialfayed.marketapp.R;
import com.alialfayed.marketapp.viewmodel.ItemDetailsViewModel;

public class ItemDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        ItemDetailsViewModel itemDetailsViewModel = ViewModelProviders.of(this , new ItemDetailsViewModelFactory(this)).get(ItemDetailsViewModel.class);
    }

    class ItemDetailsViewModelFactory implements ViewModelProvider.Factory{
        private ItemDetailsActivity itemDetailsActivity;
        ItemDetailsViewModelFactory(ItemDetailsActivity detailsActivity){
            this.itemDetailsActivity = detailsActivity;
        }
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ItemDetailsViewModel(itemDetailsActivity);
        }
    }
}
