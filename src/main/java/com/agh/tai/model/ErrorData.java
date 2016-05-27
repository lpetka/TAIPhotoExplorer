package com.agh.tai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorData {

    @JsonProperty("error")
    private String error;

    @JsonProperty("request")
    private String request;

    @JsonProperty("method")
    private String method;

    public ErrorData(String error, String request, String method) {
        this.error = error;
        this.request = request;
        this.method = method;
    }

    public String getError() {
        return error;
    }

    public String getRequest() {
        return request;
    }

    public String getMethod() {
        return method;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}