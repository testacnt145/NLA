package com.nearbylocation.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import com.nearbylocation.App;
import com.nearbylocation.R;
import com.nearbylocation.adapters.MyAdapter;
import com.nearbylocation.contract.FourSquareActivityContract;
import com.nearbylocation.databinding.ActivityFourSquareBinding;
import com.nearbylocation.presenter.FourSquareActivityPresenter;
import com.nearbylocation.repository.Repository;
import com.nearbylocation.repository.model.NearbyPlaces;
import com.nearbylocation.util.NetworkUtil;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class FourSquareActivity extends AppCompatActivity implements FourSquareActivityContract.View {

    @Inject
    Repository repository;
    FourSquareActivityPresenter presenter;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<NearbyPlaces> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_square);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_four_square);
        setSupportActionBar(toolbar);

        ((App) getApplication()).getAppComponent().inject(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_four_square);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        NearbyPlaces n1 = new NearbyPlaces();
        n1.setCategory("C1");
        n1.setName("N1");
        NearbyPlaces n2 = new NearbyPlaces();
        n2.setCategory("C2");
        n2.setName("N2");
        items = Arrays.asList(n1, n2);

        // define an adapter
        mAdapter = new MyAdapter(items);
        recyclerView.setAdapter(mAdapter);

        FourSquareActivityContract.View fourSquareActivityView = this;
        presenter = new FourSquareActivityPresenter(fourSquareActivityView, repository);
        //ActivityFourSquareBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_four_square);
        //binding.setPresenter(presenter);
        presenter.loadLocation();
    }


    @Override
    public void displayLocation(String response) {
        //todo
        findViewById(R.id.progress_bar_four_square).setVisibility(View.GONE);

        NearbyPlaces n3 = new NearbyPlaces();
        n3.setCategory("C3");
        n3.setName("N3");
        items.add(n3);
        mAdapter.notifyDataSetChanged();

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
