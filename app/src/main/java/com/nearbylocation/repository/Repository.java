package com.nearbylocation.repository;

import com.nearbylocation.presenter.FourSquareActivityPresenter;

public interface Repository {

    void getLocationFromFourSquare(FourSquareActivityPresenter presenter);
    void clear();
}
