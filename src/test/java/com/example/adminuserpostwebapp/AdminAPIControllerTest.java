package com.example.adminuserpostwebapp;

import org.junit.jupiter.api.Test;

import org.springframework.http.ResponseEntity;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class AdminAPIControllerTest {

    @Test
    void testGetAllUsers() {

        AdminAPIController adminAPIController = new AdminAPIController();

        List<UserInfo> users = adminAPIController.getAllUsers();

        //Verify the return user list size
        assertEquals(10, users.size());

        // Verify the email for user id == 2

        assertEquals("Shanna@melissa.tv", users.get(1).getEmail());

    }


    @Test
    void testGetAllPostsbyUserID() {
        AdminAPIController adminAPIController = new AdminAPIController();
        List<PostInfo> postsbyUserIDResp = adminAPIController.getAllPostsbyUserID(1);

        //Verify the return list size
        assertEquals(10, postsbyUserIDResp.size());

        // Verify the post title for userid==1
        /*
         * userId	1
         * id	2
         * title	"qui est esse"
         * */
        assertEquals("qui est esse", postsbyUserIDResp.get(1).getTitle());
    }


    @Test
    void testGetAllUserPosts() {

        AdminAPIController adminAPIController = new AdminAPIController();
        ResponseEntity<List<UserPostInfo>> allUserPostsResp = adminAPIController.getAllUserPosts();
        List<UserPostInfo> alluserposts = allUserPostsResp.getBody();

        // There should be 10 users's posts

        assertEquals(10, alluserposts.size());

        //check first userID;
        assertEquals(1, alluserposts.get(0).getUserId());
        // check name associated with first userID
        assertEquals("Leanne Graham", alluserposts.get(0).getName());
        // check usernmae
        assertEquals("Bret", alluserposts.get(0).getUsername());
        // check email
        assertEquals("Sincere@april.biz", alluserposts.get(0).getEmail());
        // check number of posts for the user
        assertEquals(10, alluserposts.get(0).getPosts().size());
        // check post title
        assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", alluserposts.get(0).getPosts().get(0).getTitle());

    }

}