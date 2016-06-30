package com.agh.tai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TagsList {

    @JsonProperty("tags_list")
    private List<String> tagsList;

    @JsonProperty("page")
    private int page;

    public TagsList() { }

    public TagsList(List<String> tagsList, int page) {
        this.tagsList = tagsList;
        this.page = page;
    }

    public List<String> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<String> tagsList) {
        this.tagsList = tagsList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
