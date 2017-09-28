package com.nearbylocation;

import com.nearbylocation.contract.MainActivityContract;
import com.nearbylocation.presenter.MainActivityPresenter;
import com.nearbylocation.repository.BooksRepository;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import io.reactivex.plugins.RxJavaPlugins;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.Rule;
import org.junit.After;

public class MainActivityPresenterTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    BooksRepository booksRepository;

    @Mock
    MainActivityContract.View view;

    private MainActivityPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new MainActivityPresenter(view, booksRepository);
    }

    @After
    public void cleanUp() {
        RxJavaPlugins.reset();
    }

    @Test
    public void shouldHandleStartFourSquare() {
        //when(booksRepository.getBooks()).thenReturn(Single.just(MANY_BOOKS));
        presenter.navigateToFourSquare();
        verify(view).startFourSquareActivity();
    }

    @Test
    public void shouldHandleStartGooglePlaces() {
        //when(booksRepository.getBooks()).thenReturn(Single.<List<Book>>just(EMPTY_LIST));
        presenter.navigateToGooglePlaces();
        verify(view).startGooglePlacesActivity();
    }

}