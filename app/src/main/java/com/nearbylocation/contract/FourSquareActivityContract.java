package com.nearbylocation.contract;


public interface FourSquareActivityContract {

    interface Presenter {
        void loadLocation();
        void unsubscribe();
    }

    interface View {
        void displayLocation(String response);
        void displayInternetError();
    }

}