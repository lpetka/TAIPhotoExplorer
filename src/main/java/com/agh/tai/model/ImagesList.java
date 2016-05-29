package com.agh.tai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesList {

    @JsonProperty("data")
    List<ImageData> images;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private int status;

    public ImagesList()
    {

    }

    public ImagesList(List<ImageData> images, boolean success, int status) {
        this.images = images;
        this.success = success;
        this.status = status;
    }

    public List<ImageData> getImages() {
        return images;
    }

    public void setImages(List<ImageData> images) {
        this.images = images;
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
