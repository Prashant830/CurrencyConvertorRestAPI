package com.example.currencyconvertor.core.newtworkdata.apimanager;

import com.example.currencyconvertor.core.newtworkdata.apimanager.services.LiveDataApi;
import com.example.currencyconvertor.core.newtworkdata.apimanager.services.MoneyConversionApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiResponse {
    public static Retrofit retrofit;
    public static OkHttpClient okHttp;
    public static final String BASE_URL = "https://api.apilayer.com/currency_data/";




    public static Retrofit getRetrofit(){
        if(retrofit == null){

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                 loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

                 okHttp = new OkHttpClient.Builder()
                         .addInterceptor(loggingInterceptor)
                         .addInterceptor(new HeaderInterceptor())
                         .addInterceptor(new ErrorHandlingInterceptor())
                         .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttp)
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

   public static LiveDataApi getLiveDataApi(){
        return createApi(LiveDataApi.class);
   }

    public static MoneyConversionApi getMoneyConversionApi(){
        return createApi(MoneyConversionApi.class);
    }

    private static <T> T createApi(Class<T> clazz) {
        return getRetrofit().create(clazz);
    }

}
