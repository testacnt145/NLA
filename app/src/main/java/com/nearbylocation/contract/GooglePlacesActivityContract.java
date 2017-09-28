package com.nearbylocation.contract;


public interface GooglePlacesActivityContract {

    interface Presenter {
        void loadLocation();
        void unsubscribe();
    }

    interface View {
        void displayLocation(String response);
        void displayInternetError();
    }

}