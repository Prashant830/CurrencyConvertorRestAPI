package com.example.currencyconvertor.core.newtworkdata.apimanager;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class ErrorHandlingInterceptor implements Interceptor {
    public static String errorMessage;
    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
      Response response = chain.proceed(chain.request());
      if(!response.isSuccessful()){
          errorMessage = "Unable to make a connection. Server Response Problem";
          return response;
      }

        return response;
    }
}
