package com.example.currencyconvertor.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.currencyconvertor.R;
import com.example.currencyconvertor.apimanager.ApiResponse;
import com.example.currencyconvertor.apimanager.ErrorHandlingInterceptor;
import com.example.currencyconvertor.apimanager.RxApi;
import com.example.currencyconvertor.model.CurrencyConversion;
import com.example.currencyconvertor.model.Query;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MoneyConversion extends AppCompatActivity {
    RxApi rxApi = ApiResponse.getApi();
    EditText curr,conCurr,amt,da;
    TextView mtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_conversion);
        curr = findViewById(R.id.currency);
        conCurr = findViewById(R.id.conversing_currency);
        amt = findViewById(R.id.amount);
        da = findViewById(R.id.date);
        mtext = findViewById(R.id.conversionMoneyDetails);
    }

    public void submitAmount(View view) {
        String currency = curr.getText().toString();
        String amount  = (amt.getText().toString());
        String ConversionCurrency = conCurr.getText().toString();
        String date = da.getText().toString();

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


        Map<String,String> m = new HashMap<>();
        m.put("from",currency);
        m.put("to",ConversionCurrency);
        m.put("amount",amount.toString());
        m.put("date",date);


        Observable<CurrencyConversion> observable = rxApi.getMoneyConversionDetails(m);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<CurrencyConversion>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull CurrencyConversion currencyConversion) {
                mtext.append("Result - " + currencyConversion.getResult() + "\n");
                mtext.append( ConversionCurrency +" - " + currencyConversion.getInfo().getQuote() +"\n");
                mtext.append("Convertion Date of A " + ConversionCurrency + " on the basis of Date - " + currencyConversion.getDate() +"\n");
                mtext.append("\n");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Toast.makeText(MoneyConversion.this, ErrorHandlingInterceptor.errorMessage, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void ClearText(View view) {
        mtext.setText("");
    }
}