package com.agh.tai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image
{
    @JsonProperty("data")
    private ImageData imageData;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private int status;

    public Image(ImageData imageData, boolean success, int status) {
        this.imageData = imageData;
        this.success = success;
        this.status = status;
    }

    public Image()
    {

    }

    public ImageData getImageData() {
        return imageData;
    }

    public void setImageData(ImageData imageData) {
        this.imageData = imageData;
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
