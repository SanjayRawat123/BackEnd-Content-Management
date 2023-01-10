package com.sanjay.example.contentmenagement.repository;


import com.sanjay.example.contentmenagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
 public User findByusername(String username);
}
