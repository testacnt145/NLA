package com.nearbylocation;

import com.nearbylocation.contract.GooglePlacesActivityContract;
import com.nearbylocation.contract.MainActivityContract;
import com.nearbylocation.presenter.GooglePlacesActivityPresenter;
import com.nearbylocation.presenter.MainActivityPresenter;
import com.nearbylocation.repository.BooksRepository;
import com.nearbylocation.repository.Repository;
import com.nearbylocation.repository.callbacks.GeneralCallback2;
import com.nearbylocation.repository.model.NearbyPlaces;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import io.reactivex.Single;
import io.reactivex.plugins.RxJavaPlugins;

import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GooglePlacesActivityPresenterTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Repository repository;

    @Mock
    GooglePlacesActivityContract.View view;

    @Mock
    GeneralCallback2<String> callback;

    private GooglePlacesActivityPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new GooglePlacesActivityPresenter(view, repository);
    }

    @After
    public void cleanUp() {
        //do nothing
    }

    @Test
    public void shouldHandleLocationFound() {
        //when(repository.getLocationFromGooglePlaces(callback));
        doNothing().when(repository).getLocationFromGooglePlaces(callback);
        presenter.loadLocation();
        verify(view).displayLocation("");
    }

    @Test
    public void shouldHandleNoLocationFound() {
//        when(repository.getLocationFromGooglePlaces(callback));
//        presenter.loadLocation();
//        verify(view).displayInternetError();
    }

}