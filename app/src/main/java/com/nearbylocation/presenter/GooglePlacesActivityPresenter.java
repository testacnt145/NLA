package com.nearbylocation.presenter;

import com.nearbylocation.contract.GooglePlacesActivityContract;
import com.nearbylocation.repository.Repository;
import com.nearbylocation.repository.callbacks.GeneralCallback2;
import com.nearbylocation.util.LogUtil;
import retrofit2.Call;
import retrofit2.Response;

public class GooglePlacesActivityPresenter implements GooglePlacesActivityContract.Presenter {

    private GooglePlacesActivityContract.View view;
    private Repository repository;

    public GooglePlacesActivityPresenter(GooglePlacesActivityContract.View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadLocation() {
        repository.getLocationFromGooglePlaces(new GeneralCallback2<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful())
                    view.displayLocation(response.toString());
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                if(call.isCanceled())
                    LogUtil.e(getClass().getSimpleName(), "Call canceled");
                else
                    view.displayInternetError();
            }
        });
    }

    @Override
    public void unsubscribe() {
        repository.clear();
    }
}
