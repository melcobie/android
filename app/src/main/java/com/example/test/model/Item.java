package com.example.test.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Item implements Serializable {
    @SerializedName("_id")
    private String id;
    @SerializedName("url")
    private String url;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description = "";
    @SerializedName("genre")
    private String genre = "masculin";
    private String urlVideo;

    public Item(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public Item(String url, String name, String description, String genre) {
        this.url = url;
        this.name = name;
        this.description = description;
        this.genre = genre;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString(){
        return this.getName();
    }
}
