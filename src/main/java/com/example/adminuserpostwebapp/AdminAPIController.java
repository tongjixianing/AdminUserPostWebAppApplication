package com.example.adminuserpostwebapp;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminAPIController {

    private final String usersAPIURL = "https://jsonplaceholder.typicode.com/users";
    private final String postsAPIURL = "https://jsonplaceholder.typicode.com/posts";

    public List<UserInfo> getAllUsers() {
        RestTemplate restTemplate = new RestTemplate();
        List<UserInfo> users;
        ResponseEntity<List<UserInfo>> responseEntity;
        try {
            responseEntity =
                    restTemplate.exchange(
                            usersAPIURL,
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<UserInfo>>() {
                            }
                    );

        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        users = responseEntity.getBody();


        return users;
    }

    public List<PostInfo> getAllPostsbyUserID(int userID) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<PostInfo>> responseEntity;
        try {
            responseEntity =
                    restTemplate.exchange(
                            postsAPIURL,
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<PostInfo>>() {
                            }
                    );
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<PostInfo> allposts = responseEntity.getBody();

        List<PostInfo> postsByUserID = new ArrayList<>();


        for (PostInfo postInfo : allposts) {
            if (postInfo.getUserId() == userID)
                postsByUserID.add(postInfo);
        }


        return postsByUserID;
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
