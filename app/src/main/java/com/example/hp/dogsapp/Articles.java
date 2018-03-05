package com.example.hp.dogsapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HP on 3/3/2018.
 */

public class Articles {
    @SerializedName("source")
    private Source source;
    private String title;
    private String description;
    private String url;
    private String urlToImage;

    public Articles(Source source, String title, String description, String url, String urlToImage) {
        this.source = source;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
    }

    public Source getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }
}
