package com.sanjay.example.contentmenagementmongo.service;

import com.sanjay.example.contentmenagementmongo.exception.ContentNotFoundException;
import com.sanjay.example.contentmenagementmongo.exception.UserAlreadyExistsException;
import com.sanjay.example.contentmenagementmongo.exception.UserNotFoundException;
import com.sanjay.example.contentmenagementmongo.model.Content;
import com.sanjay.example.contentmenagementmongo.model.User;

import java.util.List;

public interface ContentService {

    User addUser(User user) throws UserAlreadyExistsException;

    User addContentForUser(String username, Content content) throws UserNotFoundException;


    User deleteContentFromUser(String username,int postId) throws UserNotFoundException, ContentNotFoundException;
    List<Content> getContentsForUser(String username) throws UserNotFoundException;

    User updateContentForUser(String username,Content content) throws UserNotFoundException;

    Content getContentOfUser(String username,int postId) throws UserNotFoundException;


}
