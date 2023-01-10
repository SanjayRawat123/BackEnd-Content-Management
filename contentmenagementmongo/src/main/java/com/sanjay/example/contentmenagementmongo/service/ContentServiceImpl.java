package com.sanjay.example.contentmenagementmongo.service;

import com.sanjay.example.contentmenagementmongo.exception.ContentNotFoundException;
import com.sanjay.example.contentmenagementmongo.exception.UserAlreadyExistsException;
import com.sanjay.example.contentmenagementmongo.exception.UserNotFoundException;
import com.sanjay.example.contentmenagementmongo.model.Content;
import com.sanjay.example.contentmenagementmongo.model.User;
import com.sanjay.example.contentmenagementmongo.proxy.UserProxy;
import com.sanjay.example.contentmenagementmongo.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private UserProxy userProxy;



    @Override
    public User addUser(User user) throws UserAlreadyExistsException {
        if(contentRepository.findById(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        User savedUser = contentRepository.save(user);
        if (!(savedUser.getUsername().isEmpty())){
            ResponseEntity  rs = userProxy.saveUserFun(user);
            System.out.println(rs.getBody());
        }
        return savedUser;
    }

    @Override
    public User addContentForUser(String username, Content content) throws UserNotFoundException {

        if (contentRepository.findById(username).isEmpty()){
            throw  new UserNotFoundException();
        }
        User user = contentRepository.findById(username).get();
        if (user.getContentList() == null){
            user.setContentList(Arrays.asList(content));
        }else {
            List<Content> contentList = user.getContentList();

            contentList.add(content);
            user.setContentList(contentList);
        }
        return contentRepository.save(user);
    }

    /**@Override
    public Content updateContentForUser(String username, Content content) {
        return this.contentRepo.save(content);
    }*/


    @Override
    public List<Content> getContentsForUser(String username) throws UserNotFoundException {
        if (contentRepository.findById(username).isEmpty()){
            throw new UserNotFoundException();
        }
        return contentRepository.findById(username).get().getContentList();
    }

    @Override
    public User updateContentForUser(String username, Content content) throws UserNotFoundException {
        if (contentRepository.findById(username).isEmpty()) {
            throw new UserNotFoundException();
        }
        User user = contentRepository.findById(username).get();
        List<Content> contentList = user.getContentList();
        for (Content content1 : contentList) {
            if (content1.getPostId() == content.getPostId()) {
                content1.setTitle(content.getTitle());
                content1.setContent(content.getContent());
                content1.setPostedBy(content.getPostedBy());
                content1.setPostedOn(content.getPostedOn());
            }
        }
        user.setContentList(contentList);
        return contentRepository.save(user);
    }

    @Override
    public User deleteContentFromUser(String username, int postId) throws UserNotFoundException, ContentNotFoundException {
        boolean result = false;
        if (contentRepository.findById(username).isEmpty()){
            throw  new UserNotFoundException();
        }
        User user = contentRepository.findById(username).get();
        List<Content> contentList = user.getContentList();
        result = contentList.removeIf(x->x.getPostId()==postId);
        if (!result){
            throw  new ContentNotFoundException();
        }
        user.setContentList(contentList);
        return contentRepository.save(user);
    }

    @Override
    public Content getContentOfUser(String username, int postId) throws UserNotFoundException {
        if (contentRepository.findById(username).isEmpty()){
            throw  new UserNotFoundException();
        }
        User user = contentRepository.findById(username).get();
        List<Content> contentList = user.getContentList();
        for (Content content1:contentList) {
            if (content1.getPostId() == postId){
                return content1;
            }
        }
       return contentList.get(0);
    }


}
