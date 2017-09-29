package com.nearbylocation.contract;


import com.nearbylocation.repository.callbacks.GeneralCallback;
import com.nearbylocation.repository.model.NearbyPlaces;

public interface FourSquareActivityContract {

    interface Presenter {
        void loadLocation(GeneralCallback<NearbyPlaces> callback);
        void unsubscribe();
    }

    interface View {
        void displayLocation(String response);
    }

}