package com.agh.tai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Basic {

    @JsonProperty("data")
    private boolean data;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private int status;

    public Basic(boolean data, boolean success, int status) {
        this.data = data;
        this.success = success;
        this.status = status;
    }

    public Basic()
    {

    }

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
