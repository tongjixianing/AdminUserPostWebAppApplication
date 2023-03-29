package com.example.adminuserpostwebapp;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminAPIController {

    private final String usersAPIURL = "https://jsonplaceholder.typicode.com/users";
    private final String postsAPIURL = "https://jsonplaceholder.typicode.com/posts";
    public List<UserInfo> getAllUsers() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<UserInfo>> responseEntity =
                restTemplate.exchange(
                        usersAPIURL,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<UserInfo>>() {
                        }
                );
        List<UserInfo> users = responseEntity.getBody();
        return users;
    }

    public List<PostInfo> getAllPostsbyUserID(int userID) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<PostInfo>> responseEntity =
                restTemplate.exchange(
                        postsAPIURL+"?userId=" + userID,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<PostInfo>>() {
                        }
                );

        List<PostInfo> posts = responseEntity.getBody();

        return posts;
    }

    @GetMapping("/admin")
    public ResponseEntity<List<UserPostInfo>> getAllUserPosts() {

        List<UserInfo> users = getAllUsers();

        ArrayList<UserPostInfo> userPostInfoList = new ArrayList<>();

        for (UserInfo userInfo : users) {
            List<PostInfo> postsbyUserID = getAllPostsbyUserID(userInfo.getId());
            UserPostInfo userPostInfo = new UserPostInfo(userInfo.getId(), userInfo.getName(), userInfo.getUsername(), userInfo.getEmail(), postsbyUserID);
            userPostInfoList.add(userPostInfo);
        }

        return new ResponseEntity<>(userPostInfoList, HttpStatus.OK);
    }
}
