package com.example.currencyconvertor.apimanager;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request.Builder request = chain.request().newBuilder();
            request.addHeader("apikey", "6HWkaQaWjkRsrV776AkEQ33AX2FMUTNR");
        return chain.proceed(request.build());
    }
}
