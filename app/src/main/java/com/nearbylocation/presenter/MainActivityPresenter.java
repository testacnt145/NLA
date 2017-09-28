package com.nearbylocation.presenter;

import com.nearbylocation.contract.MainActivityContract;
import com.nearbylocation.repository.BooksRepository;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View view;
    private BooksRepository bookRepository;

    public MainActivityPresenter(MainActivityContract.View view, BooksRepository bookRepository) {
        this.view = view;
        this.bookRepository = bookRepository;
    }

    @Override
    public void navigateToFourSquare() {
        view.startFourSquareActivity();
    }

    @Override
    public void navigateToGooglePlaces() {
        view.startGooglePlacesActivity();
    }

    @Override
    public void unsubscribe() {
        //do nothing
    }
}
