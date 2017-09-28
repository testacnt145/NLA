package com.nearbylocation.dagger;

import com.nearbylocation.retrofit.API;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import retrofit2.Converter;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public API provideApi(Retrofit retrofit) {
        return retrofit.create(API.class);
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(HttpUrl baseUrl, Converter.Factory converterFactory) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .build();
    }
}
