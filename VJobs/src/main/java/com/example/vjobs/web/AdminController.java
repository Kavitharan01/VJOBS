package com.example.vjobs.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.vjobs.model.User;
import com.example.vjobs.repository.AdminRepository;


@Controller
public class AdminController {

	
    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        List<User> users = adminRepository.findAll();
        model.addAttribute("users", users);
        return "admin";
    }
    
  
}