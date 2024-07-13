package com.sword.feat.controller;

import com.sword.feat.model.User;
import com.sword.feat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthController {

	private final UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}

	@GetMapping("/admin/work-space")
	public String adminWorkSpace() {
		return "admin/admin-workspace";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String saveRegister(User user) {
		var result = userService.registerUser(user);
		return result != null ? "redirect:/login" : "redirect:/register";
	}

}
