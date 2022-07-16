package com.example.currencyconvertor.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.currencyconvertor.R;
import com.example.currencyconvertor.apimanager.ApiResponse;
import com.example.currencyconvertor.apimanager.ErrorHandlingInterceptor;
import com.example.currencyconvertor.apimanager.RxApi;
import com.example.currencyconvertor.model.LiveModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Main extends AppCompatActivity {
    RxApi rxApi = ApiResponse.getApi();
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text = findViewById(R.id.recycle1);
    }

    public void openApi(View view) {
        Observable<LiveModel> observable = rxApi.getLiveData();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<LiveModel>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull LiveModel liveModels) {
                text.append("AED - " + liveModels.getQuotes().getUsdaed() + "\n");
                text.append("AFN - " + liveModels.getQuotes().getUsdafn() +"\n");
                text.append("ALL - " + liveModels.getQuotes().getUsdall() +"\n");
                text.append("AMD - " + liveModels.getQuotes().getUsdamd() + "\n");
                text.append("INR - " + liveModels.getQuotes().getUsdinr() + "\n");
                text.append("ANG - " + liveModels.getQuotes().getUsdang() + "\n");
                text.append("AOA - " + liveModels.getQuotes().getUsdaoa() +"\n");
                text.append("RUB - " + liveModels.getQuotes().getUsdrub() +"\n");
                text.append("TRY - " + liveModels.getQuotes().getUsdtry() + "\n");
                text.append("YER - " + liveModels.getQuotes().getUsdyer() + "\n");
                text.append("JPY - " + liveModels.getQuotes().getUsdjpy() + "\n");
                text.append("PHP - " + liveModels.getQuotes().getUsdphp() + "\n");
                text.append("\n");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Toast.makeText(Main.this, ErrorHandlingInterceptor.errorMessage, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void clearApi(View view) {
        text.setText("");
    }

    public void OpenCurrencyConvertor(View view) {
        Intent i = new Intent(Main.this,MoneyConversion.class);
        startActivity(i);
    }
}