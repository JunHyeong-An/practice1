package com.manage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manage.model.UserDTO;
import com.manage.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService us;
	
	@GetMapping("/join")
	public void join() {}
	
	@PostMapping("/join")
	public String join(UserDTO dto) {
		us.join(dto);
		return "/login";
	}
	
	@GetMapping("login")
	public void login() {}
	
	@PostMapping("login")
	public String login(UserDTO dto, HttpSession session) {
		boolean flag = us.login(dto, session);
		
		if(flag) return "/index";
		else return "redirect:/user/login";
	}
}
