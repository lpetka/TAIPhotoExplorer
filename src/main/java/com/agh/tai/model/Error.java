package com.agh.tai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Error implements Serializable{

    @JsonProperty("errorData")
    private ErrorData errorData;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private int status;

    public Error(ErrorData errorData, boolean success, int status) {
        this.errorData = errorData;
        this.success = success;
        this.status = status;
    }

    public ErrorData getErrorData() {
        return errorData;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getStatus() {
        return status;
    }

    public void setErrorData(ErrorData errorData) {
        this.errorData = errorData;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}


