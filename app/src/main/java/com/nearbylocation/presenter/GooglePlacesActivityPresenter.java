package com.nearbylocation.presenter;

import com.nearbylocation.contract.GooglePlacesActivityContract;
import com.nearbylocation.repository.Repository;

public class GooglePlacesActivityPresenter implements GooglePlacesActivityContract.Presenter {

    private GooglePlacesActivityContract.View view;
    private Repository repository;

    public GooglePlacesActivityPresenter(GooglePlacesActivityContract.View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadLocation() {
        repository.getLocationFromGooglePlaces(this);
    }

    //________________
    @Override
    public void unsubscribe() {
        repository.clear();
    }
}
