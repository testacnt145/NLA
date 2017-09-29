package com.nearbylocation.retrofit;

import com.nearbylocation.repository.model.NearbyPlaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface API {

    //Useful Documentation
    //https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit
    //https://futurestud.io/tutorials/retrofit-2-cancel-requests
    //old 2.0 tutorial http://www.vogella.com/tutorials/Retrofit/article.html


    //Retrofit with MVP example using Dagger
    //https://hackernoon.com/yet-another-mvp-article-part-3-calling-apis-using-retrofit-23757f4eee05

    @GET
    Call<NearbyPlaces> fourSquareLocation(@Url String url);

    @GET
    Call<String> googlePlacesLocation(@Url String url);

}
