package com.company.chatterbook.models;

import java.util.List;

public class User {

    private String name;
    private List<ChatterPost> userPosts;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChatterPost> getChatterPosts() {
        return userPosts;
    }

    public void setChatterPosts(List<ChatterPost> userPosts) {
        this.userPosts = userPosts;
    }
}
