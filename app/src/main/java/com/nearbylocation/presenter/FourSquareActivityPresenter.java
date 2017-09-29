package com.nearbylocation.presenter;

import com.nearbylocation.constants.Network;
import com.nearbylocation.contract.FourSquareActivityContract;
import com.nearbylocation.repository.callbacks.GeneralCallback;
import com.nearbylocation.repository.Repository;
import com.nearbylocation.repository.model.NearbyPlaces;
import com.nearbylocation.retrofit.API;
import com.nearbylocation.retrofit.converter.StringConverterFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FourSquareActivityPresenter implements FourSquareActivityContract.Presenter {

    //private FourSquareActivityContract.View view;
    private API api;

    public FourSquareActivityPresenter(FourSquareActivityContract.View view, Repository repository) {
        //this.view = view;

        //retrofit
        String baseUrl = Network.baseUrl4Square;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(StringConverterFactory.create())
                .build();
        api = retrofit.create(API.class);
    }

    @Override
    public void loadLocation(GeneralCallback<NearbyPlaces> callback) {
        Call<NearbyPlaces> call = api.fourSquareLocation(Network.URL);
        call.enqueue(new Callback<NearbyPlaces>() {
            @Override
            public void onResponse(Call<NearbyPlaces> call, Response<NearbyPlaces> response) {
                if (response.isSuccessful())
                    callback.onSuccess(response.body());
            }
            @Override
            public void onFailure(Call<NearbyPlaces> call, Throwable t) {
                if(call.isCanceled())
                    callback.onError("Call canceled");
                else
                    callback.onError(t.getMessage());
            }
        });
    }

    //________________
    @Override
    public void unsubscribe() {

    }
}
