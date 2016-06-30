package com.agh.tai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageData {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

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

    @JsonProperty("deletehash")
    private String deletehash;

    @JsonProperty("name")
    private String name;

    @JsonProperty("section")
    private String section;

    @JsonProperty("link")
    private String link;

    @JsonProperty("gifv")
    private String gifv;

    @JsonProperty("mp4")
    private String mp4;

    @JsonProperty("webm")
    private String webm;

    @JsonProperty("mp4_size")
    private BigDecimal mp4Size;

    @JsonProperty("webm_size")
    private BigDecimal webmSize;

    @JsonProperty("looping")
    private boolean looping;

    @JsonProperty("favorite")
    private boolean favorite;

    @JsonProperty("nsfw")
    private boolean nsfw;

    @JsonProperty("vote")
    private String vote;

    @JsonProperty("inGallery")
    private boolean inGallery;

    @JsonProperty("topic")
    private String topic;

    @JsonProperty("topic_id")
    private String topicID;

    @JsonProperty("account_url")
    private String accountUrl;

    @JsonProperty("account_id")
    private int accountId;

    @JsonProperty("ups")
    private int ups;

    @JsonProperty("downs")
    private int downs;

    @JsonProperty("points")
    private int points;

    @JsonProperty("score")
    private int score;


    public ImageData()
    {

    }

    public ImageData(String id, String title, String description, BigDecimal datetime, String type, boolean animated, int width, int height, BigDecimal size, BigDecimal views, BigDecimal bandwidth, String deletehash, String name, String section, String link, String gifv, String mp4, String webm, BigDecimal mp4Size, BigDecimal webmSize, boolean looping, boolean favorite, boolean nsfw, String vote, boolean inGallery, String topic, String topicID, String accountUrl, int accountId, int ups, int downs, int points, int score) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.datetime = datetime;
        this.type = type;
        this.animated = animated;
        this.width = width;
        this.height = height;
        this.size = size;
        this.views = views;
        this.bandwidth = bandwidth;
        this.deletehash = deletehash;
        this.name = name;
        this.section = section;
        this.link = link;
        this.gifv = gifv;
        this.mp4 = mp4;
        this.webm = webm;
        this.mp4Size = mp4Size;
        this.webmSize = webmSize;
        this.looping = looping;
        this.favorite = favorite;
        this.nsfw = nsfw;
        this.vote = vote;
        this.inGallery = inGallery;
        this.topic = topic;
        this.topicID = topicID;
        this.accountUrl = accountUrl;
        this.accountId = accountId;
        this.ups = ups;
        this.downs = downs;
        this.points = points;
        this.score = score;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getDeletehash() {
        return deletehash;
    }

    public void setDeletehash(String deletehash) {
        this.deletehash = deletehash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGifv() {
        return gifv;
    }

    public void setGifv(String gifv) {
        this.gifv = gifv;
    }

    public String getMp4() {
        return mp4;
    }

    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

    public String getWebm() {
        return webm;
    }

    public void setWebm(String webm) {
        this.webm = webm;
    }

    public BigDecimal getMp4Size() {
        return mp4Size;
    }

    public void setMp4Size(BigDecimal mp4Size) {
        this.mp4Size = mp4Size;
    }

    public BigDecimal getWebmSize() {
        return webmSize;
    }

    public void setWebmSize(BigDecimal webmSize) {
        this.webmSize = webmSize;
    }

    public boolean isLooping() {
        return looping;
    }

    public void setLooping(boolean looping) {
        this.looping = looping;
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopicID() {
        return topicID;
    }

    public void setTopicID(String topicID) {
        this.topicID = topicID;
    }

    public String getAccountUrl() {
        return accountUrl;
    }

    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUps() {
        return ups;
    }

    public void setUps(int ups) {
        this.ups = ups;
    }

    public int getDowns() {
        return downs;
    }

    public void setDowns(int downs) {
        this.downs = downs;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
