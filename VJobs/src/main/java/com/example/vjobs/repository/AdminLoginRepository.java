package com.example.vjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vjobs.model.Admin;

public interface AdminLoginRepository  extends JpaRepository<Admin, Long> {
	Admin findByUsername(String username);
}
