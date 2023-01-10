package com.sanjay.example.contentmenagement.repository;


import com.sanjay.example.contentmenagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
