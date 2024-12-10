package com.techsorcerer.userLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@GetMapping
	public String welcomePage(HttpSession httpSession, Model model) {
		String username = (String) httpSession.getAttribute("username");
		
		if(username == null) {
			return "redirect:/login";
		}
		
		model.addAttribute("username", username);
		return "welcome";
	}
}
