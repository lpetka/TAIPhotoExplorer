package com.agh.tai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TagData
{
    @JsonProperty("name")
    private String name;

    @JsonProperty("followers")
    private BigDecimal followers;

    @JsonProperty("total_items")
    private BigDecimal totalItems;

    @JsonProperty("following")
    private boolean following;

    @JsonProperty("items")
    private ArrayList<GalleryItem> items;

    public TagData(String name, BigDecimal followers, BigDecimal totalItems, boolean following, ArrayList<GalleryItem> items)
    {
        this.name = name;
        this.followers = followers;
        this.totalItems = totalItems;
        this.following = following;
        this.items = items;
    }

    public TagData()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getFollowers() {
        return followers;
    }

    public void setFollowers(BigDecimal followers) {
        this.followers = followers;
    }

    public BigDecimal getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(BigDecimal totalItems) {
        this.totalItems = totalItems;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public ArrayList<GalleryItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<GalleryItem> items) {
        this.items = items;
    }
}
