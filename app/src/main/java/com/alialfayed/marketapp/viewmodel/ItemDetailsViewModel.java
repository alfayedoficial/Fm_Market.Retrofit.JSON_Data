package com.alialfayed.marketapp.viewmodel;

import com.alialfayed.marketapp.view.activities.ItemDetailsActivity;

import androidx.lifecycle.ViewModel;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 2/6/2020 - 5:20 AM
 */
public class ItemDetailsViewModel extends ViewModel {
    private ItemDetailsActivity itemDetailsActivity;
    public ItemDetailsViewModel(ItemDetailsActivity detailsActivity){
        this.itemDetailsActivity = detailsActivity;
    }
}
