package com.agh.tai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GalleryItem
{
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
    private BigDecimal width;

    @JsonProperty("height")
    private BigDecimal height;

    @JsonProperty("size")
    private BigDecimal size;

    @JsonProperty("views")
    private BigDecimal views;

    @JsonProperty("bandwidth")
    private BigDecimal bandwidth;

    @JsonProperty("deletehash")
    private String deletehash;

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

    @JsonProperty("vote")
    private String vote;

    @JsonProperty("favorite")
    private boolean favorite;

    @JsonProperty("nsfw")
    private boolean nsfw;

    @JsonProperty("comment_count")
    private BigDecimal commentCount;

    @JsonProperty("topic")
    private String topic;

    @JsonProperty("topic_id")
    private BigDecimal topicId;

    @JsonProperty("section")
    private String section;

    @JsonProperty("account_url")
    private String accountUrl;

    @JsonProperty("account_id")
    private BigDecimal accountId;

    @JsonProperty("ups")
    private BigDecimal ups;

    @JsonProperty("downs")
    private String downs;

    @JsonProperty("points")
    private String points;

    @JsonProperty("score")
    private BigDecimal score;

    @JsonProperty("is_album")
    private boolean isAlbum;

    @JsonProperty("cover")
    private String cover;

    @JsonProperty("cover_width")
    private BigDecimal coverWidth;

    @JsonProperty("cover_height")
    private BigDecimal coverHeight;

    @JsonProperty("layout")
    private String layout;

    @JsonProperty("images_count")
    private BigDecimal imagesCount;

    @JsonProperty("images")
    private ArrayList<ImageData> images;

    public GalleryItem()
    {

    }

    public GalleryItem(String id, String title, String description, BigDecimal datetime, String type, boolean animated, BigDecimal width, BigDecimal height, BigDecimal size, BigDecimal views, BigDecimal bandwidth, String deletehash, String link, String gifv, String mp4, String webm, BigDecimal mp4Size, BigDecimal webmSize, boolean looping, String vote, boolean favorite, boolean nsfw, BigDecimal commentCount, String topic, BigDecimal topicId, String section, String accountUrl, BigDecimal accountId, BigDecimal ups, String downs, String points, BigDecimal score, boolean isAlbum, String cover, BigDecimal coverWidth, BigDecimal coverHeight, String layout, BigDecimal imagesCount, ArrayList<ImageData> images) {
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
        this.link = link;
        this.gifv = gifv;
        this.mp4 = mp4;
        this.webm = webm;
        this.mp4Size = mp4Size;
        this.webmSize = webmSize;
        this.looping = looping;
        this.vote = vote;
        this.favorite = favorite;
        this.nsfw = nsfw;
        this.commentCount = commentCount;
        this.topic = topic;
        this.topicId = topicId;
        this.section = section;
        this.accountUrl = accountUrl;
        this.accountId = accountId;
        this.ups = ups;
        this.downs = downs;
        this.points = points;
        this.score = score;
        this.isAlbum = isAlbum;
        this.cover = cover;
        this.coverWidth = coverWidth;
        this.coverHeight = coverHeight;
        this.layout = layout;
        this.imagesCount = imagesCount;
        this.images = images;
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

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
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

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
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

    public BigDecimal getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(BigDecimal commentCount) {
        this.commentCount = commentCount;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public BigDecimal getTopicId() {
        return topicId;
    }

    public void setTopicId(BigDecimal topicId) {
        this.topicId = topicId;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAccountUrl() {
        return accountUrl;
    }

    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }

    public BigDecimal getAccountId() {
        return accountId;
    }

    public void setAccountId(BigDecimal accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getUps() {
        return ups;
    }

    public void setUps(BigDecimal ups) {
        this.ups = ups;
    }

    public String getDowns() {
        return downs;
    }

    public void setDowns(String downs) {
        this.downs = downs;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public boolean isAlbum() {
        return isAlbum;
    }

    public void setAlbum(boolean album) {
        isAlbum = album;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public BigDecimal getCoverWidth() {
        return coverWidth;
    }

    public void setCoverWidth(BigDecimal coverWidth) {
        this.coverWidth = coverWidth;
    }

    public BigDecimal getCoverHeight() {
        return coverHeight;
    }

    public void setCoverHeight(BigDecimal coverHeight) {
        this.coverHeight = coverHeight;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public BigDecimal getImagesCount() {
        return imagesCount;
    }

    public void setImagesCount(BigDecimal imagesCount) {
        this.imagesCount = imagesCount;
    }

    public List<ImageData> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImageData> images) {
        this.images = images;
    }
}
