package com.example.hp.dogsapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by HP on 3/3/2018.
 */

public interface Api {
    String BASE_URL="https://newsapi.org/";

    @GET("v2/top-headlines?sources=usa-today&apiKey=d63a0f48d3564a02b866c7b7c1058e2d")
    Call<NewsList> getNewsList();
}
