/*
 * Author Name:
 * Date: 11/29/2022
 * Created With: IntelliJ IDEA Community Edition
 */


package com.sanjay.example.contentmenagement.controller;


import com.sanjay.example.contentmenagement.model.Role;
import com.sanjay.example.contentmenagement.model.User;
import com.sanjay.example.contentmenagement.model.UserRole;
import com.sanjay.example.contentmenagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin("*")
public class UserController {



    private UserService userService;

    @Autowired

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveUserFun(@RequestBody User user) throws Exception {
        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("Admin");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);


        return  ResponseEntity.ok(this.userService.createUser(user,roles));



    }

    @GetMapping(value = "/{userName}")

public User getUser(@PathVariable("username") String username)    {
        return this.userService.fatchUserByUserName(username);
    }

    @DeleteMapping(value = "/{id}")
    public void deletfun1(@PathVariable("id") long id){
        this.userService.deleteUser(id);

    }





}
