package com.alialfayed.marketapp.repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 2/8/2020 - 1:07 AM
 */
public class APIClient {

    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            String url = "https://5bcce576cf2e850013874767.mockapi.io/";
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
