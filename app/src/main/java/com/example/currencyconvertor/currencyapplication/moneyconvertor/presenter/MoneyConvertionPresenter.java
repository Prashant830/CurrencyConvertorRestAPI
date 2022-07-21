package com.example.currencyconvertor.currencyapplication.moneyconvertor.presenter;

import android.widget.ListView;

import androidx.annotation.NonNull;

import com.example.currencyconvertor.core.newtworkdata.apimanager.ErrorHandlingInterceptor;
import com.example.currencyconvertor.core.newtworkdata.entity.model.CurrencyConversion;
import com.example.currencyconvertor.core.newtworkdata.entity.model.LiveModel;
import com.example.currencyconvertor.core.newtworkdata.repository.Repository;
import com.example.currencyconvertor.currencyapplication.currencyavailable.CurrAvailableCompact;
import com.example.currencyconvertor.currencyapplication.moneyconvertor.MoneyConvCompact;
import com.example.currencyconvertor.currencyapplication.moneyconvertor.ui.MoneyConversion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MoneyConvertionPresenter implements MoneyConvCompact.Presenter {
    private MoneyConvCompact.View mainView;
    public static String cunCurrencyList;
    public MoneyConvertionPresenter(MoneyConvCompact.View mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onCurrencyConvertorButtonClick() {
            Map<String, String> m = new HashMap<>();
            m.put("date", MoneyConversion.date);
            m.put("amount", MoneyConversion.amount);
            m.put("to", MoneyConversion.ConversionCurrency);
            m.put("from", MoneyConversion.currency);

        Repository.getMoneyConversionDetails(m).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<CurrencyConversion>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onNext(@NonNull CurrencyConversion currencyConversion) {

                    cunCurrencyList = "Result - " + currencyConversion.getResult() + "\n"
                    + MoneyConversion.ConversionCurrency +" - " + currencyConversion.getInfo().getQuote() +"\n"
                    +"Convertion Date of A " + MoneyConversion.ConversionCurrency + " on the basis of Date - " + currencyConversion.getDate() +"\n";

                }

                @Override
                public void onError(@NonNull Throwable e) {
                    cunCurrencyList = ErrorHandlingInterceptor.errorMessage + e.getMessage();
                }

                @Override
                public void onComplete() {

                }
            });
        }

    }

