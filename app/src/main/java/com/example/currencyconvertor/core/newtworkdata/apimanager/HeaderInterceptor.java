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
            request.addHeader("apikey", "UZ4V4G1qKM9oCMyKzVwyWQfM3eYf4WXY");
        return chain.proceed(request.build());
    }
}
