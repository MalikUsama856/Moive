package com.Moive.moive.models;

public class Moive {
    private String title;
    private String description;
    private int thumbnail;
    private String studio;
    private  String rating;
    private String streamingLink;
    private int coverphoto;

    public Moive(String title, int thumbnail, int coverphoto) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.coverphoto = coverphoto;
    }

    public Moive(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public Moive(String title, String description, int thumbnail, String studio, String rating, String streamingLink) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.studio = studio;
        this.rating = rating;
        this.streamingLink = streamingLink;
    }

    public int getCoverphoto() {
        return coverphoto;
    }

    public void setCoverphoto(int coverphoto) {
        this.coverphoto = coverphoto;
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

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStreamingLink() {
        return streamingLink;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }
}
