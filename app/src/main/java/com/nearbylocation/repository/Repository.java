package com.nearbylocation.repository;

import com.nearbylocation.presenter.FourSquareActivityPresenter;
import com.nearbylocation.presenter.GooglePlacesActivityPresenter;
import com.nearbylocation.repository.model.NearbyPlaces;

public interface Repository {

    void getLocationFromFourSquare(GeneralCallback<NearbyPlaces> callback);
    void getLocationFromGooglePlaces(GooglePlacesActivityPresenter presenter);
    void clear();
}
