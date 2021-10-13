package com.manage.service;

import javax.servlet.http.HttpSession;

import com.manage.model.UserDTO;

public interface UserService {
	void join(UserDTO dto);
	boolean login(UserDTO dto, HttpSession session);
	void logout();
	void withdrawal(UserDTO dto); 
}
