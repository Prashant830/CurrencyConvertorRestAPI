package com.example.currencyconvertor.currencyapplication.currencyavailable.ui;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.currencyconvertor.R;
import com.example.currencyconvertor.core.newtworkdata.apimanager.ErrorHandlingInterceptor;
import com.example.currencyconvertor.core.newtworkdata.entity.model.LiveModel;
import com.example.currencyconvertor.core.newtworkdata.repository.Repository;
import com.example.currencyconvertor.currencyapplication.currencyavailable.CurrAvailableCompact;
import com.example.currencyconvertor.currencyapplication.currencyavailable.presenter.MainPresenter;
import com.example.currencyconvertor.currencyapplication.moneyconvertor.MoneyConvCompact;
import com.example.currencyconvertor.currencyapplication.moneyconvertor.ui.MoneyConversion;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Main extends AppCompatActivity implements CurrAvailableCompact.View {

    TextView mainText;
    ProgressBar progressBar;
    CurrAvailableCompact.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mainText = findViewById(R.id.openCurrencies);
        progressBar = (ProgressBar) findViewById(R.id.progress_one);
        presenter = new MainPresenter(this);

    }
    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
    }


    public void openApi(View view) {
        presenter.onAvailableCurrencyButtonClick();
        mainText.setText(MainPresenter.cunCurrencyList);

    }

    public void clearApi(View view) {
        mainText.setText("");
    }

    public void OpenCurrencyConvertor(View view) {
        Intent i = new Intent(Main.this, MoneyConversion.class);
        startActivity(i);
    }


}