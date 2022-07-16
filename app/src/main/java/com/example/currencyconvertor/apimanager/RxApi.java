package com.example.currencyconvertor.apimanager;

import android.app.DownloadManager;

import com.example.currencyconvertor.model.CurrencyConversion;
import com.example.currencyconvertor.model.LiveModel;
import com.example.currencyconvertor.model.Quotes;

import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RxApi {

    @GET("live")
    Observable<LiveModel> getLiveData();

    //convert?to=INR&from=USD&amount=5&date=2022-07-08
    @GET("convert")
    Observable<CurrencyConversion> getMoneyConversionDetails(@QueryMap Map<String,String> map);

}

