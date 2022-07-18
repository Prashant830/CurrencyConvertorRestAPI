package com.example.currencyconvertor.currencyapplication.currencyavailable.presenter;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.currencyconvertor.core.newtworkdata.apimanager.ErrorHandlingInterceptor;
import com.example.currencyconvertor.core.newtworkdata.entity.model.LiveModel;
import com.example.currencyconvertor.core.newtworkdata.repository.Repository;
import com.example.currencyconvertor.currencyapplication.currencyavailable.CurrAvailableCompact;
import com.example.currencyconvertor.currencyapplication.currencyavailable.ui.Main;

import org.jetbrains.annotations.Contract;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainPresenter implements CurrAvailableCompact.Presenter {

    private CurrAvailableCompact.View mainView;
    public static String cunCurrencyList;
    public MainPresenter(CurrAvailableCompact.View mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onAvailableCurrencyButtonClick() {

            Repository.getLiveData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<LiveModel>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onNext(@NonNull LiveModel liveModel) {

                   cunCurrencyList = "AED - " + liveModel.getQuotes().getUsdaed().toString() + "\n"
                           + "AFN - " + liveModel.getQuotes().getUsdafn().toString() +"\n"
                    + "ALL - " + liveModel.getQuotes().getUsdall().toString() +"\n"
                    + "AMD - " + liveModel.getQuotes().getUsdamd().toString() + "\n"
                   + "INR - " + liveModel.getQuotes().getUsdinr().toString() + "\n"
                   + "ANG - " + liveModel.getQuotes().getUsdang().toString() + "\n"
                    + "AOA - " + liveModel.getQuotes().getUsdaoa().toString() +"\n"
                    + "RUB - " + liveModel.getQuotes().getUsdrub().toString() +"\n"
                   + "TRY - " + liveModel.getQuotes().getUsdtry().toString() + "\n"
                    + "YER - " + liveModel.getQuotes().getUsdyer().toString() + "\n"
                   + "JPY - " + liveModel.getQuotes().getUsdjpy().toString() + "\n"
                    + "PHP - " + liveModel.getQuotes().getUsdphp().toString() + "\n";
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    cunCurrencyList = ErrorHandlingInterceptor.errorMessage;
                }

                @Override
                public void onComplete() {
                }
            });
        }

}
