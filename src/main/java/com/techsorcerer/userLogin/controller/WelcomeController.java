package com.techsorcerer.userLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@GetMapping
	public String welcomePage(HttpSession httpSession,HttpServletResponse response ,Model model) {
		// 
		response.setHeader("Cache-Control", "no-store,max-age=0,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		String username = (String) httpSession.getAttribute("username");
		
		if(username == null) {
			return "redirect:/login";
		}
		
		model.addAttribute("username", username);
		return "welcome";
	}
}
