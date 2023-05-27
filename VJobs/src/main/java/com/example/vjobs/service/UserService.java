package com.example.vjobs.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.vjobs.model.User;
import com.example.vjobs.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto registrationDto);
}
