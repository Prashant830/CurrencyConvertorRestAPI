package com.example.currencyconvertor.core.newtworkdata.apimanager.services;

import com.example.currencyconvertor.core.newtworkdata.entity.model.LiveModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface LiveDataApi {

    @GET("live")
    Observable<LiveModel> getLiveData();

}

