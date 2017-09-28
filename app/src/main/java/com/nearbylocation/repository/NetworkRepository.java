package com.nearbylocation.repository;

import com.nearbylocation.constants.Location;
import com.nearbylocation.constants.Network;
import com.nearbylocation.presenter.FourSquareActivityPresenter;
import com.nearbylocation.presenter.GooglePlacesActivityPresenter;
import com.nearbylocation.repository.model.NearbyPlaces;
import com.nearbylocation.retrofit.API;
import com.nearbylocation.retrofit.converter.StringConverterFactory;
import com.nearbylocation.util.LogUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import javax.inject.Inject;

public class NetworkRepository implements Repository {

//    @Inject
//    Retrofit retrofit;
//    @Inject
//    API api;
//
    private Call<NearbyPlaces> call;

//    NetworkRepository() {
//        ((App) getApplication()).getAppComponent().inject(this);
//    }


    @Override
    public void getLocationFromFourSquare(GeneralCallback<NearbyPlaces> obj) {
        String baseUrl = Network.baseUrl4Square;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(StringConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);
        String url = Network.serverUrl4Square(Location.LATITUDE, Location.LONGITUDE);
        call = api.fourSquareLocation(url);
        call.enqueue(new Callback<NearbyPlaces>() {
            @Override
            public void onResponse(Call<NearbyPlaces> call, Response<NearbyPlaces> response) {

            }

            @Override
            public void onFailure(Call<NearbyPlaces> call, Throwable t) {

            }
        }); //make an asynchronous request

        /*String url = Network.serverUrl4Square(Location.LATITUDE, Location.LONGITUDE);
        call = api.fourSquareLocation(url);
        call.enqueue(presenter);*/
    }

    @Override
    public void getLocationFromGooglePlaces(GooglePlacesActivityPresenter presenter) {
//        String baseUrl = Network.baseUrl4Square;
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(StringConverterFactory.create())
//                .build();
//        API api = retrofit.create(API.class);
//        String url = Network.serverUrl4Square(Location.LATITUDE, Location.LONGITUDE);
//        call = api.fourSquareLocation(url);
//        call.enqueue(presenter); //make an asynchronous request
    }

    @Override
    public void clear() {
        LogUtil.e(getClass().getSimpleName(), "clear");
        call.cancel();
    }
}
