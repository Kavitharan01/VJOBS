package com.example.vjobs.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vjobs.model.Admin;
import com.example.vjobs.repository.AdminLoginRepository;

@Controller
public class AdminLoginController {

	@Autowired
	private AdminLoginRepository adminLoginRepository;
	
	
	@GetMapping("/adminlogin")
    public String adminLoginForm() {
        return "adminlogin";
    }
	
	@PostMapping("/adminlogin")
    public String adminLoginSubmit(@RequestParam("username") String username,
            @RequestParam("password") String password, Model model, HttpSession session) {

        Admin admin = adminLoginRepository.findByUsername(username);

        if (admin != null && admin.getPassword().equals(password)) {
            session.setAttribute("admin", admin);
            return "redirect:/admin";
        } else {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "adminLogin";
        }
    }
}

