package com.example.currencyconvertor.core.newtworkdata.apimanager;

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
            request.addHeader("apikey", "lFC3nowi30GKFGaaj7G3cQx3v9aCQjd0");
        return chain.proceed(request.build());
    }
}
