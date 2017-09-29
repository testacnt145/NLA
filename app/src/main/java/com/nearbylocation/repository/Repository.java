package com.nearbylocation.repository;

import com.nearbylocation.repository.callbacks.GeneralCallback2;
import com.nearbylocation.repository.model.NearbyPlaces;

public interface Repository {
    void getLocationFromGooglePlaces(GeneralCallback2<String> callback);
    void clear();
}
