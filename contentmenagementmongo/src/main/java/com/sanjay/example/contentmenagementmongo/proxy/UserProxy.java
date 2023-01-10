package com.sanjay.example.contentmenagementmongo.proxy;


import com.sanjay.example.contentmenagementmongo.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authenticationService",url = "http://localhost:8080")
public interface UserProxy {


    @PostMapping(value = "/user/")
 ResponseEntity<?> saveUserFun(@RequestBody User user);

}
