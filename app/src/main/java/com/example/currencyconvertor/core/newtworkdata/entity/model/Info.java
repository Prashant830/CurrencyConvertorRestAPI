package com.example.currencyconvertor.core.newtworkdata.entity.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {
    @SerializedName("quote")
    @Expose
    private Double quote;
    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;

    public Double getQuote() {
        return quote;
    }

    public void setQuote(Double quote) {
        this.quote = quote;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

}
