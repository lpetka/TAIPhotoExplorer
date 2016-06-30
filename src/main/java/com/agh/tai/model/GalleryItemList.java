package com.agh.tai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GalleryItemList {

    @JsonProperty("data")
    private List<GalleryItem> data;

    public GalleryItemList() { }

    public GalleryItemList(List<GalleryItem> data) {
        this.data = data;
    }

    public List<GalleryItem> getData() {
        return data;
    }

    public void setData(List<GalleryItem> data) {
        this.data = data;
    }
}
