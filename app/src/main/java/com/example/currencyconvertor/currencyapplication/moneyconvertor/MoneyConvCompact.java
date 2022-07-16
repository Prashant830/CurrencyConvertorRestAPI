package com.example.currencyconvertor.currencyapplication.moneyconvertor;

import com.example.currencyconvertor.core.newtworkdata.entity.model.CurrencyConversion;
import com.example.currencyconvertor.core.newtworkdata.entity.model.LiveModel;

public interface MoneyConvCompact {
    interface View {
        // method to display progress bar
        // when next random course details
        // is being fetched
        void showProgress();

        // method to hide progress bar
        // when next random course details
        // is being fetched
        void hideProgress();



    }

    interface Presenter {

        // method to be called when
        // the button is clicked
        void onCurrencyConvertorButtonClick();

    }
}
