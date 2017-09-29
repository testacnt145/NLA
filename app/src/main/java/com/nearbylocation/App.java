package com.nearbylocation;

import android.app.Application;
import android.content.Context;
import com.facebook.stetho.Stetho;
import com.nearbylocation.constants.Network;
import com.nearbylocation.dagger.AppComponent;
import com.nearbylocation.dagger.AppModule;
import com.nearbylocation.dagger.DaggerAppComponent;
import com.nearbylocation.dagger.DaggerNetworkComponent;
import com.nearbylocation.dagger.NetworkComponent;
import com.nearbylocation.dagger.NetworkModule;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;
import io.realm.Realm;

public class App extends Application {

    //dagger
    private AppComponent component;
    private NetworkComponent networkComponent;

    public static Context applicationContext;


    @Override
    public void onCreate() {
        super.onCreate();

        applicationContext = getApplicationContext();

        //Realm
        Realm.init(this);

        //Stetho
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this)
                        )
                        .enableWebKitInspector(
                                RealmInspectorModulesProvider
                                        .builder(this)
                                        .build()
                        )
                        .build());



        //Dagger
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        component.inject(this);

    }

    public AppComponent getAppComponent() {
        return component;
    }
}
