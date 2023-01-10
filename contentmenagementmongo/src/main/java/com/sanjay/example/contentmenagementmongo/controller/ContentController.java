package com.sanjay.example.contentmenagementmongo.controller;


import com.sanjay.example.contentmenagementmongo.exception.ContentNotFoundException;
import com.sanjay.example.contentmenagementmongo.exception.UserAlreadyExistsException;
import com.sanjay.example.contentmenagementmongo.exception.UserNotFoundException;
import com.sanjay.example.contentmenagementmongo.model.Content;
import com.sanjay.example.contentmenagementmongo.model.User;

import com.sanjay.example.contentmenagementmongo.service.ContentService;
import com.sanjay.example.contentmenagementmongo.service.ContentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/contentManagement/v1/api/")
@CrossOrigin("*")
public class ContentController {

    @Autowired
    private ContentService contentService;



    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyExistsException {
        ResponseEntity responseEntity=null;
        try{
            user.setContentList(new ArrayList<>());
            responseEntity=new ResponseEntity<>(contentService.addUser(user), HttpStatus.CREATED);
        }catch (UserAlreadyExistsException e){
            throw new UserAlreadyExistsException();
        }catch (Exception e){
            responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping ("/content/{username}")
    public ResponseEntity<?> addContentForUser(@PathVariable String username, @RequestBody Content content){
        ResponseEntity<?> responseEntity =  null;
        try{
            responseEntity = new ResponseEntity<>(contentService.addContentForUser(username,content),HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/content/delete/{postId}/{username}")

    public ResponseEntity<?> deleteContentFormUser(@PathVariable int postId,@PathVariable String username)
            throws UserNotFoundException, ContentNotFoundException {
        ResponseEntity<?> responseEntity = null;
        try{
            responseEntity = new ResponseEntity<>(contentService.deleteContentFromUser(username, postId),HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        } catch (ContentNotFoundException e) {
            throw new ContentNotFoundException();
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }






    //http://localhost:9999/contentManagement/v1/api/content/allContent/{username}
    @GetMapping("content/allContent/{username}")
    public ResponseEntity<?> getAllContentsForUser(@PathVariable String username) throws UserNotFoundException {
        ResponseEntity responseEntity = null;
        try {
            responseEntity = new ResponseEntity(contentService.getContentsForUser(username),HttpStatus.OK);
        } catch (UserNotFoundException e) {
           responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("content/updateContent/{username}")
    public ResponseEntity<?> updateContentForUser(@PathVariable String username,@RequestBody Content content) throws UserNotFoundException {
        ResponseEntity responseEntity = null;
        try {
            responseEntity = new ResponseEntity(contentService.updateContentForUser(username, content),HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw  new UserNotFoundException();
        }catch (Exception e){
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return responseEntity;


    }




    @GetMapping("content/contentByPost/{username}/{postId}")
    public ResponseEntity<?> getSpecificContentsForUser(@PathVariable String username,@PathVariable int postId) throws UserNotFoundException {
        ResponseEntity responseEntity = null;
        try {
            responseEntity = new ResponseEntity(contentService.getContentOfUser(username, postId),HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }




}
