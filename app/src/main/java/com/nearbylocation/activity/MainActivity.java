package com.nearbylocation.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.nearbylocation.App;
import com.nearbylocation.databinding.ActivityMainBinding;
import com.nearbylocation.contract.MainActivityContract;
import com.nearbylocation.R;
import com.nearbylocation.presenter.MainActivityPresenter;
import com.nearbylocation.repository.BooksRepository;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    // TODO:
    //permission marshmallow for location

    @Inject
    BooksRepository booksRepository;
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityContract.View mainActivityView = this;
        presenter = new MainActivityPresenter(mainActivityView, booksRepository);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPresenter(presenter);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        ((App) getApplication()).getAppComponent().inject(this);
    }


    @Override
    public void startFourSquareActivity() {
        startActivity(new Intent(this, FourSquareActivity.class));
    }

    @Override
    public void startGooglePlacesActivity() {
        startActivity(new Intent(this, GooglePlacesActivity.class));
    }
}


//    @Override
//    public void fun(String a, String b, , String c, String d, final GeneralCallback<SocialMediaLoginResponse> callback) {
//        apiName.apiFun(name,dob,gender,email,socialMediaType, social_media_id,mobile,deviceType,deviceToken,GlobalValues.PARTNER_ID).enqueue(new Callback<SocialMediaLoginResponse>() {
//            @Override
//            public void onResponse(Call<SocialMediaLoginResponse> call, Response<SocialMediaLoginResponse> response) {
//                if (response.isSuccessful())
//                    callback.onSuccess(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<SocialMediaLoginResponse> call, Throwable t) {
//                callback.onError(t.getMessage());
//            }
//        });
//    }



//    @Override
//    public void name(String name, String dob, final GeneralCallback<NearbyPlaces> callback) {
//        api.socialMediaLogin(name,dob)
//           .enqueue(new Callback<SocialMediaLoginResponse>() {
//                @Override
//                public void onResponse(Call<SocialMediaLoginResponse> call, Response<SocialMediaLoginResponse> response) {
//                    if (response.isSuccessful())
//                        callback.onSuccess(response.body());
//                }
//
//                @Override
//                public void onFailure(Call<SocialMediaLoginResponse> call, Throwable t) {
//                    callback.onError(t.getMessage());
//                }
//        });
//    }