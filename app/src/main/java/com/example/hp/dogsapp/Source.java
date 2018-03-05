package com.example.hp.dogsapp;

/**
 * Created by HP on 3/3/2018.
 */

public class Source {
    private String id;
    private String name;

    public Source(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String   getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
