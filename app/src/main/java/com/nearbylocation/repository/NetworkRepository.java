package com.nearbylocation.repository;

import com.nearbylocation.constants.Network;
import com.nearbylocation.repository.callbacks.GeneralCallback2;
import com.nearbylocation.repository.model.foursquare.FourSquareNearbyPlaces;
import com.nearbylocation.retrofit.API;
import com.nearbylocation.util.LogUtil;
import com.nearbylocation.dagger.DaggerNetworkComponent;
import com.nearbylocation.dagger.NetworkComponent;
import com.nearbylocation.dagger.NetworkModule;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import javax.inject.Inject;
import android.support.annotation.NonNull;

public class NetworkRepository implements Repository {

    @Inject
    Retrofit retrofit;
    @Inject
    API api;
    @Inject
    Call<FourSquareNearbyPlaces> callGooglePlaces;


    @Override
    public void getLocationFromGooglePlaces(GeneralCallback2<FourSquareNearbyPlaces> callback) {
        generateComponent(Network.baseUrl4Square, MoshiConverterFactory.create());
        callGooglePlaces.enqueue(new Callback<FourSquareNearbyPlaces>() {
            @Override
            public void onResponse(@NonNull Call<FourSquareNearbyPlaces> call, @NonNull Response<FourSquareNearbyPlaces> response) {
               callback.onResponse(call, response);
            }
            @Override
            public void onFailure(@NonNull Call<FourSquareNearbyPlaces> call, Throwable t) {
               callback.onFailure(call, t);
            }
        });
    }

    @Override
    public void clear() {
        LogUtil.e(getClass().getSimpleName(), "clear");
        callGooglePlaces.cancel();
    }

    private void generateComponent(String baseUrl, Converter.Factory converterFactory) {
        NetworkComponent networkComponent = DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(baseUrl, converterFactory))
                .build();
        networkComponent.inject(this);
    }
}
