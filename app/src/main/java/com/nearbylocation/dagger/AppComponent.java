package com.nearbylocation.dagger;

import com.nearbylocation.App;
import com.nearbylocation.activity.FourSquareActivity;
import com.nearbylocation.activity.GooglePlacesActivity;
import com.nearbylocation.activity.MainActivity;
import com.nearbylocation.repository.NetworkRepository;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = { AppModule.class, ApiModule.class })
public interface AppComponent {
    void inject(App application);
    void inject(MainActivity mainActivity);
    void inject(FourSquareActivity fourSquareActivity);
    void inject(GooglePlacesActivity googlePlacesActivity);

    void inject(NetworkRepository networkRepository);
}