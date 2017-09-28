package com.nearbylocation.dagger;

import android.content.Context;
import com.nearbylocation.App;
import com.nearbylocation.repository.BooksRepository;
import com.nearbylocation.repository.DatabaseBooksRepository;
import com.nearbylocation.repository.NetworkRepository;
import com.nearbylocation.repository.Repository;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final App application;

    public AppModule(App app) {
        this.application = app;
    }

    @Provides
    @Singleton
    Context providesApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    BooksRepository providesBooksRepository() {
        return new DatabaseBooksRepository();
    }

    @Provides
    @Singleton
    Repository providesRepository() {
        return new NetworkRepository();
    }
}
