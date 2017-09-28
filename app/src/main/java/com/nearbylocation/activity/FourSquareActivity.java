package com.nearbylocation.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import com.nearbylocation.App;
import com.nearbylocation.R;
import com.nearbylocation.contract.FourSquareActivityContract;
import com.nearbylocation.databinding.ActivityFourSquareBinding;
import com.nearbylocation.presenter.FourSquareActivityPresenter;
import com.nearbylocation.repository.Repository;
import com.nearbylocation.util.NetworkUtil;
import javax.inject.Inject;

public class FourSquareActivity extends AppCompatActivity implements FourSquareActivityContract.View {

    @Inject
    Repository repository;
    FourSquareActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getAppComponent().inject(this);

        FourSquareActivityContract.View fourSquareActivityView = this;
        presenter = new FourSquareActivityPresenter(fourSquareActivityView, repository);
        ActivityFourSquareBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_four_square);
        binding.setPresenter(presenter);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_four_square);
        setSupportActionBar(toolbar);
        presenter.loadLocation();
    }


    @Override
    public void displayLocation(String response) {
        Toast.makeText(this, "Successful Response", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayInternetError() {
        NetworkUtil.internetNotAvailableToast();
    }


    //______________________________________________________________________________________________
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
    }
}
