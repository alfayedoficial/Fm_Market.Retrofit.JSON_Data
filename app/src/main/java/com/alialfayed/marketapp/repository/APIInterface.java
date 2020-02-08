package com.alialfayed.marketapp.repository;

import com.alialfayed.marketapp.model.CategoryItems;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 2/8/2020 - 1:13 AM
 */
public interface APIInterface {
    @GET("task/categories")
    public Call<ArrayList<CategoryItems>> getUsers();

}
