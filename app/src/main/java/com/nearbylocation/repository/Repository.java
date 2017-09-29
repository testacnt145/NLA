package com.nearbylocation.repository;

import com.nearbylocation.repository.callbacks.GeneralCallback2;
import com.nearbylocation.repository.model.NearbyPlaces;
import com.nearbylocation.repository.model.foursquare.FourSquareNearbyPlaces;

public interface Repository {
    void getLocationFromGooglePlaces(GeneralCallback2<FourSquareNearbyPlaces> callback);
    void clear();
}
