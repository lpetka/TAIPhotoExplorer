package com.agh.tai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageVote {

    @JsonProperty("id")
    private String id;

    @JsonProperty("vote")
    private String vote;

    public ImageVote() {}

    public ImageVote(String id, String vote) {
        this.id = id;
        this.vote = vote;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }
}
