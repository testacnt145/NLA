package com.nearbylocation.repository;

import com.nearbylocation.constants.Network;
import com.nearbylocation.repository.callbacks.GeneralCallback2;
import com.nearbylocation.retrofit.API;
import com.nearbylocation.retrofit.converter.StringConverterFactory;
import com.nearbylocation.util.LogUtil;
import com.nearbylocation.dagger.DaggerNetworkComponent;
import com.nearbylocation.dagger.NetworkComponent;
import com.nearbylocation.dagger.NetworkModule;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import javax.inject.Inject;

public class NetworkRepository implements Repository {

    @Inject
    Retrofit retrofit;
    @Inject
    API api;

    private Call<String> callGooglePlaces;

    public NetworkRepository() {

    }

    @Override
    public void getLocationFromGooglePlaces(GeneralCallback2<String> callback) {
        generateComponent(Network.baseUrl4Square, StringConverterFactory.create());
        callGooglePlaces = api.googlePlacesLocation(Network.URL);
        callGooglePlaces.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
               callback.onResponse(call, response);
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
               callback.onFailure(call, t);
            }
        });
    }

    @Override
    public void clear() {
        LogUtil.e(getClass().getSimpleName(), "clear");
        callGooglePlaces.cancel();
    }

    void generateComponent(String baseUrl, Converter.Factory converterFactory) {
        NetworkComponent networkComponent = DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(baseUrl, converterFactory))
                .build();
        networkComponent.inject(this);
    }
}
