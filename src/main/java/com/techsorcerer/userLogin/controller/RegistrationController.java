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

import com.techsorcerer.userLogin.exceptions.UsernameExistsException;
import com.techsorcerer.userLogin.service.UserService;
import com.techsorcerer.userLogin.userdto.UserDto;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	UserService userService;

	@GetMapping
	public String registerForm(Model model) {
		model.addAttribute("userDto", new UserDto());
		return "registerForm";
	}

	@PostMapping
	public String registerUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			return "registerForm"; // Redirect back to the form
		}
		try {
			userService.registerUser(userDto);
			redirectAttributes.addFlashAttribute("success", "User registered successfully!");
		} catch (UsernameExistsException e) {
			model.addAttribute("error", e.getMessage());
			return "registerForm";
		}
		return "redirect:/register"; // Redirect back to the form
	}

}
