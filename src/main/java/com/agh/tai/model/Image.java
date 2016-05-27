package com.agh.tai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image
{
    @JsonProperty("data")
    private Data data;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private int status;

    public Image(Data data, boolean success, int status) {
        this.data = data;
        this.success = success;
        this.status = status;
    }

    public Image()
    {

    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
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
