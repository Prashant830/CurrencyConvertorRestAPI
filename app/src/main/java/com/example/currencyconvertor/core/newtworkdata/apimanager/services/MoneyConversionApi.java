package com.example.currencyconvertor.core.newtworkdata.apimanager.services;

import com.example.currencyconvertor.core.newtworkdata.entity.model.CurrencyConversion;

import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

public interface MoneyConversionApi {
    //convert?to=INR&from=USD&amount=5&date=2022-07-08
    @GET("convert")
    Observable<CurrencyConversion> getMoneyConversionDetails(@QueryMap Map<String,String> map);
}
