package com.agh.tai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("descripton")
    private String descripton;

    @JsonProperty("datetime")
    private BigDecimal datetime;

    @JsonProperty("type")
    private String type;

    @JsonProperty("animated")
    private boolean animated;

    @JsonProperty("width")
    private int width;

    @JsonProperty("height")
    private int height;

    @JsonProperty("size")
    private BigDecimal size;

    @JsonProperty("views")
    private BigDecimal views;

    @JsonProperty("bandwidth")
    private BigDecimal bandwidth;

    @JsonProperty("section")
    private String section;

    @JsonProperty("link")
    private String link;

    @JsonProperty("favorite")
    private boolean favorite;

    @JsonProperty("nsfw")
    private boolean nsfw;

    @JsonProperty("vote")
    private String vote;

    @JsonProperty("inGallery")
    private boolean inGallery;


    public Data()
    {

    }

    public Data(String id, String title, String descripton, BigDecimal datetime, String type, boolean animated, int width, int height, BigDecimal size, BigDecimal views, BigDecimal bandwidth, String section, String link, boolean favorite, boolean nsfw, String vote, boolean inGallery) {
        this.id = id;
        this.title = title;
        this.descripton = descripton;
        this.datetime = datetime;
        this.type = type;
        this.animated = animated;
        this.width = width;
        this.height = height;
        this.size = size;
        this.views = views;
        this.bandwidth = bandwidth;
        this.section = section;
        this.link = link;
        this.favorite = favorite;
        this.nsfw = nsfw;
        this.vote = vote;
        this.inGallery = inGallery;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public BigDecimal getDatetime() {
        return datetime;
    }

    public void setDatetime(BigDecimal datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public BigDecimal getViews() {
        return views;
    }

    public void setViews(BigDecimal views) {
        this.views = views;
    }

    public BigDecimal getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(BigDecimal bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isNsfw() {
        return nsfw;
    }

    public void setNsfw(boolean nsfw) {
        this.nsfw = nsfw;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public boolean isInGallery() {
        return inGallery;
    }

    public void setInGallery(boolean inGallery) {
        this.inGallery = inGallery;
    }
}
