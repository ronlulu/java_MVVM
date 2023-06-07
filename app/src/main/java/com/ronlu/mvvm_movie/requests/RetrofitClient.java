package com.ronlu.mvvm_movie.requests;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static MovieService service;
    private static final String BASE_URL = "https://imdb-top-100-movies1.p.rapidapi.com/";

    public static MovieService getService(){
        if(service == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = retrofit.create(MovieService.class);
        }
        return service;
    }
}
