package com.nearbylocation.repository;

import com.nearbylocation.constants.Location;
import com.nearbylocation.constants.Network;
import com.nearbylocation.presenter.FourSquareActivityPresenter;
import com.nearbylocation.retrofit.API;
import com.nearbylocation.retrofit.converter.StringConverterFactory;
import com.nearbylocation.util.LogUtil;
import retrofit2.Call;
import retrofit2.Retrofit;
import javax.inject.Inject;

public class NetworkRepository implements Repository {

//    @Inject
//    Retrofit retrofit;
//    @Inject
//    API api;
//
    Call<String> call;

//    NetworkRepository() {
//        ((App) getApplication()).getAppComponent().inject(this);
//    }


    @Override
    public void getLocationFromFourSquare(FourSquareActivityPresenter presenter) {
        String baseUrl = Network.baseUrl4Square;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(StringConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);
        String url = Network.serverUrl4Square(Location.LATITUDE, Location.LONGITUDE);
        call = api.fourSquareLocation(url);
        call.enqueue(presenter); //make an asynchronous request

        /*String url = Network.serverUrl4Square(Location.LATITUDE, Location.LONGITUDE);
        call = api.fourSquareLocation(url);
        call.enqueue(presenter);*/
    }

    @Override
    public void clear() {
        LogUtil.e(getClass().getSimpleName(), "clear");
        call.cancel();
    }
}
