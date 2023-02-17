package com.example.currencyconvertor.currencyapplication.moneyconvertor.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.currencyconvertor.R;
import com.example.currencyconvertor.core.newtworkdata.apimanager.ErrorHandlingInterceptor;
import com.example.currencyconvertor.core.newtworkdata.entity.model.CurrencyConversion;
import com.example.currencyconvertor.core.newtworkdata.entity.model.LiveModel;
import com.example.currencyconvertor.core.newtworkdata.repository.Repository;
import com.example.currencyconvertor.currencyapplication.currencyavailable.CurrAvailableCompact;
import com.example.currencyconvertor.currencyapplication.currencyavailable.presenter.MainPresenter;
import com.example.currencyconvertor.currencyapplication.moneyconvertor.MoneyConvCompact;
import com.example.currencyconvertor.currencyapplication.moneyconvertor.presenter.MoneyConvertionPresenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MoneyConversion extends AppCompatActivity implements MoneyConvCompact.View {
    EditText curr,conCurr,amt,da;
    TextView mtext;
    ProgressBar progressBar;
    MoneyConvCompact.Presenter presenter;
    CurrencyConversion currencyConversion;
    public static  String currency ,amount,ConversionCurrency,date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_conversion);
        curr = findViewById(R.id.currency);
        conCurr = findViewById(R.id.conversing_currency);
        amt = findViewById(R.id.amount);
        da = findViewById(R.id.date);
        mtext = findViewById(R.id.conversionMoneyDetails);
        progressBar = findViewById(R.id.progress_two);
        presenter = new MoneyConvertionPresenter(this);
    }


    public void submitAmount(View view) {
        currency = curr.getText().toString();
        amount  = (amt.getText().toString());
        ConversionCurrency = conCurr.getText().toString();
        date = da.getText().toString();

        if(currency.isEmpty()){
            Toast.makeText(this, "Please Enter Three Word Currency", Toast.LENGTH_SHORT).show();
            return;
        }
        if(amount.isEmpty()){
            Toast.makeText(this, "Please Enter Currency Amount", Toast.LENGTH_SHORT).show();
            return;
        }
        if(ConversionCurrency.isEmpty()){
            Toast.makeText(this, "Please Enter Three Word Conversion Currency", Toast.LENGTH_SHORT).show();
            return;
        }
        if(date.isEmpty()){
            Toast.makeText(this, "Please Enter Currency Conversion date in YYYY-MM-DD Format", Toast.LENGTH_SHORT).show();
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.i("MoneyConversion",Thread.currentThread().getName());
                    presenter.onCurrencyConvertorButtonClick();
                    mtext.setText(MoneyConvertionPresenter.cunCurrencyList);
                }
                catch (Exception e) {
                    //print the error here
                }
            }
        }).start();

        Log.i("MoneyConversion",Thread.currentThread().getName());

    }

    public void ClearText(View view) {
        mtext.setText("");
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

}