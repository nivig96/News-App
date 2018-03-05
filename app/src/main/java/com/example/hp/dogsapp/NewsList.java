package com.example.hp.dogsapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 3/3/2018.
 */

public class NewsList {
    private String status;
    private int totalResults;
    @SerializedName("articles")
    @Expose
    private ArrayList<Articles> articles;

    public NewsList(String status, int totalResults, ArrayList<Articles> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }
}
