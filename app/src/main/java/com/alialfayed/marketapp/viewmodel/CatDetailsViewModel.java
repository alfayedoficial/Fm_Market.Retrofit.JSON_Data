package com.alialfayed.marketapp.viewmodel;

import com.alialfayed.marketapp.view.activities.CatDetailsActivity;

import androidx.lifecycle.ViewModel;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 2/6/2020 - 5:19 AM
 */
public class CatDetailsViewModel extends ViewModel {
    private CatDetailsActivity catDetailsActivity;
    public CatDetailsViewModel(CatDetailsActivity detailsActivity){
        this.catDetailsActivity = detailsActivity;
    }
}
