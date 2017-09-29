package com.nearbylocation.dagger;

import com.nearbylocation.repository.NetworkRepository;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {
    void inject(NetworkRepository networkRepository);
}