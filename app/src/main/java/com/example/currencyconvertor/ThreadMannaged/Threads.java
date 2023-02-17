package com.example.currencyconvertor.ThreadMannaged;

import android.util.Log;

public class Threads extends Thread{


    @Override
    public void run(){
        Log.i("",Thread.currentThread().getName());
    }
}
