package com.nearbylocation.presenter;

import com.nearbylocation.contract.FourSquareActivityContract;
import com.nearbylocation.repository.GeneralCallback;
import com.nearbylocation.repository.Repository;
import com.nearbylocation.repository.model.NearbyPlaces;
import com.nearbylocation.util.LogUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FourSquareActivityPresenter implements FourSquareActivityContract.Presenter {

    private FourSquareActivityContract.View view;
    private Repository repository;

    public FourSquareActivityPresenter(FourSquareActivityContract.View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadLocation() {
        GeneralCallback<NearbyPlaces> a = new GeneralCallback<NearbyPlaces>() {
            @Override
            public void onResponse(Call<NearbyPlaces> call, Response<String> response) {
                view.displayLocation(response.body());
            }

            @Override
            public void onFailure(Call<NearbyPlaces> call, Throwable t) {
                if(call.isCanceled())
                    LogUtil.e(getClass().getSimpleName(), "Call canceled");
                else
                    view.displayInternetError();
            }
        };
        repository.getLocationFromFourSquare(a);
    }

    //________________
    @Override
    public void unsubscribe() {
        repository.clear();
    }
}
