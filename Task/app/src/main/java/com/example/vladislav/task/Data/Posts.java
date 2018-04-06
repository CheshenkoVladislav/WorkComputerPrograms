/* Copyright 2018 freecodeformat.com */
package com.example.vladislav.task.Data;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/* Time: 2018-04-06 14:48:54 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Posts {

    @JsonProperty("comments_count")
    private int commentsCount;
    private Date day;
    private int id;
    private String name;
    @JsonProperty("product_state")
    private String productState;
    private String tagline;
    @JsonProperty("ios_featured_at")
    private String iosFeaturedAt;
    @JsonProperty("category_id")
    private String categoryId;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("current_user")
    private CurrentUser currentUser;
    @JsonProperty("discussion_url")
    private String discussionUrl;
    private String exclusive;
    private boolean featured;
    @JsonProperty("maker_inside")
    private boolean makerInside;
    private List<String> makers;
    private List<String> platforms;
    @JsonProperty("redirect_url")
    private String redirectUrl;
    @JsonProperty("screenshot_url")
    private ScreenshotUrl screenshotUrl;
    private Thumbnail thumbnail;
    private List<Topics> topics;
    private User user;
    @JsonProperty("votes_count")
    private int votesCount;
    public void setCommentsCount(int commentsCount) {
         this.commentsCount = commentsCount;
     }
     public int getCommentsCount() {
         return commentsCount;
     }

    public void setDay(Date day) {
         this.day = day;
     }
     public Date getDay() {
         return day;
     }

    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setProductState(String productState) {
         this.productState = productState;
     }
     public String getProductState() {
         return productState;
     }

    public void setTagline(String tagline) {
         this.tagline = tagline;
     }
     public String getTagline() {
         return tagline;
     }

    public void setIosFeaturedAt(String iosFeaturedAt) {
         this.iosFeaturedAt = iosFeaturedAt;
     }
     public String getIosFeaturedAt() {
         return iosFeaturedAt;
     }

    public void setCategoryId(String categoryId) {
         this.categoryId = categoryId;
     }
     public String getCategoryId() {
         return categoryId;
     }

    public void setCreatedAt(Date createdAt) {
         this.createdAt = createdAt;
     }
     public Date getCreatedAt() {
         return createdAt;
     }

    public void setCurrentUser(CurrentUser currentUser) {
         this.currentUser = currentUser;
     }
     public CurrentUser getCurrentUser() {
         return currentUser;
     }

    public void setDiscussionUrl(String discussionUrl) {
         this.discussionUrl = discussionUrl;
     }
     public String getDiscussionUrl() {
         return discussionUrl;
     }

    public void setExclusive(String exclusive) {
         this.exclusive = exclusive;
     }
     public String getExclusive() {
         return exclusive;
     }

    public void setFeatured(boolean featured) {
         this.featured = featured;
     }
     public boolean getFeatured() {
         return featured;
     }

    public void setMakerInside(boolean makerInside) {
         this.makerInside = makerInside;
     }
     public boolean getMakerInside() {
         return makerInside;
     }

    public void setMakers(List<String> makers) {
         this.makers = makers;
     }
     public List<String> getMakers() {
         return makers;
     }

    public void setPlatforms(List<String> platforms) {
         this.platforms = platforms;
     }
     public List<String> getPlatforms() {
         return platforms;
     }

    public void setRedirectUrl(String redirectUrl) {
         this.redirectUrl = redirectUrl;
     }
     public String getRedirectUrl() {
         return redirectUrl;
     }

    public void setScreenshotUrl(ScreenshotUrl screenshotUrl) {
         this.screenshotUrl = screenshotUrl;
     }
     public ScreenshotUrl getScreenshotUrl() {
         return screenshotUrl;
     }

    public void setThumbnail(Thumbnail thumbnail) {
         this.thumbnail = thumbnail;
     }
     public Thumbnail getThumbnail() {
         return thumbnail;
     }

    public void setTopics(List<Topics> topics) {
         this.topics = topics;
     }
     public List<Topics> getTopics() {
         return topics;
     }

    public void setUser(User user) {
         this.user = user;
     }
     public User getUser() {
         return user;
     }

    public void setVotesCount(int votesCount) {
         this.votesCount = votesCount;
     }
     public int getVotesCount() {
         return votesCount;
     }

}