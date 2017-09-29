package com.nearbylocation.contract;


import com.nearbylocation.repository.model.foursquare.Venue;
import java.util.List;

public interface GooglePlacesActivityContract {

    interface Presenter {
        void loadLocation();
        void unsubscribe();
    }

    interface View {
        void displayLocation(List<Venue> venues);
        void displayInternetError();
    }

}