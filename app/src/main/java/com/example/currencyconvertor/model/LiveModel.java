package com.example.currencyconvertor.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class LiveModel {
        @SerializedName("quotes")
        @Expose
        private Quotes quotes;
        @SerializedName("source")
        @Expose
        private String source;
        @SerializedName("success")
        @Expose
        private Boolean success;
        @SerializedName("timestamp")
        @Expose
        private Integer timestamp;

        public Quotes getQuotes() {
            return quotes;
        }

        public void setQuotes(Quotes quotes) {
            this.quotes = quotes;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public Integer getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Integer timestamp) {
            this.timestamp = timestamp;
        }

    }

