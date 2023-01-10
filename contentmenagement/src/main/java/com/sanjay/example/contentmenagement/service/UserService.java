package com.sanjay.example.contentmenagement.service;


import com.sanjay.example.contentmenagement.model.User;
import com.sanjay.example.contentmenagement.model.UserRole;

import java.util.Set;

public interface UserService {

    //creating user

    public User createUser(User user, Set<UserRole>userRoles) throws Exception;

    //get user by name
    public User fatchUserByUserName(String username);

    //delete user by id

    public void deleteUser(long id);


    //public  abstract User loginCheck(String userName, String password);
}
