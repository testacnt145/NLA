package com.nearbylocation.repository;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by shayan on 9/28/17.
 */

public interface GeneralCallback<T> {

    void onResponse(Call<T> call, Response<String> response);

    void onFailure(Call<T> call, Throwable t);
}
