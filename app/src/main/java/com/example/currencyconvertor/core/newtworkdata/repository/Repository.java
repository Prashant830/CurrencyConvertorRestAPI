package com.example.currencyconvertor.core.newtworkdata.repository;

import com.example.currencyconvertor.core.newtworkdata.apimanager.ApiResponse;
import com.example.currencyconvertor.core.newtworkdata.entity.model.CurrencyConversion;
import com.example.currencyconvertor.core.newtworkdata.entity.model.LiveModel;

import java.util.Map;

import io.reactivex.rxjava3.core.Observable;

public class Repository {

    public static Observable<LiveModel> getLiveData() {
        return ApiResponse.getLiveDataApi().getLiveData();
    }

    public static Observable<CurrencyConversion> getMoneyConversionDetails(Map<String,String> map) {
        return ApiResponse.getMoneyConversionApi().getMoneyConversionDetails(map);
    }

    }
