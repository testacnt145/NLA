package com.nearbylocation.presenter;

import com.nearbylocation.contract.FourSquareActivityContract;
import com.nearbylocation.repository.Repository;
import com.nearbylocation.util.LogUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FourSquareActivityPresenter implements FourSquareActivityContract.Presenter, Callback<String> {

    private FourSquareActivityContract.View view;
    private Repository repository;

    public FourSquareActivityPresenter(FourSquareActivityContract.View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadLocation() {
        repository.getLocationFromFourSquare(this);
    }

    //_______________
    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        view.displayLocation(response.body());
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if(call.isCanceled())
            LogUtil.e(getClass().getSimpleName(), "Call canceled");
        else
            view.displayInternetError();

    }

    //________________
    @Override
    public void unsubscribe() {
        repository.clear();
    }
}
