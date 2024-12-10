package com.techsorcerer.userLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techsorcerer.userLogin.exceptions.AuthenticationFailedException;
import com.techsorcerer.userLogin.service.UserService;
import com.techsorcerer.userLogin.userdto.LoginDto;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String loginPage(Model model) {
		model.addAttribute("loginDto", new LoginDto());
		return "loginForm";
	}
	
	@PostMapping
	public String loginUser( @Valid @ModelAttribute LoginDto loginDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		if(bindingResult.hasErrors()) {
//			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "loginForm"; 
		}
		
		try {
			boolean isAuthenticated = userService.authenticateUser(loginDto.getUsername(), loginDto.getPassword());
			
			if(isAuthenticated) {
				return "welcome";
			}
		} catch (AuthenticationFailedException e) {
			model.addAttribute("error", e.getMessage());
			return "loginForm";
		}
		
		return "loginForm";
	}

}
