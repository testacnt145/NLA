package com.nearbylocation.dagger;

import com.nearbylocation.retrofit.API;
import retrofit2.Converter;
import retrofit2.Retrofit;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    private String baseUrl;
    private Converter.Factory converterFactory;

    public NetworkModule(String baseUrl, Converter.Factory converterFactory) {
        this.baseUrl = baseUrl;
        this.converterFactory = converterFactory;
    }

    @Provides
    @Singleton
    API provideApi(Retrofit retrofit) {
        return retrofit.create(API.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .build();
    }
}

//https://inducesmile.com/android/android-dagger-2-dependency-injection-with-retrofit-for-beginners/
//https://hackernoon.com/yet-another-mvp-article-part-3-calling-apis-using-retrofit-23757f4eee05
//https://github.com/mirhoseini/marvel

//passing paramters in constructor
//advice here
//https://stackoverflow.com/questions/37434657/cannot-be-provided-without-an-inject-constructor-or-from-an-provides-annotated
//not a good pattern here
//https://stackoverflow.com/a/37517764/8573120
