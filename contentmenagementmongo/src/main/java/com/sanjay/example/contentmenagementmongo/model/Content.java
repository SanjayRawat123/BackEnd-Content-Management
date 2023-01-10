package com.sanjay.example.contentmenagementmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Content {

   @Id
    private int postId;
    private String title;
    private String content;
    private String postedOn;
    private String postedBy;

    public Content(int postId, String title, String content, String postedOn, String postedBy) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.postedOn = postedOn;
        this.postedBy = postedBy;
    }

    public Content() {
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(String postedOn) {
        this.postedOn = postedOn;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    @Override
    public String toString() {
        return "Content{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", postedOn='" + postedOn + '\'' +
                ", postedBy='" + postedBy + '\'' +
                '}';
    }
}
