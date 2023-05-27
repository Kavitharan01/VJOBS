package com.example.vjobs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vjobs.model.User;

public interface AdminRepository extends JpaRepository<User, Long> {
    List<User> findAll();
 
}
