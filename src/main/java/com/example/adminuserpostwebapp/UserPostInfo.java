package com.example.adminuserpostwebapp;

import java.util.List;

public class UserPostInfo {

    private int userId;
    private String name;
    private String username;
    private String email;
    private List<PostInfo> posts;

    public UserPostInfo(int userId, String name, String username, String email, List<PostInfo> posts) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.email = email;
        this.posts = posts;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public List<PostInfo> getPosts() {
        return posts;
    }


}
