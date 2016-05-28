package com.agh.tai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {

    @JsonProperty("data")
    private TagData tagData;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private int status;

    public Tag(TagData tagData, boolean success, int status)
    {
        this.tagData = tagData;
        this.success = success;
        this.status = status;
    }

    public Tag()
    {

    }

    public TagData getTagData() {
        return tagData;
    }

    public void setTagData(TagData tagData) {
        this.tagData = tagData;
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
