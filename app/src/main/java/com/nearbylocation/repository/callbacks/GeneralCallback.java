package com.nearbylocation.repository.callbacks;

/**
 * Created by shayan on 9/28/17.
 */

public interface GeneralCallback<T> {

    void onSuccess(T obj);

    void onError(String msg);
}
