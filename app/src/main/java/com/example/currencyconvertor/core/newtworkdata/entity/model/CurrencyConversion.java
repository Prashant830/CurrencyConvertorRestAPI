package com.example.currencyconvertor.core.newtworkdata.entity.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrencyConversion {
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("historical")
        @Expose
        private Boolean historical;
        @SerializedName("info")
        @Expose
        private Info info;
        @SerializedName("query")
        @Expose
        private Query query;
        @SerializedName("result")
        @Expose
        private Double result;
        @SerializedName("success")
        @Expose
        private Boolean success;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Boolean getHistorical() {
            return historical;
        }

        public void setHistorical(Boolean historical) {
            this.historical = historical;
        }

        public Info getInfo() {
            return info;
        }

        public void setInfo(Info info) {
            this.info = info;
        }

        public Query getQuery() {
            return query;
        }

        public void setQuery(Query query) {
            this.query = query;
        }

        public Double getResult() {
            return result;
        }

        public void setResult(Double result) {
            this.result = result;
        }

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

    }
