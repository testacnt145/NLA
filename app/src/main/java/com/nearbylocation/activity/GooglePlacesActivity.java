package com.nearbylocation.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import com.nearbylocation.App;
import com.nearbylocation.R;
import com.nearbylocation.contract.GooglePlacesActivityContract;
import com.nearbylocation.databinding.ActivityGooglePlacesBinding;
import com.nearbylocation.presenter.GooglePlacesActivityPresenter;
import com.nearbylocation.repository.Repository;
import com.nearbylocation.util.NetworkUtil;
import javax.inject.Inject;

public class GooglePlacesActivity extends AppCompatActivity implements GooglePlacesActivityContract.View {

    @Inject
    Repository repository;
    GooglePlacesActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getAppComponent().inject(this);

        GooglePlacesActivityContract.View googlePlacesActivityView = this;
        presenter = new GooglePlacesActivityPresenter(googlePlacesActivityView, repository);
        ActivityGooglePlacesBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_google_places);
        binding.setPresenter(presenter);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_google_places);
        setSupportActionBar(toolbar);
        presenter.loadLocation();
    }


    @Override
    public void displayLocation(String response) {
        //todo
        findViewById(R.id.progress_bar_google_places).setVisibility(View.GONE);
        Toast.makeText(this, "Successful Response", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayInternetError() {
        NetworkUtil.internetNotAvailableToast();
    }


    //______________________________________________________________________________________________ LIFECYLCE
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
    }
}
