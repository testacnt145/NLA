package com.nearbylocation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.nearbylocation.App;
import com.nearbylocation.R;
import com.nearbylocation.adapters.GooglePlacesAdapter;
import com.nearbylocation.contract.GooglePlacesActivityContract;
import com.nearbylocation.presenter.GooglePlacesActivityPresenter;
import com.nearbylocation.repository.Repository;
import com.nearbylocation.repository.model.foursquare.Venue;
import com.nearbylocation.util.NetworkUtil;
import java.util.List;
import javax.inject.Inject;

public class GooglePlacesActivity extends AppCompatActivity implements GooglePlacesActivityContract.View {

    @Inject
    Repository repository;
    GooglePlacesActivityPresenter presenter;

    private RecyclerView recyclerView;
    List<Venue> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_places);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_google_places);
        setSupportActionBar(toolbar);

        ((App) getApplication()).getAppComponent().inject(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_google_places);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        GooglePlacesActivityContract.View googlePlacesActivityView = this;
        presenter = new GooglePlacesActivityPresenter(googlePlacesActivityView, repository);
        presenter.loadLocation();
    }


    @Override
    public void displayLocation(List<Venue> venues) {
        findViewById(R.id.progress_bar_google_places).setVisibility(View.GONE);
        items = venues;
        RecyclerView.Adapter mAdapter = new GooglePlacesAdapter(items);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void displayInternetError() {
        NetworkUtil.internetNotAvailableToast();
    }

    //______________________________________________________________________________________________ LIFECYCLE
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
    }
}
