package com.agh.tai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Basic
{
    @JsonProperty("data")
    private String data;

    @JsonProperty("success")
    private String success;

    @JsonProperty("status")
    private String status;

    public Basic(String data, String success, String status)
    {
        this.data = data;
        this.success = success;
        this.status = status;
    }

    public Basic()
    {

    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public String getSuccess()
    {
        return success;
    }

    public void setSuccess(String success)
    {
        this.success = success;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
